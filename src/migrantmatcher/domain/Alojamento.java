package migrantmatcher.domain;

import java.time.LocalDateTime;

public class Alojamento extends Ajuda {

	private Regiao regiao;
	private int numeroPessoas;
	
	public Alojamento(int numeroPessoas, Regiao regiao, Voluntario voluntario) {
		this.nome = "Alojamento";
		this.numeroPessoas = numeroPessoas;
		this.regiao = regiao;
		this.voluntario = voluntario;
		this.createdTime = LocalDateTime.now();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public int getNumeroPessoas() {
		return numeroPessoas;
	}

}
