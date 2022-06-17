package migrantmatcher.domain;

import java.time.LocalDateTime;

public class Item extends Ajuda {

	private String descricao;
	
	public Item(String descricao, Voluntario voluntario) {
		this.nome = "Item";
		this.descricao = descricao;
		this.voluntario = voluntario;
		this.createdTime = LocalDateTime.now();
	}

	public String getDescricao() {
		return descricao;
	}

}
