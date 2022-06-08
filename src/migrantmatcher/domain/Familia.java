package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class Familia extends CatalogoMigrantes{

	private int numero_pessoas;
	private String cc_nome;
	private int cc_contacto;
	private List<String> outrosMembros = new ArrayList<>();
	
	public Familia (int numero_pessoas, String cc_nome, int cc_contacto) {
		this.numero_pessoas = numero_pessoas;
		this.cc_nome = cc_nome;
		this.cc_contacto = cc_contacto;
	}
	
	public void addMembro (String nome) {
		outrosMembros.add(nome);
	}
}
