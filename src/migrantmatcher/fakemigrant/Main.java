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
import migrantmatcher.domain.Regiao;
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

			if (rd.nextBoolean()) {
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
					
				} // duvida de como ler todas as linhas nomeOutroMembro do file properties
				
				handler.registaFamilia(f);
			}

			List<Regiao> lr = handler.pedeListaRegioesPossiveis();
			String regiao = sc.nextLine();
			List<Ajuda> la = handler.indicaRegiaoEscolhida(regiao, lr);
			boolean migranteNecessita = true; // verificar quando o migrante necessita
			List<Ajuda> ajudasNecessarias = new ArrayList<>();
			while (migranteNecessita) {
				String ajuda = sc.nextLine();
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
		}

	}

}
