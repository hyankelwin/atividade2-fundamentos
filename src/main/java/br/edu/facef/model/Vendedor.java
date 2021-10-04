package br.edu.facef.model;

public class Vendedor {

	private Long id;
	
	private String nome;
	
	private Float salario;
	
	private String cargo;
	
	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", salario=" + salario + ", cargo=" + cargo + "]";
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

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
