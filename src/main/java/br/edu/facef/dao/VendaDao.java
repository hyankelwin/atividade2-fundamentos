package br.edu.facef.dao;

import br.edu.facef.model.Venda;

public class VendaDao {
	
	public Venda efetuar(final Venda venda) {
		venda.setId(999L);
		
		//TODO: chamar função salvar bd
		return venda;
	}

}	
