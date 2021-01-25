package br.com.jessica.cadastro.pessoa.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jessica.cadastro.pessoa.entity.Pessoa;
import br.com.jessica.cadastro.pessoa.entity.PessoaContato;

public class PessoaContatoDto {

	private Long idContato;
	private String nome;
	private String telefone;
	private String email;
	private Pessoa pessoaContato;

	public PessoaContatoDto() {

	}

	public PessoaContatoDto(PessoaContato pessoaContato) {
		this.idContato = pessoaContato.getIdContato();
		this.nome = pessoaContato.getNome();
		this.telefone = pessoaContato.getTelefone();
		this.email = pessoaContato.getEmail();
		this.pessoaContato = pessoaContato.getPessoaIdContato();
	}

	public Long getIdContato() {
		return idContato;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public Pessoa getPessoaContato() {
		return pessoaContato;
	}

	public static List<Object> converter(List<PessoaContato> pessoasContato) {
		return pessoasContato.stream().map(PessoaContatoDto::new).collect(Collectors.toList());
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPessoaContato(Pessoa pessoaContato) {
		this.pessoaContato = pessoaContato;
	}

	
}
