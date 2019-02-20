package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertFalse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.br.rfaengines.mtg.search.cards.ligamagic.apimtg.service.ApiMtgService;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.service.ExportFileService;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.service.ImportFileService;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.CardData;
import com.br.rfaengines.mtg.search.cards.ligamagic.file.vo.FileSearch;
import com.br.rfaengines.mtg.search.cards.util.PropertiesUtil;
import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;
import com.br.rfaengines.testautomation.selenium.test.ScreenShot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.relevantcodes.extentreports.LogStatus;

public class PesquisarMenorPrecoEmLoteTest extends BaseTest {

	private String pathIn = "." + PropertiesUtil.getValue("file.dir.import");
	private String pathOut = "." + PropertiesUtil.getValue("file.dir.export");
	private String extensionIn = PropertiesUtil.getValue("file.dir.extensionIn");
	private String extensionProc = PropertiesUtil.getValue("file.dir.extensionProc");

	@Test(groups = { "ligamagic" }, description = "Pesquisar o menor preco de cada carta a partir de uma lista.")
	public void pesquisarMenorPreco() throws JsonProcessingException {

		ImportFileService importFileService = new ImportFileService(pathIn, extensionIn, extensionProc);
		List<FileSearch> fileSearchList = importFileService.importFile();
		
		assertFalse(fileSearchList.isEmpty(), "Sem arquivos para processar");

		ApiMtgService apiMtg = new ApiMtgService(fileSearchList);
		
		fileSearchList = apiMtg.processFileSearchList();

		fileSearchList = pesquisarCartas(fileSearchList);

		ExportFileService exportFileService = new ExportFileService(pathOut, fileSearchList, true);
		exportFileService.exportFile();		

	}

	private List<FileSearch> pesquisarCartas(List<FileSearch> fileSearchList) {

		List<FileSearch> fsList = new ArrayList<FileSearch>();

		CardsPage pesquisa = new CardsPage();
		ResultadoPesquisaPage resultadoDaPesquisa = new ResultadoPesquisaPage();
		AlertaDePrecoPage alertaDePreco = new AlertaDePrecoPage();

		for (FileSearch fileSearch : fileSearchList) {

			fileSearch = pesquisarCartasDaLista(pesquisa, resultadoDaPesquisa, alertaDePreco, fileSearch);
			
			fsList.add(fileSearch);

		}

		return fsList;
	}

	private FileSearch pesquisarCartasDaLista(CardsPage pesquisa, ResultadoPesquisaPage resultadoDaPesquisa,
			AlertaDePrecoPage alertaDePreco, FileSearch fileSearch) {			
		
		FileSearch fs = new FileSearch();
		
		fs.setFileName(fileSearch.getFileName());
		
		for (CardData cardData : fileSearch.getCardList()) {

			StringBuilder resultadoStr = new StringBuilder();
			
			cardData.setDataPesquisa(getDate());
			
			pesquisar(pesquisa, cardData);

			if (resultadoDaPesquisa.pesquisaRealizadaComSucesso(cardData.getNameENGUS())) {				
				
				cardData = sucesso(resultadoDaPesquisa, alertaDePreco, cardData, resultadoStr);				
				
			} else {			
				
				cardData = falha(cardData, resultadoStr);
				
			}
			
			ReportTestManager.adicionarEvidencia(resultadoStr.toString());
			
			fs.getCardList().add(cardData);

		}
		
		return fs;
	}

	private void pesquisar(CardsPage pesquisa, CardData cardData) {
		pesquisa.limparCampoNomeDoCard()
					.preencherCampoNomeDoCard(cardData.getNameENGUS())
						.clicarNoBotaoDePesquisaLupa();		
	}

	private CardData sucesso(ResultadoPesquisaPage resultadoDaPesquisa, AlertaDePrecoPage alertaDePreco,
			CardData cardData, StringBuilder resultadoStr) {
		
		cardData.setNomePTBR(resultadoDaPesquisa.getNomeDoCardEmPTBR());
		cardData.setPrecoMenor(alertaDePreco.getMenorPreco().replace("R$", "").replace(",", "."));				
		
		resultadoStr.append("<b> PT-BR Nome: </b> ").append(cardData.getNomePTBR())
					.append("<br> <b> ENG-US Nome:  </b>").append(cardData.getNameENGUS())
						.append("<br><b>Menor Preco: </b>")
							.append(cardData.getPrecoMenor()).append("<br>");
		
		return cardData;
	}

	private CardData falha(CardData cardData, StringBuilder resultadoStr) {
		
		cardData.setNomePTBR("Verifique se o nome da carta pesquisado esta correto");
		
		resultadoStr.append("<b> Nome Pesquisado: </b> ").append(cardData.getNameENGUS())
					.append("<br> Verifique se o nome da carta pesquisado esta correto. <br>");
		
		String dirEvidencias = ReportTestManager.getDirEvidencias();
		String imagePath = "./evidencias/" + ScreenShot.takeScreenshot(dirEvidencias);
		
		ReportTestManager.getTest().log(LogStatus.WARNING, resultadoStr.toString() + "<br>"
							+ ReportTestManager.getTest().addScreenCapture(imagePath));
		
		return cardData;
	}	

	private String getDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
}
