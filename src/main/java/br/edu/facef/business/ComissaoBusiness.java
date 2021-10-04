package br.edu.facef.business;

import br.edu.facef.dao.ComissaoDao;
import br.edu.facef.model.Comissao;

public class ComissaoBusiness {

	private ComissaoDao comissaoDao;
	
	public Float totalVendido;
	public Float valorMeta;
	public Float porcentagemComissao;
	public Float valorGanhoComissao;
		
	public ComissaoBusiness(ComissaoDao dao) {
		this.comissaoDao = dao;
	}
	
	public Comissao salvarComissaoVendedor(Comissao comissao) {
		this.totalVendido = comissao.getTotalVendido();
		this.valorMeta = comissao.getValorMeta();
		this.porcentagemComissao = comissao.getPorcentagemComissao();
		
		if(this.totalVendido > this.valorMeta) {
			this.calcularComissao(this.totalVendido, this.porcentagemComissao);
			comissao.setValorGanhoComissao(valorGanhoComissao);
		}
		
		if(this.porcentagemComissao == null || this.valorMeta == null) {
			throw new RuntimeException("Falta informações");
		}
		
		return this.comissaoDao.salvar(comissao);
	}
	
	public Float calcularComissao(Float totalVendido, Float porcentagemComissao) {
		
		this.valorGanhoComissao = (totalVendido * porcentagemComissao)/100 ;
		
		return valorGanhoComissao;
	}
}
