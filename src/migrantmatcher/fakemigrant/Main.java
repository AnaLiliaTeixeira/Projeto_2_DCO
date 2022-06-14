package migrantmatcher.fakemigrant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class Main {


	public static void main(String[] args) {

		ProcuraAjudaHandler handler = new ProcuraAjudaHandler();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(new File("prop_migrant.properties")));

//			String nome = sc.nextLine();
//			int contacto = sc.nextInt();
//			handler.registaMigrante(nome, contacto);
			
			String classRegisto = sc.nextLine();
			Class<?> registo = Class.forName(classRegisto);
			
			if (registo == migrantmatcher.domain.Migrante.class) {
				
				String nome = sc.nextLine();
				int contacto = sc.nextInt();
				handler.registaMigrante(nome, contacto);
				
			}
			else {
				int numeroPessoas = sc.nextInt();
				Familia f = new Familia(numeroPessoas);
				String nomeCC = sc.nextLine();
				int contactoCC = sc.nextInt();
				handler.indicaDadosCasal(f, nomeCC, contactoCC);
				String nomeOutroMembro;
				
				while((nomeOutroMembro = sc.nextLine()) != null) {
					handler.indicaOutroMembro(f, nomeOutroMembro);
					
				}
				
				handler.registaFamilia(f);
			}

			List<Regiao> lr = handler.pedeListaRegioesPossiveis();
			String regiao = sc.nextLine();
			List<Ajuda> la = handler.indicaRegiaoEscolhida(regiao, lr);
			List<Ajuda> ajudasNecessarias = new ArrayList<>();
			String ajuda;
			while ((ajuda = sc.nextLine()) != null) {
				Ajuda a = handler.escolheAjuda(ajuda, la);
				ajudasNecessarias.add(a);
			}
			handler.confirmaPedidoAjuda(ajudasNecessarias);

		} catch (FileNotFoundException e) {
			//Do nothing
			e.printStackTrace();
		} catch (IOException e) {
			//Do nothing
			e.printStackTrace();
		} catch (RegiaoNaoDisponivelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AjudaNaoDefinidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
