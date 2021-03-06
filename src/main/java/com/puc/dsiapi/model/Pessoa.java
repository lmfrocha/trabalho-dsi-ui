package com.puc.dsiapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	@NotNull
	@Size(min = 3, max = 50)
	private String nome;
	
	@Column(name="sobrenome")
	@Size(min =3, max = 120)
	private String sobrenome;
	
	@Column(name="data_nasc")
	@DateTimeFormat(pattern= "dd/MM/yyyy")
	private java.sql.Date dataNasc;

	@Column(name="sexo")
	private String sexo;
	
	@Column(name="telefone")
	private int telefone;
	
	@Column(name="email")
	@UniqueElements
	private String email;
	
	@Column(name="login")
	@UniqueElements
	private String login;
	
	@Column(name="senha")
	private String senha;

	@ManyToOne
	@JoinColumn(name="paciente", referencedColumnName="id")
	private TipoPessoa tipo;
	
	public Pessoa(Long id, @NotNull @Size(min = 3, max = 50) String nome, @Size(min = 3, max = 120) String sobrenome,
			java.sql.Date dataNasc, String sexo, int telefone, @UniqueElements String email,
			@UniqueElements String login, String senha, TipoPessoa tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}
	
//	@ManyToOne
//	@JoinColumn(name="paciente", referencedColumnName="id")
//	private Paciente paciente;
//	
//	@ManyToOne
//	@JoinColumn(name="medico", referencedColumnName="id")
//	private Medico medico;
	
//	public Pessoa(Long id, @NotNull @Size(min = 3, max = 50) String nome, @Size(min = 3, max = 120) String sobrenome,
//			java.sql.Date dataNasc, String sexo, int telefone, @UniqueElements String email, @UniqueElements String login,
//			String senha, @Nullable Paciente paciente, @Nullable Medico medico) {
//		this.id = id;
//		this.nome = nome;
//		this.sobrenome = sobrenome;
//		this.dataNasc = dataNasc;
//		this.sexo = sexo;
//		this.telefone = telefone;
//		this.email = email;
//		this.login = login;
//		this.senha = senha;
//		this.paciente = paciente;
//		this.medico = medico;
//	}
	
	public Pessoa(Long id) {
		this.id = id;
	}
	
	Pessoa(){
		
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(java.sql.Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNasc=" + dataNasc + ", sexo="
				+ sexo + ", telefone=" + telefone + ", email=" + email + ", login=" + login + ", senha=" + senha
				+ ", tipo=" + tipo + "]";
	}

	
	
	
}
