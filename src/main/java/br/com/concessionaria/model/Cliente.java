package br.com.concessionaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(allocationSize = 1, name = "carro", sequenceName = "sq_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(generator = "carro", strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name = "ds_cpf")
	private String cpf;
	
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_telefone")
	private String telefone;
	
	//boolean para validar se é a primeira compra do cliente
	private boolean primeira;
	
	public Cliente() {
		super();
	}
	
	public Cliente(Long id, String nome, String cpf, String email, String telefone, boolean primeira) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.primeira = primeira;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isPrimeira() {
		return primeira;
	}

	public void setPrimeira(boolean primeira) {
		this.primeira = primeira;
	}

}
