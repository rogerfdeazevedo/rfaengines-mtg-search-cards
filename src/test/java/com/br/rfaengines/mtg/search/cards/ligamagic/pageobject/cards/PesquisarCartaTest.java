package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;

public class PesquisarCartaTest extends BaseTest {

	@Test(groups = { "Ligamagic" }, description = "Realizar uma pesquisa com sucesso.")
	public void pesquisarCarta() {

		String nomeDaCarta = "Arcanjo Avacyn";

		CardsPage pesquisa = new CardsPage();

		pesquisa.preencherCampoNomeDoCard(nomeDaCarta).clicarNoBotaoDePesquisaLupa();

		assertTrue(pesquisa.pesquisaRealizadaComSucesso(nomeDaCarta));		
		
		StringBuilder resultado = new StringBuilder();

		resultado.append("<b> PT-BR Nome: </b> ").append(nomeDaCarta).append("<br> <b> ENG-US Nome:  </b>")
				.append(pesquisa.getNomeDoCardEmENG()).append("<br>");

		ReportTestManager.adicionarEvidencia(resultado.toString());		

	}

}
