package migrantmatcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;
import migrantmatcher.strategies.OrdenaAjudasPorDataDeDisponibilizacao;

class UC2_Test {

    private MigrantMatcher migMatcher = new MigrantMatcher();
    private RegistaAjudaHandler registaHandler = migMatcher.getRegistaAjudaHandler();
    private ProcuraAjudaHandler procuraHandler = migMatcher.getProcuraAjudaHandler();

	/**
	 * Verifica se a lista de ajudas está a ser corretamente ordenada
	 * pela data de disponibilização da ajuda.
	 * 
	 * @throws RegiaoNaoDisponivelException
	 * @throws AjudaNaoDefinidaException
	 */
	@Test
	void testListaAjudasOrdenadaPorDataDeDisponibilizacao() throws RegiaoNaoDisponivelException, AjudaNaoDefinidaException {
				
		int contacto1 = 123456789;
		int contacto2 = 457667789;
		int contacto3 = 563828910;
		
		int numeroPessoas1 = 5;
		int numeroPessoas2 = 3;
		
		Voluntario vol1 = registaHandler.identificaVoluntario(contacto1);
		Voluntario vol2 = registaHandler.identificaVoluntario(contacto2);
		Voluntario vol3 = registaHandler.identificaVoluntario(contacto3);
		
		List<Regiao> lr = procuraHandler.pedeListaRegioesPossiveis();
		
		Item item1 = registaHandler.indicaDescricaoItem("banana", vol1);
		Alojamento aloj1 = migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, numeroPessoas1, vol1);
		Item item2 = registaHandler.indicaDescricaoItem("coentros", vol2);
		migMatcher.getRegistaAjudaHandler().indicaRegiao("REGIÃO_AUTÓNOMA_DOS_AÇORES", lr, numeroPessoas2, vol3);
		Item item3 = registaHandler.indicaDescricaoItem("pao", vol1);
		
		String nomeRegiao = "CENTRO";
		List<Ajuda> listaAjudas = procuraHandler.indicaRegiaoEscolhida(nomeRegiao, lr, new OrdenaAjudasPorDataDeDisponibilizacao());
		List<Ajuda> listaAjudasExpected = new ArrayList<>();
		listaAjudasExpected.add(item1);
		listaAjudasExpected.add(aloj1);
		listaAjudasExpected.add(item2);
		listaAjudasExpected.add(item3);

		assertEquals(listaAjudasExpected, listaAjudas);
	}
    
    
//	@Test
//	void testListaAjudasOrdenadaPorDataDisponibilidade() throws RegiaoNaoDisponivelException {
//		
//		MigrantMatcher migMatcher = new MigrantMatcher();
//		
//		Voluntario vol1 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(1234);
//		Voluntario vol2 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(12345);
//		Voluntario vol3 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(123456);
//		
//		List<Regiao> lr = migMatcher.getRegistaAjudaHandler().indicaNumeroPessoas(3);
//		
//		Alojamento aloj1 = new Alojamento(3, vol1);
//		Alojamento aloj2 = new Alojamento(4, vol2);
//		Alojamento aloj3 = new Alojamento(7, vol1);
//		Alojamento aloj4 = new Alojamento(7, vol3);
//		
//		migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, aloj1);
//		migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, aloj2);
//		migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, aloj3);
//		migMatcher.getRegistaAjudaHandler().indicaRegiao("NORTE", lr, aloj4);
//		
//		migMatcher.getRegistaAjudaHandler().indicaDescricaoItem(new Item("banana", vol3));
//		
//		//List<Ajuda> la = migMatcher.getProcuraAjudaHandler().indicaRegiaoEscolhida("CENTRO", lr, strat);
//		
//	}

}
