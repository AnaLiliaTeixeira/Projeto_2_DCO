package migrantmatcher.domain;

public class Migrante extends CatalogoMigrantes{

	private String nome;
	private int contacto;
	
	public Migrante(String nome, int contacto) {
		this.nome = nome;
		this.contacto = contacto;
	}

	public String getNome() {
		return this.nome;
	}

	public int getContacto() {
		return this.contacto;
	}

}
