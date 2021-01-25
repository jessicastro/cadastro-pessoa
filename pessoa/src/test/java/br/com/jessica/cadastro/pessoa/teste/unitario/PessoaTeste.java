package br.com.jessica.cadastro.pessoa.teste.unitario;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.jessica.cadastro.pessoa.controller.PessoaController;
import br.com.jessica.cadastro.pessoa.dto.PessoaContatoDto;
import br.com.jessica.cadastro.pessoa.dto.PessoaDto;

class PessoaTeste {

	@Test
	void test() {
		PessoaController p = new PessoaController();

		PessoaDto pes = new PessoaDto();
		PessoaContatoDto con = new PessoaContatoDto();
		// Implementar um objeto PessoaDto para testes
		pes.setCpf("28067480036");
		pes.setDataNasc(LocalDateTime.now());
		pes.setNome("Teste Unitário Pessoa");
		// Implementar um objeto PessoaContatoDto para testes
		con.setEmail("testeUnitario@bol.com");
		con.setNome("Teste Unitário Pessoa Contato");
		con.setTelefone("16992569985");

		// Testar requisicao GET
		List<Object> getDadosTeste = p.getConsultaPessoaByCpf("");
		System.out.println(getDadosTeste);

		// Testar requisicao PUT
		p.salvarPessoa(pes);

		// Testar requisicao PUT
		p.salvarPessoaContato(con);

		// Testar requisicao POST
		p.atualizarPessoa(pes);

		// Testar requisicao POST
		p.atualizarPessoaContato(con);

		// Testar requisicao DELETE
		p.deletarPessoa(pes);

		// Testar requisicao DELETE
		p.deletarPessoaContato(con);

	}

}
