package migrantmatcher.domain;

public class Alojamento {

	private Regiao regiao;
	private int numeroPessoas;
		
	public Alojamento(int numeroPessoas, Regiao regiao) {
		this.numeroPessoas = numeroPessoas;
		this.regiao = regiao;
	}
}