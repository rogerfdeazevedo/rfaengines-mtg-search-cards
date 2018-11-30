package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.br.rfaengines.testautomation.selenium.driver.DriverManager;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;

public class ResultadoPesquisaPage {

	@FindBy(css = "img[id='edcardimage']")
	private WebElement srcImagemDaCarta;
	
	@FindBy(xpath = "//div[@id='card-info']/div[1]/div[1]/p[1]")
	private WebElement nomeDoCardEmPTBR;

	@FindBy(xpath = "//div[@id='card-info']/div[1]/div[1]/p[2]")
	private WebElement nomeDoCardEmENG;		
	
	@FindBy(xpath = "//div[@id='card-info']/div[2]/div[1]/a")
	private WebElement corDaCarta;
	
	@FindBy(xpath = "//div[@id='card-info']/div[2]/div[2]/a")
	private WebElement custoDeMana;
	
	@FindBy(xpath = "//div[@id='card-info']/div[2]/div[2]/i")
	private WebElement curvaDeMana;	
	
	@FindBy(xpath = "//div[@id='card-info']/div[2]/div[3]")
	private WebElement tipoDaCarta;
	
	@FindBy(css = "font[id='ed-nome']")
	private WebElement nomeEdicao;
	
	@FindBy(css = "font[id='precos-menor']")
	private WebElement menorPreco;
	
	private WebDriverWait wait;
	
	public ResultadoPesquisaPage() {
		String timeOutStr = PropertiesUtil.getValue("timeout");
		int timeout = Integer.parseInt(timeOutStr);
		WebDriver driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, timeout);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
	}

	public boolean pesquisaRealizadaComSucesso(String nomeDaCarta) {		
		boolean isLoad = false;
		try {
			isLoad = wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return  nomeDoCardEmPTBR.isDisplayed()
							|| nomeDoCardEmENG.isDisplayed();
				}		
			});	
		} catch (Exception e) {			
		}				
		return isLoad;
	}
	
	public String getSrcImagemDaCarta() {
		String nome = "";
		try {
			nome = this.srcImagemDaCarta.getAttribute("src");
		} catch (Exception e) {			
		}
		return nome;
	}

	public String getNomeDoCardEmPTBR() {
		String nome = "-- Sem tradução --";
		try {
			nome = this.nomeDoCardEmPTBR.getText();
		} catch (Exception e) {			
		}
		return nome;
	}
	
	public String getNomeDoCardEmENG() {
		String nome = "";
		try {
			nome = this.nomeDoCardEmENG.getText();			
		} catch (Exception e) {
			nome = this.nomeDoCardEmPTBR.getText();
		}
		return nome;
	}
	
	public String getCorDaCarta() {
		return this.corDaCarta.getText();
	}
	
	public String getCustoDeMana() {
		String nome = "";
		try {
			nome = this.custoDeMana.getText();
		} catch (Exception e) {
			
		}
		return nome;
	}
	
	public String getCurvaDeMana() {
		String nome = "";
		try {
			nome = this.curvaDeMana.getText();
		} catch (Exception e) {
			
		}
		return nome;
	}
	
	public String getTipoDaCarta() {		
		String nome = "";
		try {
			nome = this.tipoDaCarta.getText().replace("Tipo:", "");
		} catch (Exception e) {
			
		}
		return nome;
	}
	
	public String getNomeEdicao() {
		String nome = "";
		try {
			nome = this.nomeEdicao.getText();
		} catch (Exception e) {
			
		}
		return nome;
	}
	
	public AlertaDePrecoPage alertaDePreco() {
		return new AlertaDePrecoPage();
	}
	
}
