package br.edu.facef.dao;

import br.edu.facef.model.Comissao;

public class ComissaoDao {
	public Comissao salvar(final Comissao comissao) {
		comissao.setId(1L);
		
		return comissao;
	}
}
