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

import com.dtb.estudosjpa.model.entities.Endereco;
import com.dtb.estudosjpa.model.entities.Pessoa;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PessoaRepositoryTest {
	@Autowired
	private PessoaRepository repository;
	private static final Log log = LogFactory.getLog(PessoaRepositoryTest.class);
	
	private Pessoa pessoa;
	private Endereco endereco;
	@Before
	public void init() {
		pessoa = new Pessoa();
		endereco = new Endereco("Rua de Testes", "1 T", "Bairro de Testes");
	}
	
	@Test
	public void testSave() {
		log.info("Testando repository.save. Persistencia do endereço deve ser automatica");
		pessoa.setEndereco(endereco);
		repository.save(pessoa);
		assertNotNull(pessoa.getId());
		assertNotNull(pessoa.getEndereco().getId());
	}
	@Test
	public void testFindById() {
		log.info("Testando repository.findById. ");
		//OSIV precisa ser estudado a fundo.
		Optional<Pessoa> pessoa = repository.findById(Long.valueOf(1));
		assertTrue(pessoa.isPresent());
	}
}
