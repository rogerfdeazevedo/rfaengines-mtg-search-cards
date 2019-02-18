package com.br.rfaengines.mtg.search.cards.ligamagic.file.vo;

public class HeaderFile {

	public HeaderFile() {
	}

	public String resultSearch() {
		StringBuilder header = new StringBuilder();
		
		header
		.append("Qtd").append(";")
		.append("NameENGUS").append(";")
		.append("NomePTBR").append(";")
		.append("Color").append(";")
		.append("Cast").append(";")
		.append("Cmc").append(";")
		.append("Type").append(";")
		.append("EfeitoQtd").append(";")
		.append("EfeitoDrawBackQtd").append(";")
		.append("EfeitoScore").append(";")
		.append("EfeitoPrincipal").append(";")
		.append("EfeitoOutros").append(";")
		.append("EdhCategoria").append(";")
		.append("TenhoQtd").append(";")
		.append("Comprar").append(";")
		.append("Colecao").append(";")
		.append("PrecoMenor").append(";")
		.append("Estado").append(";")
		.append("LojaMenorPreco").append(";")
//		.append("Lojas").append(";")			
		;
		
		return header.toString();
	}

}
