package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;
import com.br.rfaengines.testautomation.selenium.util.ImagensUtil;

public class PesquisarCartaTest extends BaseTest {

	@Test(groups = { "Ligamagic" }, description = "Realizar uma pesquisa com sucesso.")
	public void pesquisarCarta() {

		String nomeDaCarta = "Arcanjo Avacyn";

		CardsPage pesquisa = new CardsPage();

		pesquisa.preencherCampoNomeDoCard(nomeDaCarta)
					.clicarNoBotaoDePesquisaLupa();

		assertTrue(pesquisa.resultadoDaPesquisa()
								.pesquisaRealizadaComSucesso(nomeDaCarta));			
		
		String src = pesquisa.resultadoDaPesquisa().getSrcImagemDaCarta();
		
		StringBuilder dirDestino = new StringBuilder();

		dirDestino.append(ReportTestManager.getDirEvidencias().replace("evidencias", ""))
					.append("imgs-cards/").append(nomeDaCarta.toLowerCase().replace(" ", "-"));
		
		ImagensUtil.salvarWebImagem(src, dirDestino.toString());
		
		StringBuilder resultado = new StringBuilder();

		resultado.append("<b> PT-BR Nome: </b> ")
					.append(nomeDaCarta).append("<br> <b> ENG-US Nome:  </b>")
						.append(pesquisa.resultadoDaPesquisa().getNomeDoCardEmENG())
							.append("<br><b>Menor Preco: </b>")
								.append("<br>");

		ReportTestManager.adicionarEvidencia(resultado.toString());		

	}

}
