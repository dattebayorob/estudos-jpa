package com.dtb.estudosjpa.model.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.estudosjpa.model.entities.Filho;
import com.dtb.estudosjpa.model.entities.Pai;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PaiRepositoryTest {
	@Autowired
	private PaiRepository repository;
	private Pai pai;
	private Filho filho;
	
	@Before
	public void init() {
		pai = new Pai();
		pai.setNome("Mr Catra");
		filho = new Filho();
		filho.setNome("Ted");
	}
	
	@Test
	public void testSaveSemFilho() {
		assertNotNull(repository.save(pai).getId());
	}
	
	@Test
	public void testSaveComFilho() {
		pai.getFilhos().add(filho);
		repository.save(pai);
		assertNotNull(pai.getId());
		assertFalse(pai.getFilhos().isEmpty());
	}
}
