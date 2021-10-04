package br.edu.facef.model;

public class Produto {
	
	private Long id;
	
	private String nome;
	
	private String codigo;
	
	private Double valor;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", valor=" + valor + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
