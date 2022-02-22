package br.com.concessionaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
@SequenceGenerator(allocationSize = 1, name = "carro", sequenceName = "sq_carro")
public class Carro {
	
	@Id
	@GeneratedValue(generator = "carro", strategy = GenerationType.IDENTITY)
	@Column(name = "id_carro")
	private Long id;
	
	@Column(name = "ds_categoria")
	private String categoria;
	
	@Column(name = "ds_valor")
	private double valor;
	
	@Column(name = "ds_ano")
	private Integer ano;
	
	@Column(name = "ds_modelo")
	private String modelo;
	
	@Column(name = "ds_marca")
	private String marca;
	
	private boolean disponivel;
	
	public Carro() {}

	public Carro(Long id, String categoria, double valor, Integer ano, String modelo, String marca, boolean disponivel) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.valor = valor;
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.disponivel = disponivel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
