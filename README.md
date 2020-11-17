# APS-EstruturaDeDados-2020-2
Este é o programa desenvolvido para o trabalho da APS (Atividade Prática Supervisionada) do curso de Ciência da Computação, 3° Semestre, UNIP Brasília, segundo semestre de 2020.

O projeto todo foi feito na IDE Eclipse 4.17.

O Programa foi totalmente desenvolvido por mim (Pedro Henrique Neiva Nunes), com o intuito de gerar dados em formato de inteiro com base em uma imagem selecionada pelo usuário para que assim possa ser feito a ordenação de tais dados usando 3 algoritmos de ordenação, e por fim, comparar a performace de cada algoritmo.

O objetivo do trabalho foi a comparação dentre 3 algoritmos de ordenação usando listas de números inteiros. Para isso, foi sugerido a criação de um sistema de "calculo de nível de desmatamento", onde seriam atribuídos níveis de desmatamento para cada imagem selecionada pelo usuário, após o calculo, os níveis de desmatamento seriam ordenados e comparados.

Leve em conta que o "calculo de nível de desmatamento" não é a proposta em si do trabalho, o intuito não foi criar um sistemA fidedigno que calcula níveis de desmatamento com base em imagens, este calculo só está incluso dentro do trabalho para que dados sejam gerados e por fim ordenados.

Para fazer o programa eu segui a seguinte lógica:
-Dividir a imagem em 25 partes iguais;
-Pegar a cor dominante (ou seja a cor em RGB mais usada) de cada divisão, descartando as cores preto e branco;
-Calcular o nível de desmatamento com base na cor dominante (este calculo é feito comparando apenas o espectro verde de cada cor dominante, ou seja, quanto mais próximo o verde está de 255, menor o nível de desmatamento);
-Atribuir cada nível de desmatamento a sua respectiva divisão;
-Ordenar os níveis de desmatamento usando 3 algoritmos diferentes de ordenação (sendo eles Bubble Sort, Selection Sort e Quick Sort);
-Calcular o tempo de processamento de cada algoritmo de ordenação.

