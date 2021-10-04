package br.edu.facef.business;

import br.edu.facef.dao.VendedorDao;
import br.edu.facef.model.Vendedor;

public class VendedorBusiness {
	
	private VendedorDao vendedorDao;
	
	public VendedorBusiness(VendedorDao dao) {
		this.vendedorDao = dao;
	}
	
	public Vendedor salvarVendedor(Vendedor vendedor) {
		
		if(vendedor == null) {
			throw new RuntimeException("Não recebido o cadastro do vendedor!");
		}
		
		if(vendedor.getCargo() == null) {
			throw new RuntimeException("Vendedor deve ter um cargo!");
		}
		
		return this.vendedorDao.salvar(vendedor);
	}
}
