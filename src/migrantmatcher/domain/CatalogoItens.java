package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoItens extends ListaAjudas{

	private List<Item> catItens = new ArrayList<>();
	
	public void addItem(String descricao) {
		catItens.add(new Item(descricao));
	}
}
