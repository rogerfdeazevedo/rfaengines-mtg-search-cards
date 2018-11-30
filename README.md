## rfaengines-mtg-search-cards

Este projeto tem como objetivo ajudar a realizar pesquisas de cartas de magic de forma automatizada.

Em sites como:

* ligamagic
* edhrec

## Funcionalidades

# Ligamagic - Pesquisar Menor Preco Em Lote 

	Pesquisar o menor preco de cada carta a partir de uma lista.
   

* Importa lista de cartas (Arquivo de texto - formato MOL);
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

## Instalação

* Clone (download) do projeto framework (dependência) : https://github.com/rogerfdeazevedo/rfaengines-testautomation-selenium
* Instalação/Atualização do Java: https://www.devmedia.com.br/preparacao-do-ambiente-para-desenvolvimento-em-java/25188
* Instalação/Atualização do Maven: http://luizricardo.org/2014/06/instalando-configurando-e-usando-o-maven-para-gerenciar-suas-dependencias-e-seus-projetos-java/
* Download drivers: https://www.seleniumhq.org/download/
	
	@roger_azevedo 
	rogerfdeazevedo@gmail.com