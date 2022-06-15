package migrantmatcher.controllers;

import java.util.List;

import migrantmatcher.domain.Alojamento;
import migrantmatcher.domain.CatalogoAlojamentos;
import migrantmatcher.domain.CatalogoItens;
import migrantmatcher.domain.CatalogoVoluntarios;
import migrantmatcher.domain.Item;
import migrantmatcher.domain.ListaRegioes;
import migrantmatcher.domain.Regiao;
import migrantmatcher.domain.Voluntario;
import migrantmatcher.exceptions.RegiaoNaoDisponivelException;

public class RegistaAjudaHandler {
	
	private CatalogoVoluntarios catVoluntarios;
	private ListaRegioes lr = new ListaRegioes();
	private CatalogoAlojamentos catAloj;
	private CatalogoItens catItens;
	
	public RegistaAjudaHandler(CatalogoVoluntarios catVoluntarios, CatalogoItens catItens, CatalogoAlojamentos catAloj) {
		this.catVoluntarios = catVoluntarios;
		this.catItens = catItens;
		this.catAloj = catAloj;
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
	public void indicaRegiao(String nomeRegiao, List<Regiao> listaRegioes, Alojamento aloj) throws RegiaoNaoDisponivelException{
			
		boolean existeRegiao = false;
		
		for (Regiao regiao : listaRegioes) {
			if (regiao.getRegiao().equals(nomeRegiao)) {
				aloj.setRegiao(regiao);
				catAloj.addAlojamento(aloj);
				existeRegiao = true;
			}
		}
		if (!existeRegiao) throw new RegiaoNaoDisponivelException();
		
	}

	public void indicaDescricaoItem(Item item) {
		catItens.addItem(item);
	}

	public void confirmaAjuda(int codigo_indicado, int codigo_unico) {
		if (codigo_indicado == codigo_unico) {
			//TODO
		}
	}
	
	public CatalogoVoluntarios getCatalogoVoluntarios() {
		return this.catVoluntarios;
	}
	
	public CatalogoItens getCatalogoItens() {
		return this.catItens;
	}
	
	public CatalogoAlojamentos getCatalogoAlojamentos() {
		return this.catAloj;
	}


}
