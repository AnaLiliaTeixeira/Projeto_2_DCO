package migrantmatcher.domain;

public class Item extends Ajuda{

	private String descricao;
	
	public Item(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
