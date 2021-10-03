package br.edu.facef.dao;

import br.edu.facef.model.Cliente;

public class ClienteDao {
	
	public Cliente salvar(final Cliente cliente) {
		cliente.setId(999L);
		
		//TODO: chamar função salvar bd
		return cliente;
	}

}	
