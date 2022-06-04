package migrantmatcher;

import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.CatalogoVoluntarios;

public class MigrantMatcher {

	private CatalogoVoluntarios catVoluntario = new CatalogoVoluntarios();

	public RegistaAjudaHandler getRegistaAjudaHandler() {
		return new RegistaAjudaHandler(catVoluntario);
	}
}