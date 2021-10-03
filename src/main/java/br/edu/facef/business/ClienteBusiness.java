package br.edu.facef.business;

import br.edu.facef.dao.ClienteDao;
import br.edu.facef.model.Cliente;

public class ClienteBusiness {
	
	private ClienteDao clienteDao;
	
	public ClienteBusiness(ClienteDao dao) {
		this.clienteDao = dao;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		if(cliente == null) {
			System.out.println("IF clientedddddddd" + cliente);
			throw new RuntimeException("Cliente é obrigatorio");
		}
		
		if(cliente.getNome() == null) {
			throw new RuntimeException("Nome é obrigatorio");
		}
		
		return this.clienteDao.salvar(cliente);
	}
}
