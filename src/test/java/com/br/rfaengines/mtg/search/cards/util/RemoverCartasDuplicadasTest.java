package com.br.rfaengines.mtg.search.cards.util;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.br.rfaengines.testautomation.selenium.util.ArquivosUtil;
import com.br.rfaengines.testautomation.selenium.util.DataHoraUtil;
import com.br.rfaengines.testautomation.selenium.util.PropertiesUtil;

public class RemoverCartasDuplicadasTest {

	@Test(groups = { "Util" }, description = "Remover itens duplicados de uma lista.")
	public void remorverDuplicidade() {
		
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
			
			for (String itemDaListaDeCartas : listaDeCartas) {
			
				if (!itemDaListaDeCartas.isEmpty()) {
					
					String nomeDaCarta = itemDaListaDeCartas;
				
					if(!listaDeCartasParaExportar.contains(nomeDaCarta)) {
						listaDeCartasParaExportar.add(nomeDaCarta);
					}					
				}
				
			}
			
			StringBuilder dirDestino = new StringBuilder();

			dirDestino.append(System.getProperty("user.dir")).append("-logs").append("\\")
						.append("resultado-remover-cartas-duplicadas-[").append(arquivo.replace(".txt", "")).append("]-")
							.append(DataHoraUtil.getData("yyyyMMddHHmmss")).append(".txt");

			ArquivosUtil.salvarArquivo(dirDestino.toString(), listaDeCartasParaExportar);			

			ArquivosUtil.renomearArquivoParaProcessado(arquivoProcessado);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
