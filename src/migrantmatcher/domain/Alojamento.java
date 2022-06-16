package migrantmatcher.domain;

import java.time.LocalDateTime;

public class Alojamento extends Ajuda {

	private Regiao regiao;
	private int numeroPessoas;
	private Voluntario voluntario;	
	private LocalDateTime createdTime;
	
	public Alojamento(int numeroPessoas, Regiao regiao, Voluntario voluntario) {
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
	
	public Voluntario getVoluntario() {
		return voluntario;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

}
