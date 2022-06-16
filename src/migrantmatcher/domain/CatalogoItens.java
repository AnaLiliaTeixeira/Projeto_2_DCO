package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoItens {

	List<Item> catItens = new ArrayList<>();
		
	public void addItem(Item item) {	
		catItens.add(item);
	}
	
	public List<Item> getListaItens() {
		return this.catItens;
	}
}