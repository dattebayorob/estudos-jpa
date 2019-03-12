package com.dtb.estudosjpa.model.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
public class FilhoRepositoryTest {
	@Autowired
	private FilhoRepository repository;
	@Autowired
	private PaiRepository paiRepository;
	private Filho filho;
	private Pai pai;

	@Before
	public void init() {
		filho = new Filho();
		filho.setNome("Ted");
		pai = new Pai();
		pai.setNome("Mr Catra");
	}

	@Test
	public void testSaveFilhoSemPai() {
		assertNotNull(repository.save(filho).getId());
		assertNull(filho.getPai());
	}

	@Test
	public void testSaveFilhoComPai() {
		filho.setPai(paiRepository.save(pai));
		assertNotNull(repository.save(filho));
		assertNotNull(filho.getPai().getId());
	}
}
