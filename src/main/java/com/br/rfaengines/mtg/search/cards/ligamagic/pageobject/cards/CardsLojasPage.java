package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.br.rfaengines.testautomation.selenium.pageobject.AbstractPageObject;

public class CardsLojasPage extends AbstractPageObject {

	@FindBy(css = "div[id^='line_e']")
	private ArrayList<WebElement> linhasLoja;
	
	@FindBy (xpath = "//*[@id='exibir_mais_2']/input")
	private WebElement exibirMaisCards;
	
	public ArrayList<WebElement> retornaListaDeLojas(){
		return this.linhasLoja;
	}
	
	public boolean carregouOpcaoParaExibirMaisCards() {
		return this.exibirMaisCards.isDisplayed();
	}
	
	public CardsLojasPage clicarNoBotaoExibirMaisCards() {
		if(this.carregouOpcaoParaExibirMaisCards()) {
			this.exibirMaisCards.click();
		}
		return this;
	}
	
}
