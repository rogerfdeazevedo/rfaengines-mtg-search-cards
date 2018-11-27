## rfaengines-mtg-search-cards

Realizar pesquisas de cartas de magic de forma automatizada.

Em sites como:

* ligamagic
* edhrec

## Funcionalidades

# PesquisarMenorPrecoEmLoteAlertaDePrecoTest

	Ligamagic - Pesquisar o menor preco de cada carta a partir de uma lista.
   

* Importa lista de cartas (Arquivo de texto - formato MOL);
* Busca pelo menor preço na Seção de "Alerta de Preços" no result search da ligamagic;
* Gera report hmtl com resultado das buscas (Nome da carta em PT-BR/ENG-US + printscreen);
* Exporta lista de cartas com resultado da busca;
* A lista pode ser importada em um Excel, para realizar filtros e fazer sua seleção de cartas;
 
	Layout do arquivo de texto gerado com resultado da busca de preços: 
	qtd; nome-PT-BR; nome-ENG-US; cor; custo-de-mana; curva-de-mana; tipo; preco-menor; comprar; 
	
	@roger_azevedo 
	rogerfdeazevedo@gmail.com