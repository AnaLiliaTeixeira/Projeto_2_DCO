package migrantmatcher.domain;

import java.time.LocalDateTime;

public class Ajuda {

	private String nome;
	private LocalDateTime getCreatedTime;
	
	public Ajuda(String ajuda) {
		this.nome = ajuda;
	}
	
	public Ajuda() {
		//Do nothing
	}
	
	public boolean equalsAjuda(Object other) {
		return this == other || (other instanceof Ajuda)
				&& this.nome.equals(((Ajuda)other).nome);
	}

	public LocalDateTime getCreatedTime() {
		return getCreatedTime;
	}
}
