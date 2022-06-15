package migrantmatcher.tests;

import java.util.List;

import org.junit.jupiter.api.Test;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

class UC2_Test {

	@Test
	void testListaAjudasOrdenadaPorDataDisponibilidade() throws RegiaoNaoDisponivelException {
		
		MigrantMatcher migMatcher = new MigrantMatcher();
		
		Voluntario vol1 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(1234);
		Voluntario vol2 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(12345);
		Voluntario vol3 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(123456);
		
		List<Regiao> lr = migMatcher.getRegistaAjudaHandler().indicaNumeroPessoas(3);
		
		Alojamento aloj1 = new Alojamento(3, vol1);
		Alojamento aloj2 = new Alojamento(4, vol2);
		Alojamento aloj3 = new Alojamento(7, vol1);
		Alojamento aloj4 = new Alojamento(7, vol3);
		
		migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, aloj1);
		migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, aloj2);
		migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, aloj3);
		migMatcher.getRegistaAjudaHandler().indicaRegiao("NORTE", lr, aloj4);
		
		migMatcher.getRegistaAjudaHandler().indicaDescricaoItem(new Item("banana", vol3));
		
		//List<Ajuda> la = migMatcher.getProcuraAjudaHandler().indicaRegiaoEscolhida("CENTRO", lr, strat);
		
	}

}
