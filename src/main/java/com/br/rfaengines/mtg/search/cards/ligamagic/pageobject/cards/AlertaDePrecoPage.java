package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.br.rfaengines.testautomation.selenium.pageobject.AbstractPageObject;

public class AlertaDePrecoPage extends AbstractPageObject {

	@FindBy(xpath = "//div[@id='alerta-preco']/div[1]/div[3]")
	private WebElement menorPreco;
	
	public String getMenorPreco() {
		return this.menorPreco.getText();
	}
	
}
