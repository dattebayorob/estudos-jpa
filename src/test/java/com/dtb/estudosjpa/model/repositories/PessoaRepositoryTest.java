package com.dtb.estudosjpa.model.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.estudosjpa.model.entities.Amizade;
import com.dtb.estudosjpa.model.entities.Endereco;
import com.dtb.estudosjpa.model.entities.Pessoa;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PessoaRepositoryTest {
	@Autowired
	private PessoaRepository repository;
	@Autowired
	private AmizadeRepository amizadeRepository;
	private static final Log log = LogFactory.getLog(PessoaRepositoryTest.class);
	
	private Pessoa pessoa;
	private Pessoa amigo;
	@Before
	public void init() {
		log.info("Inicializando entidades de teste ( Já que o testSave já está ok )");
		pessoa = new Pessoa();
		pessoa.setEndereco(new Endereco("Rua de Testes", "1 T", "Bairro de Testes"));
		amigo = new Pessoa();
		amigo.setEndereco(new Endereco("Rua do amigo", "1", "Bairro do amigo"));
		repository.save(pessoa);
		repository.save(amigo);
	}
	
	@Test
	public void testSave() {
		log.info("Testando repository.save. Persistencia do endereço deve ser automatica");
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setEndereco(new Endereco("Rua de Testes 3", "1 T", "Bairro de Testes"));
		repository.save(novaPessoa);
		assertNotNull(novaPessoa.getId());
		assertNotNull(novaPessoa.getEndereco().getId());
		assertNotNull(pessoa.getId());
		assertNotNull(amigo.getId());
	}
	@Test
	public void testFindById() {
		log.info("Testando repository.findById. ");
		//OSIV precisa ser estudado a fundo.
		Optional<Pessoa> pessoa = repository.findById(Long.valueOf(1));
		assertTrue(pessoa.isPresent());
	}
	@Test
	public void testSaveAmigos() {
		log.info("Testando OneToMany.");
		pessoa.getAmizades().add(amizadeRepository.save(new Amizade(pessoa, amigo)));
		repository.save(pessoa);
		pessoa.getAmizades().forEach(amizade -> System.out.println(amizade.getId()));
		assertNotNull(pessoa.getAmizades().get(0).getId());
	}
}
