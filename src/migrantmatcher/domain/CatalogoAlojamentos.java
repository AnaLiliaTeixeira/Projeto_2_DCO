package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoAlojamentos extends ListaAjudas{

	private List<Alojamento> catAloj = new ArrayList<>();
	
	public void addAlojamento(int numeroPessoas, Regiao regiao) {
		catAloj.add(new Alojamento(numeroPessoas, regiao));
	}
	
}
