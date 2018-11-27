package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.br.rfaengines.mtg.search.cards.ligamagic.modelo.Loja;
import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.pageobject.AbstractPageObject;

public class LojasPage extends AbstractPageObject {	
	
	@FindBy (xpath = "//*[@id='exibir_mais_2']/input")
	private WebElement exibirMaisCards;	
	
	public boolean carregouOpcaoParaExibirMaisCards() {
		return this.exibirMaisCards.isDisplayed();
	}
	
	public LojasPage clicarNoBotaoExibirMaisCards() {
		if(this.carregouOpcaoParaExibirMaisCards()) {
			this.exibirMaisCards.click();
		}
		return this;
	}
	
	public ArrayList<Loja> lerInformacoesDaListaDeLojas() {
		WebDriver driver = DriverManager.getDriver();
		
		ArrayList<Loja> lojasLista = new ArrayList<Loja>();

		int qtdLinhas = driver.findElements(By.xpath("//div[starts-with(@id,'line_e')]")).size();		
		
		int linha = 1;
		
		for (int i = linha; i <= qtdLinhas; i++) {
						
			String lojaNome = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[1]/a/img")).getAttribute("title");
			String lojaUrlLogo = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[1]/a/img")).getAttribute("src");
			String lojaEdicaoCartaUrlLogo = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[2]/div/img")).getAttribute("src");		
			String lojaEdicaoLinkNomeEdicao = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[3]/font/a")).getText();
			String lojaCartaPreco = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[4]")).getText();
			String lojaCartaIdioma = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[5]/img")).getAttribute("title");
			String lojaCartaEstado = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[5]/font")).getText();
			String lojaCartaQtd = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[6]")).getText();
			String lojaUrlIrALoja = driver.findElement(By.xpath("//div[starts-with(@id,'line_e')][" + i + "]/div[6]")).getAttribute("href");
			
			Loja loja = new Loja();
			
			loja.setNome(lojaNome);
			loja.setUrlLogo(lojaUrlLogo);
			loja.setEdicaoCartaUrlLogo(lojaEdicaoCartaUrlLogo);
			loja.setEdicaoLinkNomeEdicao(lojaEdicaoLinkNomeEdicao);
			loja.setCartaPreco(lojaCartaPreco);
			loja.setCartaIdioma(lojaCartaIdioma);
			loja.setCartaEstado(lojaCartaEstado);
			loja.setCartaQtd(lojaCartaQtd);
			loja.setUrlIrALoja(lojaUrlIrALoja);
			
			lojasLista.add(loja);		
						
		}
		
		return lojasLista;
	}
	
}
