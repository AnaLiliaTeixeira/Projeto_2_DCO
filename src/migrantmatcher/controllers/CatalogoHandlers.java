package migrantmatcher.controllers;

import java.util.ArrayList;
import java.util.List;

public class CatalogoHandlers {

	private List<Handler> catHandlers = new ArrayList<>();
	
	public void addHandler(Handler h) {
		catHandlers.add(h);
	}
}
