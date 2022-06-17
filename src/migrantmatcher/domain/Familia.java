package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class Familia extends PessoaMigrante {

	private int numero_pessoas;
	private String cc_nome;
	private int cc_contacto;
	private List<Membro> outrosMembros = new ArrayList<>();
	
	public Familia (int numero_pessoas) {
		this.numero_pessoas = numero_pessoas;
	}
	
	public void addMembro(Membro membro) {
		outrosMembros.add(membro);
	}

	public void setCC_contacto(int cc_contacto) {
		this.cc_contacto = cc_contacto;
	}

	public void setCC_nome(String cc_nome) {
		this.cc_nome = cc_nome;
	}

	public int getNumero_pessoas() {
		return numero_pessoas;
	}

	public String getCC_nome() {
		return cc_nome;
	}

	public int getCC_contacto() {
		return cc_contacto;
	}
}
