package br.edu.facef.model;

public class Venda {
	
	private Long id;
	
	private String clienteId;
	
	private String produtoId;
	
	private Double total;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", clienteId=" + clienteId + ", produtoId=" + produtoId + ", total=" + total + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getProduto() {
		return produtoId;
	}

	public void setProduto(String novoProduto) {
		this.produtoId = novoProduto;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
