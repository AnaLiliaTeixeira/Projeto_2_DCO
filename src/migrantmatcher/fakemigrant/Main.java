package migrantmatcher.fakemigrant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.Regiao;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;
import migrantmatcher.strategies.OrdenaAjudasStrategy;

public class Main {


	public static void main(String[] args) throws RegiaoNaoDisponivelException {

		ProcuraAjudaHandler handler = new ProcuraAjudaHandler();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		Properties prop = new Properties();

//		try {
			//prop.load(new FileInputStream(new File("migrantmatcher.properties.prop_migrant.properties")));
			
			System.out.println("Deseja fazer um registo individual ou familiar? (Opções de resposta Individual | Familiar)");
			String registo = sc.nextLine();
			
			if (registo.equals("Individual")) {
				
				System.out.print("Insira o seu nome: ");
				String nome = sc.nextLine();
				System.out.print("Insira o seu contacto: ");
				int contacto = sc.nextInt();
				handler.registaMigrante(nome, contacto);
				
			}
			else {
				System.out.print("Indique o número de pessoas: ");
				int numeroPessoas = sc.nextInt();
				Familia f = new Familia(numeroPessoas);
				System.out.print("Indique o nome do cabeça de casal: ");
				String nomeCC = sc.nextLine();
				System.out.print("Indique o contacto do cabeça de casal: ");
				int contactoCC = sc.nextInt();
				handler.indicaDadosCasal(f, nomeCC, contactoCC);
				boolean continuar = true;
				
				while (continuar) {
					
					System.out.print("Indique o nome do outro membro: ");
					String nomeOutroMembro = sc.nextLine();
					handler.indicaOutroMembro(f, nomeOutroMembro);
					System.out.print("\n Deseja continuar (S | N): ");
					
					if (sc.nextLine().equals("N")) {
						continuar = false;
					}
				}
				
				handler.registaFamilia(f);
			}

			List<Regiao> lr = handler.pedeListaRegioesPossiveis();
			System.out.print("Indique a região para onde se pretende mover: ");
			String regiao = sc.nextLine();
			//List<Ajuda> la;
//			String className = prop.getProperty("strategy");
//			
//			Optional<Object> classInstance = createInstanceOfClass(className);
//			classInstance.ifPresent((o) -> {
//				OrdenaAjudasStrategy strat = (OrdenaAjudasStrategy) o;
//				try {
//					List<Ajuda> la = handler.indicaRegiaoEscolhida(regiao, lr, strat);
//				} catch (RegiaoNaoDisponivelException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
			
			//List<Ajuda> la = handler.indicaRegiaoEscolhida(regiao, lr);
			
			
//			List<Ajuda> ajudasNecessarias = new ArrayList<>();
//			String ajuda = sc.nextLine();
//			
//			
//			handler.confirmaPedidoAjuda(ajudasNecessarias);

//		} catch (AjudaNaoDefinidaException e) {
//			//Do nothing
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

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
