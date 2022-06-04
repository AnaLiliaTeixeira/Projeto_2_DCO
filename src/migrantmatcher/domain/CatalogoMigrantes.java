package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMigrantes {

	private List<Migrante> catMigrantes = new ArrayList<>();
	
	public void addMigrante(Migrante m) {
		catMigrantes.add(m);		
	}

}
