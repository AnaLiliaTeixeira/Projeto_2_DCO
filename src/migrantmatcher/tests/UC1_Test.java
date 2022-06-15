package migrantmatcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import migrantmatcher.MigrantMatcher;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

class UC1_Test {

	/**
	 * Verifica se um voluntario foi identificado corretamente.
	 */
	@Test
	void testVoluntarioIdentificado() {

		MigrantMatcher migMatcher = new MigrantMatcher();
		int contacto = 123456789;
		Voluntario vol = migMatcher.getRegistaAjudaHandler().identificaVoluntario(contacto);

		assertEquals(vol, migMatcher.getRegistaAjudaHandler()
				.getCatalogoVoluntarios().getVoluntario(contacto));

	}

	/**
	 * Testa se uma exceção é levantada caso seja indicada uma região
	 * que não esteja na lista de regiões possíveis.
	 */
	@Test
	void testRegiaoNaoDisponivel() {

		MigrantMatcher migMatcher = new MigrantMatcher();

		List<Regiao> lr = migMatcher.getRegistaAjudaHandler().indicaNumeroPessoas(3);

		assertThrows(RegiaoNaoDisponivelException.class, () -> {
			migMatcher.getRegistaAjudaHandler().indicaRegiao("SUL", lr);
		});
	}

	/**
	 * Testa se o Voluntario e o respetivo item oferecido foram colocados
	 * no catálogo de itens.
	 */
	@Test
	void testOferecerItem() {		

		MigrantMatcher migMatcher = new MigrantMatcher();

		Voluntario vol1 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(123456789);
		Voluntario vol2 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(123345345);
		Voluntario vol3 = migMatcher.getRegistaAjudaHandler().identificaVoluntario(457667789);

		Item item1 = new Item("banana", vol1);
		Item item2 = new Item("pao", vol1);
		Item item3 = new Item("coentros", vol2);
		Item item4 = new Item("gelado",vol3);
		Item item5 = new Item("morangos", vol1);

		migMatcher.getCatalogoItens().addItem(item1);
		migMatcher.getCatalogoItens().addItem(item2);
		migMatcher.getCatalogoItens().addItem(item3);
		migMatcher.getCatalogoItens().addItem(item4);
		migMatcher.getCatalogoItens().addItem(item5);

		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().contains(item1)); //Verifica se o item está no catálogo de itens
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().contains(item2)); //Verifica se o item está no catálogo de itens
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().contains(item3)); //Verifica se o item está no catálogo de itens
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().contains(item4)); //Verifica se o item está no catálogo de itens
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().contains(item5)); //Verifica se o item está no catálogo de itens

		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().get(0).getVoluntario().getContacto() == 123456789); //Verifica se o item pertence ao respetivo voluntário
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().get(1).getVoluntario().getContacto() == 123456789); //Verifica se o item pertence ao respetivo voluntário
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().get(2).getVoluntario().getContacto() == 123345345); //Verifica se o item pertence ao respetivo voluntário
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().get(3).getVoluntario().getContacto() == 457667789); //Verifica se o item pertence ao respetivo voluntário
		assertEquals(true, migMatcher.getCatalogoItens().getCatalogoItens().get(4).getVoluntario().getContacto() == 123456789); //Verifica se o item pertence ao respetivo voluntário
	}

	@Test
	void testOferecerAlojamento() throws RegiaoNaoDisponivelException {

		MigrantMatcher migMatcher = new MigrantMatcher();
		Voluntario vol = migMatcher.getRegistaAjudaHandler().identificaVoluntario(123456789);
		List<Regiao> lr = migMatcher.getRegistaAjudaHandler().indicaNumeroPessoas(3);
		//Regiao r = migMatcher.getRegistaAjudaHandler().indicaRegiao("CENTRO", lr);
		CatalogoAlojamentos cal = new CatalogoAlojamentos();
	}
}