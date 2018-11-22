package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.br.rfaengines.testautomation.selenium.pageobject.AbstractPageObject;

public class CardsResultSearchPage extends AbstractPageObject {

	@FindBy(xpath = "//*[@id='card-info']/div[1]/div[1]/p[1]")
	private WebElement nomeDoCardEmPTBR;

	@FindBy(xpath = "//*[@id='card-info']/div[1]/div[1]/p[2]")
	private WebElement nomeDoCardEmENG;

	public boolean pesquisaRealizadaComSucesso(String nomeDaCarta) {
		return this.nomeDoCardEmPTBR.getText().equals(nomeDaCarta)
				|| this.nomeDoCardEmENG.getText().equals(nomeDaCarta);
	}

	public String getNomeDoCardEmENG() {
		return this.nomeDoCardEmENG.getText();
	}
	
}
