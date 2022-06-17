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
import migrantmatcher.domain.Familia;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.PessoaMigrante;
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
	
	/**
	 * Verifica se um migrante foi registado corretamente
	 */
	@Test
	void testMigranteRegistado() {
		
		PessoaMigrante mig = procuraHandler.registaMigrante("Migrante", 1234);	
		assertEquals(true, migMatcher.getCatalogoMigrantes().getCatMigrantes().contains(mig));
	}
	
	/**
	 * Verifica se uma familia foi registada corretamente
	 */
	@Test
	void testFamiliaRegistada() {
		Familia fam = new Familia(3);
		procuraHandler.registaFamilia(fam);
		procuraHandler.indicaDadosCasal(fam, "cc", 12345);
		procuraHandler.indicaOutroMembro(fam, "membro1");
		procuraHandler.indicaOutroMembro(fam, "membro2");
		
		assertEquals(true, migMatcher.getCatalogoMigrantes().getCatMigrantes().contains(fam));
	}
	
	/**
	 * Verifica se a o pedido de ajuda foi corretamente concluído.
	 * 
	 * @throws RegiaoNaoDisponivelException
	 * @throws AjudaNaoDefinidaException
	 */
	@Test
	void testAjudaConfirmada() throws RegiaoNaoDisponivelException, AjudaNaoDefinidaException {
				
		int contacto1 = 123456789;
		int contacto2 = 457667789;
		int contacto3 = 563828910;
		int contacto4 = 982517848;
		
		int numeroPessoas1 = 5;
		int numeroPessoas2 = 3;
		
		Voluntario vol1 = registaHandler.identificaVoluntario(contacto1);
		Voluntario vol2 = registaHandler.identificaVoluntario(contacto2);
		Voluntario vol3 = registaHandler.identificaVoluntario(contacto3);
		
		List<Regiao> lr = procuraHandler.pedeListaRegioesPossiveis();
		
		registaHandler.indicaDescricaoItem("banana", vol1);
		registaHandler.indicaRegiao("CENTRO", lr, numeroPessoas1, vol1);
		registaHandler.indicaDescricaoItem("coentros", vol2);
		registaHandler.indicaRegiao("REGIÃO_AUTÓNOMA_DOS_AÇORES", lr, numeroPessoas2, vol3);
		registaHandler.indicaDescricaoItem("pao", vol1);
		
		PessoaMigrante pm = procuraHandler.registaMigrante("Migrante1", contacto4);
		
		String nomeRegiao = "CENTRO";
		List<Ajuda> listaAjudas = procuraHandler.indicaRegiaoEscolhida(nomeRegiao, lr, new OrdenaAjudasPorDataDeDisponibilizacao());
		List<Ajuda> ajudasEscolhidas = new ArrayList<>();
		
		Ajuda ajuda1 = procuraHandler.escolheAjuda("Item", listaAjudas);
		ajudasEscolhidas.add(ajuda1);
		Ajuda ajuda2 = procuraHandler.escolheAjuda("Alojamento", listaAjudas);
		ajudasEscolhidas.add(ajuda2);
		
		procuraHandler.confirmaPedidoAjuda(ajudasEscolhidas, pm);
		
		assertEquals(ajudasEscolhidas, pm.getListaAjudasPretendidas());
	}
    
}
