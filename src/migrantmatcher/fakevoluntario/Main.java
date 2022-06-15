package migrantmatcher.fakevoluntario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import com.telegramsms.TelegramSMSSender;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.ListaAjudas;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class Main {
	public static void main(String[] args) throws RegiaoNaoDisponivelException, IOException {
		
		RegistaAjudaHandler handler = new MigrantMatcher().getRegistaAjudaHandler();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("prop_voluntario.properties")));
			
			int contacto = sc.nextInt();
			Voluntario vol = handler.identificaVoluntario(contacto);	
			String classAjuda = sc.nextLine();
			Class<?> ajuda = Class.forName(classAjuda);
			ListaAjudas la = new ListaAjudas();
					
			if (ajuda == migrantmatcher.domain.Alojamento.class) {
				int numeroPessoas = sc.nextInt();
				List<Regiao> lr = handler.indicaNumeroPessoas(numeroPessoas);
				String nomeRegiao = sc.nextLine();
				Alojamento aloj = new Alojamento(numeroPessoas, vol);
				handler.indicaRegiao(nomeRegiao, lr, aloj);	
				
				@SuppressWarnings("unchecked")
				Constructor<Alojamento> construtor = (Constructor<Alojamento>) ajuda.getConstructor();
				Alojamento aloja = construtor.newInstance();
				la.addAjuda(aloja);
			}
			else {
				String descricao = sc.nextLine();
				handler.indicaDescricaoItem(new Item(descricao, vol));
				
				@SuppressWarnings("unchecked")
				Constructor<Item> construtor = (Constructor<Item>) ajuda.getConstructor();
				Item item = construtor.newInstance();
				la.addAjuda(item);
			}
			
			TelegramSMSSender smsSender = new TelegramSMSSender();
			int codigo_unico = (rd.nextInt(999999) + 1);
			String.format("%06d", codigo_unico);
			smsSender.setNumber(new StringBuilder(codigo_unico).toString());
			smsSender.send();
			
			int codigo_inserido = sc.nextInt(); // lê-se do ficheiro properties?
			handler.confirmaAjuda(codigo_inserido, codigo_unico);
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			//Do nothing
		} catch (ClassNotFoundException e) {
			//Do nothing
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
