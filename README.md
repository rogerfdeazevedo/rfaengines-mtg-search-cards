## rfaengines-mtg-search-cards

Este projeto tem como objetivo ajudar a realizar pesquisas de cartas de magic de forma automatizada.

Em sites como:

* ligamagic
* edhrec

## Get started

* [Como instalar](docs/como_instalar.md)
* [Como executar](docs/como_executar.md)
* [Como ver o resultado de execução](docs/como_ver_resultado_da_execucao.md)
* [Como ler o log de erro](docs/como_ler_log_de_erro.md)

## Funcionalidades

# Ligamagic - Pesquisar Menor Preco Em Lote

	Pesquisar o menor preco de cada carta a partir de uma lista.
   

* Suite execução: 
	
	ligamagic_pesquisar_menor_preco_em_lote

* Importa lista de cartas (Arquivo de texto - formato MOL) em; files/import
* Busca pelo menor preço na Seção de "Alerta de Preços" no result search da ligamagic;
* Gera report hmtl com resultado das buscas (Nome da carta em PT-BR/ENG-US + printscreen);
* Exporta lista de cartas com resultado da busca;
* A lista pode ser importada em um Excel, para realizar filtros e fazer sua seleção de cartas;
 
**Layout do arquivo**

É gerado um arquivo de texto com resultado da busca de preços, com os campos:
 
* qtd
* nome-PT-BR
* nome-ENG-US
* cor
* custo-de-mana
* curva-de-mana
* tipo; preco-menor
* comprar; 
	
	
## Requisitos

* Java
* Maven
* Projeto framework 
* Drivers selenium em: C:/selenium/drivers

	
	@roger_azevedo 
	rogerfdeazevedo@gmail.com