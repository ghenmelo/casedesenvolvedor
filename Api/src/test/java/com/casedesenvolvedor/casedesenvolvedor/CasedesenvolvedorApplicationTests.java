package com.casedesenvolvedor.casedesenvolvedor;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.casedesenvolvedor.casedesenvolvedor.model.Card;
import com.casedesenvolvedor.casedesenvolvedor.repository.CardRepository;
import com.casedesenvolvedor.casedesenvolvedor.support.LeitorCard;

@SpringBootTest
@RunWith(SpringRunner.class)
class CasedesenvolvedorApplicationTests {
	@Autowired
	private CardRepository crudCard;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
    public void contextLoads() {
    }
	
	@Test
	void createCardShouldPersistData() {
		Card newCard = LeitorCard.retornarCard("098756432112019062520190624201906240000001UflaCard");
		this.crudCard.save(newCard);
		Assertions.assertThat(newCard.getConstanteInstituicao()).isNotNull();
		Assertions.assertThat(newCard.getData()).isNotNull();
		Assertions.assertThat(newCard.getNumeroSeqArquivo()).isNotNull();
		Assertions.assertThat(newCard.getNumeroEstabelecimento()).isNotNull();
	}
	
	@Test
	void findAllCardsPrimitivesShouldHaveAllCards() {
		Card newCard = LeitorCard.retornarCard("12019052632165487FagammonCard0002451");
		Card newCard2 = LeitorCard.retornarCard("12019052732165487FagammonCard0002451");
		this.crudCard.save(newCard);
		this.crudCard.save(newCard2);
		List<String> listCard = crudCard.findAllCardsPrimitives();
		Assertions.assertThat(listCard.size()).isEqualTo(2);
	}
	
	

}
