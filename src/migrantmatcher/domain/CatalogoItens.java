package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoItens extends ListaAjudas {

	List<Item> catItens = new ArrayList<>();
		
	public void addItem(Item item) {	
		catItens.add(item);
	}
	
	public List<Item> getCatalogoItens() {
		return this.catItens;
	}
}