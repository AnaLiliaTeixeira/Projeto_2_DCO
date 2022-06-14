package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoVoluntarios;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class RegistaAjudaHandler {
	private CatalogoVoluntarios catVoluntarios;
	private ListaRegioes lr;
	private CatalogoAlojamentos cal;
	private CatalogoItens catItens;
	
	public RegistaAjudaHandler(CatalogoVoluntarios catVoluntarios) {
		this.catVoluntarios = catVoluntarios;
	}

	/**
	 * Devolve o voluntário com o contacto dado
	 * @param contacto - contacto do voluntario a identificado
	 * @ensures O {@code v}:Voluntário é registado com {@code v.contacto = contacto}
	 * @return o voluntário com o contacto dado
	 */
	public Voluntario identificaVoluntario(int contacto) { // 1
		return catVoluntarios.getVoluntario(contacto);
	}

	/**
	 * 
	 * @param numero
	 * @requires
	 * @ensures
	 * @return
	 */
	public List<Regiao> indicaNumeroPessoas(int numero) {	
		return lr.getListaRegioes();
	}

	/**
	 * Devolve a regiao onde se encontra o alojamento a ser oferecido como ajuda pelo Voluntario.
	 * @param nomeRegiao - nome da regiao onde se encontra o alojamento
	 * @requires
	 * @ensures
	 * @return a regiao que tem {@code nomeRegiao} como nome 
	 * @throws RegiaoNaoDisponivelException
	 */
	public Regiao indicaRegiao(String nomeRegiao) throws RegiaoNaoDisponivelException{
		return lr.getListaRegioes()
			.stream()
			.filter(regiao -> regiao.getRegiao().equals(nomeRegiao))
			.findFirst()
			.orElseThrow();
	}

	public void indicaDescricaoItem(String descricao, Voluntario vol) {
		catItens.addItem(descricao, vol);
	}

	public void confirmaAjuda(int codigo_indicado, int codigo_unico) {
		if (codigo_indicado == codigo_unico) {
			//TODO
		}
	}
}
