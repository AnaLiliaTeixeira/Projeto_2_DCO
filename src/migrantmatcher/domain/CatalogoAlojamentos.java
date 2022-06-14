package migrantmatcher.domain;

import java.util.HashMap;
import java.util.List;

public class CatalogoAlojamentos extends ListaAjudas{

	private HashMap<Voluntario, List<Alojamento>> catAloj;
	
	public void addAlojamento(int numeroPessoas, Regiao regiao, Voluntario vol) {
		List<Alojamento> newList = catAloj.get(vol);
		newList.add(new Alojamento(numeroPessoas, regiao));
		catAloj.put(vol, newList);
	}
	
}
