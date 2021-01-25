package br.com.jessica.cadastro.pessoa.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.jessica.cadastro.pessoa.dto.PessoaContatoDto;
import br.com.jessica.cadastro.pessoa.dto.PessoaDto;
import br.com.jessica.cadastro.pessoa.entity.Pessoa;
import br.com.jessica.cadastro.pessoa.entity.PessoaContato;
import br.com.jessica.cadastro.pessoa.repository.PessoaContatoRepository;
import br.com.jessica.cadastro.pessoa.repository.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private PessoaContatoRepository pessoaContatoRepository;

	@RequestMapping("/")
	@ResponseBody
	public String getDefault() {
		return "API REST (SPRING BOOT) - CADASTRO DE PESSOAS";
	}

	@RequestMapping(value = "/consultaPessoaCpf", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public List<Object> getConsultaPessoaByCpf(String cpf) {
		System.out.println(cpf);
		if (cpf == null) {
			List<Pessoa> pessoas = pessoaRepository.findAll();
			return PessoaDto.converter(pessoas);
		} else {
			List<Pessoa> pessoas = pessoaRepository.findByCpf(cpf);
			return PessoaDto.converter(pessoas);
		}
	}

	@RequestMapping(value = "/consultaPessoaNome", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public List<Object> getConsultaPessoaByNome(String nome) {
		System.out.println(nome);
		if (nome == null) {
			List<Pessoa> pessoas = pessoaRepository.findAll();
			return PessoaDto.converter(pessoas);
		} else {
			List<Pessoa> pessoas = pessoaRepository.findByNome(nome);
			return PessoaDto.converter(pessoas);
		}
	}

	@RequestMapping(value = "/inserirPessoa", method = RequestMethod.PUT)
	@ResponseBody
	public void salvarPessoa(PessoaDto pessoaDto) {
		boolean valido = validarCamposPessoa(pessoaDto);
		if (valido) {
			Pessoa pes = new Pessoa();
			pes.setCpf(pessoaDto.getCpf());
			pes.setDataNasc(pessoaDto.getDataNasc());
			pes.setNome(pessoaDto.getNome());
			pessoaRepository.save(pes);
		}
	}

	@RequestMapping(value = "/inserirPessoaContato", method = RequestMethod.PUT)
	@ResponseBody
	public void salvarPessoaContato(PessoaContatoDto pessoaContatoDto) {
		boolean valido = validaEmail(pessoaContatoDto.getEmail());
		if (valido) {
			PessoaContato con = new PessoaContato();
			con.setNome(con.getNome());
			con.setEmail(con.getEmail());
			con.setTelefone(con.getTelefone());
			con.setPessoaIdContato(con.getPessoaIdContato());
			pessoaContatoRepository.save(con);
		} else {
			System.out.println("EMAIL inválido!");
		}
	}

	@RequestMapping(value = "/atualizarPessoa", method = RequestMethod.POST)
	@ResponseBody
	public void atualizarPessoa(PessoaDto pessoaDto) {
		boolean valido = validarCamposPessoa(pessoaDto);
		if (valido) {
			Pessoa pes = new Pessoa();
			pes.setCpf(pessoaDto.getCpf());
			pes.setDataNasc(pessoaDto.getDataNasc());
			pes.setNome(pessoaDto.getNome());
			pessoaRepository.save(pes);
		}
	}

	@RequestMapping(value = "/atualizarPessoaContato", method = RequestMethod.POST)
	@ResponseBody
	public void atualizarPessoaContato(PessoaContatoDto pessoaContatoDto) {
		boolean valido = validaEmail(pessoaContatoDto.getEmail());
		if (valido) {
			PessoaContato con = new PessoaContato();
			con.setNome(con.getNome());
			con.setEmail(con.getEmail());
			con.setTelefone(con.getTelefone());
			con.setPessoaIdContato(con.getPessoaIdContato());
			pessoaContatoRepository.save(con);
		} else {
			System.out.println("EMAIL inválido!");
		}
	}
	
	@RequestMapping(value = "/deletarPessoa", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletarPessoa(PessoaDto pessoaDto) {
		pessoaRepository.deleteById(pessoaDto.getIdPessoa());
	}
	
	@RequestMapping(value = "/deletarPessoaContato", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletarPessoaContato(PessoaContatoDto pessoaContatoDto) {
		pessoaContatoRepository.deleteById(pessoaContatoDto.getIdContato());
	}
	

	/**
	 * 
	 * @param pes
	 * @return validacao dos campos pessoa
	 */
	public static boolean validarCamposPessoa(PessoaDto pes) {
		boolean result = true;
		if (!validaCpf(pes.getCpf())) {
			System.out.println("CPF inválido!");
			result = false;
		} else if (!dataNascValida(pes.getDataNasc())) {
			System.out.println("Data Nasc. inválida!");
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * @param cpf
	 * @return validacao cpf
	 */
	public static boolean validaCpf(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param email
	 * @return validacao email
	 */
	public static boolean validaEmail(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * @param dataNasc
	 * @return validacao data nasc
	 */
	public static boolean dataNascValida(LocalDateTime dataNasc) {
		boolean result = true;
		long diferencaDatas = Duration.between(dataNasc, LocalDateTime.now()).toDays();
		if (diferencaDatas < 0) {
			// Caso DIFERENCA menor que 0 (zero) refere a uma dataNasc (parâmetro) superior
			// a data atual
			result = false;
		}
		return result;
	}

}
