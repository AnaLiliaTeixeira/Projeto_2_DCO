package migrantmatcher.domain;

import java.util.HashMap;
import java.util.List;

public class CatalogoItens extends ListaAjudas {

	HashMap<Voluntario, List<Item>> catItens = new HashMap<>();
	
	public void addItem(String descricao, Voluntario vol) {
		List<Item> newList = catItens.get(vol);
		newList.add(new Item(descricao));
		catItens.put(vol, newList);
	}
}