package com.br.rfaengines.mtg.search.cards.ligamagic.pageobject.cards;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.report.ReportTestManager;
import com.br.rfaengines.testautomation.selenium.test.BaseTest;
import com.br.rfaengines.testautomation.selenium.test.ScreenShot;
import com.br.rfaengines.testautomation.selenium.util.ArquivosUtil;
import com.br.rfaengines.testautomation.selenium.util.DataHoraUtil;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;
import com.relevantcodes.extentreports.LogStatus;

public class PesquisarMenorPrecoEmLote_Version_001Test extends BaseTest {

	@Test(groups = { "Ligamagic" }, description = "Pesquisar o menor preco de cada carta a partir de uma lista.")
	public void pesquisarMenorPreco() {

		ArrayList<String> listaDeArquivos;
		ArrayList<String> listaDeCartas;
		ArrayList<String> listaDeCartasParaExportar;
		String arquivoProcessado;

		String dirArquivos = PropertiesUtil.getValue("files.dir.import");

		listaDeArquivos = ArquivosUtil.listarArquivosDeTexto(dirArquivos);

		assertTrue(!listaDeArquivos.isEmpty(), "Sem arquivos para processar no diretório: " + dirArquivos);

		for (String arquivo : listaDeArquivos) {
			
			arquivoProcessado = dirArquivos + arquivo;

			listaDeCartas = ArquivosUtil.lerArquivo(arquivoProcessado);

			assertTrue(!listaDeCartas.isEmpty(), "Falha ao ler arquivo - Verifique se o arquivo existe: " + arquivo);

			listaDeCartasParaExportar = new ArrayList<String>();
			listaDeCartasParaExportar.add(
					"qtd; nome-PT-BR; nome-ENG-US; cor; custo-de-mana; curva-de-mana; tipo; preco-menor; ja-tenho; comprar;");

			CardsPage pesquisa = new CardsPage();

			for (String itemDaListaDeCartas : listaDeCartas) {

				if (!itemDaListaDeCartas.isEmpty()) {

					StringBuilder cartaParaExportar = new StringBuilder();

					cartaParaExportar.append(itemDaListaDeCartas.substring(0, 1)).append("; ");

					String nomeDaCarta = itemDaListaDeCartas.substring(2);

					pesquisa.limparCampoNomeDoCard()
								.preencherCampoNomeDoCard(nomeDaCarta)
									.clicarNoBotaoDePesquisaLupa();					

					boolean achouCarta = pesquisa.resultadoDaPesquisa().pesquisaRealizadaComSucesso(nomeDaCarta);
					
					StringBuilder resultado = new StringBuilder();

					if (achouCarta) {

						String nomePTBR = pesquisa.resultadoDaPesquisa().getNomeDoCardEmPTBR();
						String nomeENGUS = pesquisa.resultadoDaPesquisa().getNomeDoCardEmENG();
						String corDaCarta = pesquisa.resultadoDaPesquisa().getCorDaCarta();
						String custoDeMana = pesquisa.resultadoDaPesquisa().getCustoDeMana();
						String curvaDeMana = pesquisa.resultadoDaPesquisa().getCurvaDeMana();
						String tipoDaCarta = pesquisa.resultadoDaPesquisa().getTipoDaCarta();
						String menorPreco = pesquisa.resultadoDaPesquisa().alertaDePreco().getMenorPreco();
						
						

						resultado.append("<b> PT-BR Nome: </b> ").append(nomePTBR)
									.append("<br> <b> ENG-US Nome:  </b>").append(nomeENGUS)
										.append("<br><b>Menor Preco: </b>").append(menorPreco).append("<br>");

						ReportTestManager.adicionarEvidencia(resultado.toString());

						cartaParaExportar.append(nomePTBR).append("; ");
						cartaParaExportar.append(nomeENGUS).append("; ");
						cartaParaExportar.append(corDaCarta).append("; ");
						cartaParaExportar.append(custoDeMana).append("; ");
						cartaParaExportar.append(curvaDeMana).append("; ");
						cartaParaExportar.append(tipoDaCarta).append("; ");
						cartaParaExportar.append(menorPreco).append("; ");

						listaDeCartasParaExportar.add(cartaParaExportar.toString());

					} else {
						resultado.append("<b> Nome Pesquisado: </b> ").append(nomeDaCarta)
									.append("<br> Verifique se o nome da carta pesquisado esta correto. <br>");

						String dirEvidencias = ReportTestManager.getDirEvidencias();
						String imagePath = "./evidencias/" + ScreenShot.takeScreenshot(dirEvidencias);

						ReportTestManager.getTest().log(LogStatus.WARNING, resultado.toString() + "<br>"
								+ ReportTestManager.getTest().addScreenCapture(imagePath));

					}

				}

			}

			StringBuilder dirDestino = new StringBuilder();

			dirDestino.append(ReportTestManager.getDirEvidencias().replace("evidencias", ""))
						.append("resultado-da-pesquisa-ligamagic-[").append(arquivo.replace(".txt", "")).append("]-")
							.append(DataHoraUtil.getData("yyyyMMddHHmmss")).append(".txt");

			ArquivosUtil.salvarArquivo(dirDestino.toString(), listaDeCartasParaExportar);			

			ArquivosUtil.renomearArquivoParaProcessado(arquivoProcessado);

		}

	}

}
