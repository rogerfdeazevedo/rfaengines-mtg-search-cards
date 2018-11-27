package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;

public class PesquisarMenorPrecoAlertaTest extends BaseTest {

	@Test(groups = { "Ligamagic" }, description = "Pesquisar o menor preço uma carta.")
	public void pesquisarMenorPreco() {
		
		String nomeDaCarta = "Arcanjo Avacyn";

		CardsPage pesquisa = new CardsPage();

		pesquisa.preencherCampoNomeDoCard(nomeDaCarta)
					.clicarNoBotaoDePesquisaLupa();
		
		assertTrue(pesquisa.resultadoDaPesquisa()
								.pesquisaRealizadaComSucesso(nomeDaCarta));				
		
		StringBuilder resultado = new StringBuilder();

		resultado.append("<b> PT-BR Nome: </b> ")
					.append(nomeDaCarta).append("<br> <b> ENG-US Nome:  </b>")
						.append(pesquisa.resultadoDaPesquisa().getNomeDoCardEmENG())
							.append("<br><b>Menor Preco: </b>")
								.append(pesquisa.resultadoDaPesquisa().alertaDePreco().getMenorPreco())
									.append("<br>");

		ReportTestManager.adicionarEvidencia(resultado.toString());	
		
	}

}
