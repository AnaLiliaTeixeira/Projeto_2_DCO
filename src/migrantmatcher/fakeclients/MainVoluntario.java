package migrantmatcher.fakeclients;


import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.telegramsms.TelegramSMSSender;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class MainVoluntario {
	public static void main(String[] args) throws RegiaoNaoDisponivelException, IOException {

		RegistaAjudaHandler handler = new MigrantMatcher().getRegistaAjudaHandler();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);


		System.out.print("Indique o seu contacto: ");
		int contacto = Integer.parseInt(sc.nextLine());
		Voluntario vol = handler.identificaVoluntario(contacto);	
		System.out.print("Indique a ajuda que pretende oferecer (Alojamento | Item): ");
		String ajuda = sc.nextLine();

		if (ajuda.equals("Alojamento")) {
			System.out.print("Indique o número de pessoas que o alojamento alberga: ");
			int numeroPessoas = Integer.parseInt(sc.nextLine());
			List<Regiao> lr = handler.indicaNumeroPessoas(numeroPessoas);
			System.out.print("Indique a região onde se encontra o alojamento: ");
			String nomeRegiao = sc.nextLine();	
			handler.indicaRegiao(nomeRegiao, lr, numeroPessoas, vol);
		}
		else if (ajuda.equals("Item")){
			System.out.print("Indique a descrição do item: ");
			String descricao = sc.nextLine();
			handler.indicaDescricaoItem(descricao, vol);		
		}
		else {
			System.out.println("Ajuda não disponível. Escolha Alojamento ou Item");
			ajuda = sc.nextLine();
		}

		//TelegramSMSSender smsSender = new TelegramSMSSender();
		int codigo_unico = (rd.nextInt(999999) + 1);
		String.format("%06d", codigo_unico);
//		smsSender.setNumber(Integer.toString(codigo_unico));
//		smsSender.setText(new StringBuilder(codigo_unico).toString());
//		smsSender.send();

		System.out.print("Insira o código único: ");
		int codigo_inserido = Integer.parseInt(sc.nextLine());
		handler.confirmaAjuda(codigo_inserido, codigo_unico);

		sc.close();
	}	
}

