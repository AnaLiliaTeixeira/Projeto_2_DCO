package migrantmatcher.fakevoluntario;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.telegramsms.TelegramSMSSender;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class Main {
	public static void main(String[] args) throws RegiaoNaoDisponivelException {
		
		RegistaAjudaHandler rah = new MigrantMatcher().getRegistaAjudaHandler();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		if (rd.nextBoolean()) {
			int contacto = sc.nextInt();
			Voluntario vol = rah.identificaVoluntario(contacto);	
		}
		//LER DO FICHEIRO PROPERTIES
		String ajuda = sc.nextLine();
		
		if (ajuda == "alojamento") {
			int numeroPessoas = sc.nextInt();
			
			List<Regiao> lr = rah.indicaNumeroPessoas(numeroPessoas); //ListaRegiao
			String regiao = sc.nextLine();
			Regiao reg = rah.indicaRegiao(regiao);	
			CatalogoAlojamentos cal = new CatalogoAlojamentos();
			cal.addAlojamento(numeroPessoas, reg);
		}
		else {
			String descricao = sc.nextLine();
			rah.indicaDescricaoItem(descricao);
		}
		
		TelegramSMSSender smsSender = new TelegramSMSSender();
		int codigo_unico = (rd.nextInt(999999) + 1);
		String.format("%06d", codigo_unico);
		smsSender.setNumber(new StringBuilder(codigo_unico).toString());
		smsSender.send();
		
		int codigo_inserido = sc.nextInt();
		rah.confirmaAjuda(codigo_inserido, codigo_unico);
		
		sc.close();
	}
}
