package br.edu.facef.business;

import br.edu.facef.dao.VendaDao;
import br.edu.facef.model.Venda;

public class EfetuarVendaBusiness {
	
	private VendaDao VendaDao;
	
	public EfetuarVendaBusiness(VendaDao dao) {
		this.VendaDao = dao;
	}
	
	public Venda efetuarVenda(Venda venda) {
		if(venda == null) {
			throw new RuntimeException("Informe os dados da venda");
		}
		
		if(venda.getTotal() == null) {
			throw new RuntimeException("Total da venda é obrigatorio");
		}

		return this.VendaDao.efetuar(venda);
	}
}
