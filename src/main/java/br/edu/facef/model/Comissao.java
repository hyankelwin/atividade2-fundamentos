package br.edu.facef.model;

public class Comissao {

	private Long id;
	
	private Long idVendedor;
	
	private Float porcentagemComissao;

	// Vendedor deve atingir o valor de meta para adquirir a Comissão
	private Float valorMeta;
	
	private Float totalVendido;

	private Float valorGanhoComissao;
	

	@Override
	public String toString() {
		return "Comissao [id=" + id + ", idVendedor=" + idVendedor + ", porcentagemComissao=" + porcentagemComissao
				+ ", valorMeta=" + valorMeta + ", totalVendido=" + totalVendido + ", valorGanhoComissao="
				+ valorGanhoComissao + "]";
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Float getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public void setPorcentagemComissao(Float porcentagemComissao) {
		this.porcentagemComissao = porcentagemComissao;
	}

	public Float getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(Float valorMeta) {
		this.valorMeta = valorMeta;
	}

	public Float getTotalVendido() {
		return totalVendido;
	}

	public void setTotalVendido(Float totalVendido) {
		this.totalVendido = totalVendido;
	}

	public Float getValorGanhoComissao() {
		return valorGanhoComissao;
	}

	public void setValorGanhoComissao(Float valorGanhoComissao) {
		this.valorGanhoComissao = valorGanhoComissao;
	}
	
	
}
