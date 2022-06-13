package migrantmatcher.fakemigrant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.Regiao;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class Main {

	public static void main(String[] args) {

		ProcuraAjudaHandler handler = new ProcuraAjudaHandler();
		Random rd = new Random();
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(new File("prop_migrant.properties")));

			if (rd.nextBoolean()) {
				String nome = prop.getProperty("nomeMigrante");
				int contacto = Integer.parseInt(prop.getProperty("contactoMigrante"));
				handler.registaMigrante(nome, contacto);
			}
			else {
				int numeroPessoas = Integer.parseInt(prop.getProperty("numeroPessoas"));
				Familia f = new Familia(numeroPessoas);
				String nomeCC = prop.getProperty("nomeCC");
				int contactoCC = Integer.parseInt(prop.getProperty("contactoCC"));
				handler.indicaDadosCasal(f, nomeCC, contactoCC);
				String nomeOutroMembro;
				
				while((nomeOutroMembro = prop.getProperty("nomeOutroMembro")) != null) {
					handler.indicaOutroMembro(f, nomeOutroMembro);
					
				} // duvida de como ler todas as linhas nomeOutroMembro do file properties
				
				handler.registaFamilia(f);
			}

			List<Regiao> lr = handler.pedeListaRegioesPossiveis();
			String regiao = prop.getProperty("regiao");
			List<Ajuda> la = handler.indicaRegiaoEscolhida(regiao, lr);
			String ajuda = prop.getProperty("ajuda");
			Ajuda a = handler.escolheAjuda(ajuda, la);
			handler.confirmaPedidoAjuda();

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
