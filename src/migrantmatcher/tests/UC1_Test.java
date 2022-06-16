package migrantmatcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.controllers.ProcuraAjudaHandler;
import migrantmatcher.controllers.RegistaAjudaHandler;
import migrantmatcher.domain.Ajuda;
import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.Migrante;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.AjudaNaoDefinidaException;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;
import migrantmatcher.strategies.OrdenaAjudasPorDataDeDisponibilizacao;

class UC1_Test {

    private MigrantMatcher migMatcher = new MigrantMatcher();
    private RegistaAjudaHandler registaHandler = migMatcher.getRegistaAjudaHandler();
	
	/**
	 * Verifica se um voluntario foi identificado corretamente.
	 */
	@Test
	void testVoluntarioIdentificado() {

		int contacto = 123456789;
		Voluntario vol = registaHandler.identificaVoluntario(contacto);

		assertEquals(vol, migMatcher.getCatalogoVoluntarios().getVoluntario(contacto));

	}

	/**
	 * Testa se uma exceção é levantada caso seja indicada uma região
	 * que não esteja na lista de regiões possíveis.
	 */
	@Test
	void testRegiaoNaoDisponivel() {

		int contacto = 123456789;
		Voluntario vol = registaHandler.identificaVoluntario(contacto);
		int numeroPessoas = 3;
		List<Regiao> lr = registaHandler.indicaNumeroPessoas(numeroPessoas);

		assertThrows(RegiaoNaoDisponivelException.class, () -> {
			registaHandler.indicaRegiao("SUL", lr, numeroPessoas, vol);
		});
	}

	/**
	 * Testa se os Voluntarios e os respetivos itens oferecidos foram colocados
	 * no catálogo de itens.
	 */
	@Test
	void testOferecerItem() {		

		int contacto1 = 123456789;
		int contacto2 = 457667789;
		
		Voluntario vol1 = registaHandler.identificaVoluntario(contacto1);
		Voluntario vol2 = registaHandler.identificaVoluntario(contacto2);

		Item item1 = registaHandler.indicaDescricaoItem("banana", vol1);
		Item item2 = registaHandler.indicaDescricaoItem("coentros", vol2);
		Item item3 = registaHandler.indicaDescricaoItem("pao", vol1);

		assertEquals(true, migMatcher.getCatalogoItens().getListaItens().contains(item1)); //Verifica se o item está no catálogo de itens
		assertEquals(true, migMatcher.getCatalogoItens().getListaItens().contains(item2)); //Verifica se o item está no catálogo de itens
		assertEquals(true, migMatcher.getCatalogoItens().getListaItens().contains(item3)); //Verifica se o item está no catálogo de itens

		assertEquals(true, migMatcher.getCatalogoItens().getListaItens().get(0).getVoluntario().getContacto() == contacto1); //Verifica se o item pertence ao respetivo voluntário
		assertEquals(true, migMatcher.getCatalogoItens().getListaItens().get(1).getVoluntario().getContacto() == contacto2); //Verifica se o item pertence ao respetivo voluntário
		assertEquals(true, migMatcher.getCatalogoItens().getListaItens().get(2).getVoluntario().getContacto() == contacto1); //Verifica se o item pertence ao respetivo voluntário
	}

	/**
	 * Testa se os Voluntarios e os respetivos alojamentos oferecidos foram colocados
	 * no catálogo de alojamentos.
	 */
	@Test
	void testOferecerAlojamento() throws RegiaoNaoDisponivelException {

		int contacto = 123456789;
		Voluntario vol = registaHandler.identificaVoluntario(contacto);
		int numeroPessoas = 5;
		List<Regiao> lr = registaHandler.indicaNumeroPessoas(numeroPessoas);
		Alojamento aloj = migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr, numeroPessoas, vol);
		
		assertEquals(true, migMatcher.getCatalogoAlojamentos().getListaAlojamentos().contains(aloj));
		assertEquals(true, migMatcher.getCatalogoAlojamentos().getListaAlojamentos().get(0).getVoluntario().getContacto() == contacto);

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