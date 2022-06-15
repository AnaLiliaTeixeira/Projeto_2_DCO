package migrantmatcher.strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.Item;

public class OrdenaAjudasPorAlojamentosEItens implements OrdenaAjudasStrategy {

	private List<Ajuda> listaAjudas = new ArrayList<>();
	
	@Override
	public List<Ajuda> ordenaAjudas(CatalogoAlojamentos catAloj, CatalogoItens catItens) {
		
		Collections.shuffle(catAloj.getCatalogoAlojamentos());
		Collections.shuffle(catItens.getCatalogoItens());
		
		for (Alojamento aloj : catAloj.getCatalogoAlojamentos()) {
			listaAjudas.add(aloj);
		}
		
		for (Item item : catItens.getCatalogoItens()) {
			listaAjudas.add(item);
		}
		
		return listaAjudas;
	}

}
