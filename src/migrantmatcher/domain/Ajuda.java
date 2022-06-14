package migrantmatcher.domain;

public class Ajuda {

	private String nome;
	
	public Ajuda(String ajuda) {
		this.nome = ajuda;
	}
	
	public Ajuda() {
		//Do nothing
	}
	
	public boolean equals(Object other) {
		return this == other || (other instanceof Ajuda)
				&& this.nome.equals(((Ajuda)other).nome);
	}
}
