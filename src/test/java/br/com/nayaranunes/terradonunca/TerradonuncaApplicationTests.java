package br.com.nayaranunes.terradonunca;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.model.PlayerRequest;
import br.com.nayaranunes.terradonunca.repository.PlayerRepository;
import br.com.nayaranunes.terradonunca.service.PlayerService;
import br.com.nayaranunes.terradonunca.test.PlayerTest;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;

@SpringBootTest(classes = PlayerTest.class)
class TerradonuncaApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
		A test has three steps:
		1. scenario
		2. action
		3. verification
	*/
}
