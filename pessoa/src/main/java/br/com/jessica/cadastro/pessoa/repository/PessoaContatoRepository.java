package br.com.jessica.cadastro.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.jessica.cadastro.pessoa.entity.PessoaContato;

@Repository
public interface PessoaContatoRepository extends JpaRepository<PessoaContato, Long> {	
	
	List<PessoaContato> findByNome(String nome);

	List<PessoaContato> findAllByOrderByNomeAsc();
}