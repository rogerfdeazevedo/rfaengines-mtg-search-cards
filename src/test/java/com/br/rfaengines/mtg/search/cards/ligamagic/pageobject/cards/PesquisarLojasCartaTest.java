package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;

public class PesquisarLojasCartaTest extends BaseTest {

	@Test(groups = { "Ligamagic" }, description = "Realizar uma pesquisa com sucesso.")
	public void pesquisarCarta() {

		String nomeDaCarta = "Arcanjo Avacyn";

		CardsPage pesquisa = new CardsPage();

		pesquisa.preencherCampoNomeDoCard(nomeDaCarta).clicarNoBotaoDePesquisaLupa();

		assertTrue(pesquisa.pesquisaRealizadaComSucesso(nomeDaCarta));		
		
		StringBuilder resultado = new StringBuilder();
		
		WebDriver driver = DriverManager.getDriver();
		
		ArrayList<WebElement> linhasLoja = (ArrayList<WebElement>) driver.findElements(By.cssSelector("div[id^='line_e']"));
		
		System.out.println(linhasLoja.toString());

		resultado.append("<b> PT-BR Nome: </b> ").append(nomeDaCarta).append("<br> <b> ENG-US Nome:  </b>")
				.append(pesquisa.getNomeDoCardEmENG()).append("<br>");

		ReportTestManager.adicionarEvidencia(resultado.toString());		

	}
}
