package migrantmatcher.fakemigrant;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.Regiao;

public class Main {

	public static void main(String[] args) {
		
		ProcuraAjudaHandler handler = new ProcuraAjudaHandler();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		if (rd.nextBoolean()) {
			String nome = sc.nextLine();
			int contacto = sc.nextInt();
			handler.registaMigrante(nome, contacto);
		}
		else {
			int numeroPessoas = sc.nextInt();
			handler.registaFamilia(numeroPessoas);
			String nome = sc.nextLine();
			int contacto = sc.nextInt();
			handler.indicaDadosCasal(nome, contacto);
			
			do {
				handler.indicaOutroMembro(nome);
			} while (1==1/*migrante não deseja terminar*/);
		}
		
		List<Regiao> lr = handler.pedeListaRegioesPossiveis();
		String regiao = sc.nextLine();
		ListaAjudas la = handler.indicaRegiaoEscolhida(regiao);
		String ajuda = sc.nextLine();
		Ajuda a = handler.escolheAjuda(ajuda);
		handler.confirmaPedidoAjuda();
		
	}

}
