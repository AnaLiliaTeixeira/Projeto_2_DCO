package migrantmatcher.domain;

import java.time.LocalDateTime;

public class Item extends Ajuda{

	private String descricao;
	private Voluntario voluntario;
	private LocalDateTime createdTime;
	
	public Item(String descricao, Voluntario voluntario) {
		this.descricao = descricao;
		this.voluntario = voluntario;
		this.createdTime = LocalDateTime.now();
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Voluntario getVoluntario() {
		return voluntario;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
}
