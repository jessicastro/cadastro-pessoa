package br.com.jessica.cadastro.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.jessica.cadastro.pessoa.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByCpf(String cpf);
	
	List<Pessoa> findByNome(String nome);

	List<Pessoa> findAllByOrderByCpfAsc();
}