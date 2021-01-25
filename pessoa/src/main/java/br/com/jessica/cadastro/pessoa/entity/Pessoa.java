package br.com.jessica.cadastro.pessoa.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private LocalDateTime dataNasc;
	
	@OneToMany(mappedBy = "pessoaIdContato")
	private List<PessoaContato> pessoaContatoList;

	@Override
	public String toString() {
		return "{ \n " + (char) 34 + "id" + (char) 34 + ": " + (char) 34 + id + (char) 34 + ", \n" + (char) 34
				+ "nome" + (char) 34 + ": " + (char) 34 + nome + (char) 34 + ", \n" + (char) 34 + "CPF" + (char) 34
				+ ": " + (char) 34 + cpf + (char) 34 + ", \n" + (char) 34 + "Data Nasc." + (char) 34 + ": " + (char) 34
				+ dataNasc + (char) 34 + "\n " + '}';
	}

	public Long getId() {
		return id;
	}

	public void setIdPessoa(Long id) {
		this.id= id;
	}

	public List<PessoaContato> getPessoaContatoList() {
		return pessoaContatoList;
	}

	public void setPessoaContatoList(List<PessoaContato> pessoaContatoList) {
		this.pessoaContatoList = pessoaContatoList;
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

	public LocalDateTime getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDateTime dataNasc) {
		this.dataNasc = dataNasc;
	}

}
