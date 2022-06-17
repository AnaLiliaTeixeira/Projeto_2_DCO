package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class PessoaMigrante {

	protected List<Ajuda> listaAjudasPedidas = new ArrayList<>();
	
	public List<Ajuda> getListaAjudasPretendidas() {
		return listaAjudasPedidas;
	}
	
	public List<Ajuda> setListaAjudasPretendidas(List<Ajuda> la) {
		return listaAjudasPedidas = la;
	}

}
