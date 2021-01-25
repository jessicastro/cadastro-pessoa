package br.com.jessica.cadastro.pessoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "PessoaContato")
public class PessoaContato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContato;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String email;
	
	@JoinColumn(name = "pessoaIdContato", referencedColumnName = "id")
    @ManyToOne
    private Pessoa pessoaIdContato;

	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa getPessoaIdContato() {
		return pessoaIdContato;
	}

	public void setPessoaIdContato(Pessoa pessoaIdContato) {
		this.pessoaIdContato = pessoaIdContato;
	}
	

}
