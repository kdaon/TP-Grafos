# Coloração de vértices
>Trabalho Prático para disciplina de Algoritmo em Grafos.

## Motivação
Considere uma extensa rede em uma empresa de grande porte, composta por diversos dispositivos interconectados, como computadores, servidores e roteadores. O desafio de gerenciar a comunicação entre esses aparelhos é significativo. A aplicação do conceito de coloração de vértices pode ser útil nesse cenário. Esse conceito funciona como um esquema de cores para os canais de comunicação entre os dispositivos. Cada aparelho é representado por um vértice colorido no grafo, enquanto as arestas entre eles indicam as conexões.

O objetivo é evitar que dois aparelhos conectados diretamente compartilhem o mesmo canal (mesma cor), o que poderia resultar em confusão e lentidão na comunicação. Assim, cada cor representa um canal distinto. Essa prática melhora significativamente a eficiência da rede, prevenindo problemas de comunicação e otimizando o desempenho.<br><br>

## Problema
O desafio em questão é determinar a coloração mínima necessária para essa rede considerando que ela será composta por muitos vértices.<br><br>

## Complexidade do Problema
O problema de determinar a coloração mínima necessária para redes com muitos vértices é complexo e ainda não possui uma solução polinomial eficiente, dessa forma se torna um problema NP-Difícil.  Uma vez que a quantidade de dispositivos aumenta, a complexidade do problema cresce exponencialmente. A coloração mínima requer a atribuição de cores distintas a cada dispositivo conectado diretamente a outro, o que se torna impraticável em tempo polinomial conforme a rede se expande.

## Heurística
Diante da complexidade do problema, optamos por empregar uma heurística para encontrar soluções próximas do ótimo em um tempo viável. A heurística escolhida foi a Heurística Gulosa para Coloração de Vértices.
A heurística gulosa busca resolver o problema fazendo escolhas locais em cada passo, a fim de alcançar uma solução eficiente. Nesse contexto, essa heurística atribui cores aos vértices em ordem decrescente de grau. Essa abordagem visa reduzir o número de conflitos de cor e, consequentemente, encontrar uma coloração eficiente para a rede. Embora não garanta uma solução globalmente ótima, é uma alternativa eficaz para redes de grande porte.<br><br>

