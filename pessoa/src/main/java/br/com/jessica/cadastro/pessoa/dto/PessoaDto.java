package br.com.jessica.cadastro.pessoa.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import br.com.jessica.cadastro.pessoa.entity.Pessoa;
import br.com.jessica.cadastro.pessoa.entity.PessoaContato;

public class PessoaDto {

	private Long idPessoa;
	private String nome;
	private String cpf;
	private LocalDateTime dataNasc;
	private List<PessoaContato> pessoaContatoList;

	public PessoaDto() {

	}

	public PessoaDto(Pessoa pessoa) {
		this.idPessoa = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.dataNasc = pessoa.getDataNasc();
		this.pessoaContatoList = pessoa.getPessoaContatoList();		
	}

	@Override
	public String toString() {
		return "{ \n " + (char) 34 + "id" + (char) 34 + ": " + (char) 34 + idPessoa + (char) 34 + ", \n" + (char) 34 + "nome"
				+ (char) 34 + ": " + (char) 34 + nome + (char) 34 + ", \n" + (char) 34 + "CPF" + (char) 34 + ": "
				+ (char) 34 + cpf + (char) 34 + ", \n" + (char) 34 + "Data Nasc." + (char) 34 + ": " + (char) 34
				+ dataNasc + (char) 34 + "\n " + '}';
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDateTime getDataNasc() {
		return dataNasc;
	}
	
	
	public List<PessoaContato> getPessoaContatoList() {
		return pessoaContatoList;
	}

	public static List<Object> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNasc(LocalDateTime dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setPessoaContatoList(List<PessoaContato> pessoaContatoList) {
		this.pessoaContatoList = pessoaContatoList;
	}		

}
