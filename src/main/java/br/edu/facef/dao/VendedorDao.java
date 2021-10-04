package br.edu.facef.dao;

import br.edu.facef.model.Vendedor;

public class VendedorDao {
	public Vendedor salvar(final Vendedor vendedor) {
		vendedor.setId(1L);
		
		return vendedor;
	}
}
