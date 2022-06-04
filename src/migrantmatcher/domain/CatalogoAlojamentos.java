package migrantmatcher.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoAlojamentos {

private List<Alojamento> cal = new ArrayList<>();
	
	public void addAlojamento(int numeroPessoas, Regiao regiao) {
		cal.add(new Alojamento(numeroPessoas, regiao));
	}
}
