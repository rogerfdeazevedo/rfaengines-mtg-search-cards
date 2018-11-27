package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.br.rfaengines.mtg.search.cards.ligamagic.modelo.Loja;
import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;

public class PesquisarLojasCartaTest extends BaseTest {

	@Test(groups = { "Ligamagic" }, description = "Realizar uma pesquisa com sucesso.")
	public void pesquisarCarta() {

		String nomeDaCarta = "Wort, Boggart Auntie";
		
		CardsPage pesquisa = new CardsPage();
		
		pesquisa.preencherCampoNomeDoCard(nomeDaCarta).clicarNoBotaoDePesquisaLupa();
		
		assertTrue(pesquisa.resultadoDaPesquisa()
								.pesquisaRealizadaComSucesso(nomeDaCarta));		
		
		StringBuilder resultado = new StringBuilder();
		
		resultado.append("<b> PT-BR Nome: </b> ")
					.append(nomeDaCarta).append("<br> <b> ENG-US Nome:  </b>")
						.append(pesquisa.resultadoDaPesquisa().getNomeDoCardEmENG())
							.append("<br><b>Menor Preco: </b>")
								.append("<br>");
		
		ReportTestManager.adicionarEvidencia(resultado.toString());
		
		LojasPage lojaPage = new LojasPage();
		
		lojaPage.clicarNoBotaoExibirMaisCards();
				
		@SuppressWarnings("unused")
		ArrayList<Loja> lojasLista = lojaPage.lerInformacoesDaListaDeLojas();		

	}	
	
}
