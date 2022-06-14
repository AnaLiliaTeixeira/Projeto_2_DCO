package migrantmatcher.domain;

public class Regiao {
	
	private String nome;
	
	public Regiao(String regiao) {
		this.nome = regiao;
	}

	public String getRegiao() {
		return this.nome;
	}
	
	public boolean equals(Object other) {
		return this == other || (other instanceof Regiao)
				&& this.nome.equals(((Regiao)other).nome);
	}
}
