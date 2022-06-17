package migrantmatcher.fakeclients;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Scanner;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.PessoaMigrante;
import migrantmatcher.domain.Regiao;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;
import migrantmatcher.strategies.OrdenaAjudasStrategy;

public class MainMigrante {


	public static void main(String[] args) throws RegiaoNaoDisponivelException, IOException {

		ProcuraAjudaHandler handler = new MigrantMatcher().getProcuraAjudaHandler();
		Scanner sc = new Scanner(System.in);
		Properties prop = new Properties();

		MainVoluntario.main(args);
		
		try {
			prop.load(new FileInputStream(new File("defaults.properties")));
			
			System.out.print("Deseja fazer um registo individual ou familiar? (Individual | Familiar):");
			String registo = sc.nextLine();
			PessoaMigrante pm;
			
			if (registo.equals("Individual")) {
				
				System.out.print("Insira o seu nome: ");
				String nome = sc.nextLine();
				System.out.print("Insira o seu contacto: ");
				int contacto = Integer.parseInt(sc.nextLine());
				pm = handler.registaMigrante(nome, contacto);
				
			}
			else {
				System.out.print("Indique o número de pessoas: ");
				int numeroPessoas = Integer.parseInt(sc.nextLine());
				Familia f = new Familia(numeroPessoas);
				System.out.print("Indique o nome do cabeça de casal: ");
				String nomeCC = sc.nextLine();
				System.out.print("Indique o contacto do cabeça de casal: ");
				int contactoCC = Integer.parseInt(sc.nextLine());
				handler.indicaDadosCasal(f, nomeCC, contactoCC);
				boolean continuar = true;
				
				while (continuar) {
					
					System.out.print("Indique o nome do outro membro: ");
					String nomeOutroMembro = sc.nextLine();
					handler.indicaOutroMembro(f, nomeOutroMembro);
					System.out.print("\n Deseja continuar? (S | N): ");
					
					if (sc.nextLine().equals("N")) {
						continuar = false;
					}
				}
				
				pm = handler.registaFamilia(f);
			}

			List<Regiao> lr = handler.pedeListaRegioesPossiveis();
			System.out.print("Indique a região para onde se pretende mover: ");
			String regiao = sc.nextLine();

			String className = prop.getProperty("strategy");
			
			Optional<Object> classInstance = createInstanceOfClass(className);
			classInstance.ifPresent((s) -> {
				OrdenaAjudasStrategy strat = (OrdenaAjudasStrategy) s;
				try {
					List<Ajuda> ajudasPossiveis = handler.indicaRegiaoEscolhida(regiao, lr, strat);
					List<Ajuda> ajudasPedidas = new ArrayList<>();
					boolean continuar = true;
					
					while (continuar) {
						
						System.out.print("Indique a ajuda que necessita: ");
						String nomeAjuda = sc.nextLine();
						Ajuda ajuda = handler.escolheAjuda(nomeAjuda, ajudasPossiveis);
						ajudasPedidas.add(ajuda);
						
						System.out.print("\n Deseja pedir mais ajudas? (S | N): ");
						
						if (sc.nextLine().equals("N")) {
							continuar = false;
						}
						
					}
					handler.confirmaPedidoAjuda(ajudasPedidas, pm);
					
				} catch (RegiaoNaoDisponivelException | AjudaNaoDefinidaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();

	}
	
	private static Optional<Object> createInstanceOfClass(String nomeClasse) {
		
		try {
			Class<?> klass = Class.forName(nomeClasse);
			return Optional.of(klass.getConstructor().newInstance());
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |IllegalArgumentException 
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}

}
