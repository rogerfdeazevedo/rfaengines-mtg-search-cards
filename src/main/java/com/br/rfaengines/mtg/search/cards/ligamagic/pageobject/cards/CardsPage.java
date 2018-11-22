package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.br.rfaengines.testautomation.selenium.pageobject.AbstractPageObject;

public class CardsPage extends AbstractPageObject {

	@FindBy (css = "input[id='card']")
	private WebElement campoNomeDoCard;
	
	@FindBy (xpath = "//*[@id='principal']/button")
	private WebElement botaoLupaPesquisar;
	
	public CardsPage preencherCampoNomeDoCard(String nomeDaCarta) {
		this.campoNomeDoCard.sendKeys(nomeDaCarta);
		return this;
	}
	
	public CardsPage clicarNoBotaoDePesquisaLupa() {
		this.botaoLupaPesquisar.click();
		return this;
	}
	
	public boolean pesquisaRealizadaComSucesso(String nomeDaCarta) {
		return new CardsResultSearchPage().pesquisaRealizadaComSucesso(nomeDaCarta);
	}
	
	public String getNomeDoCardEmENG() {
		return new CardsResultSearchPage().getNomeDoCardEmENG();
	}
	
}
