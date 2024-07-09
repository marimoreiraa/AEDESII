# Arvores Binárias de Busca

## O que são ABBs?
ABB, sigla para Árvore Binária de Busca, é uma estrutura de dados em árvore binária com propriedades específicas que a tornam ideal para armazenar e recuperar informações de forma eficiente.
* Uma arvore binaria é uma Estrutura de Dados em que cada nó (pai) possui no máximo dois filhos (um a direita e outro a esquerda).
* Cada Nó possui no MÁXIMO 2 filhos.
* Cada valor MENOR que o valor do nó torna-se o filho ESQUERDO ou o filho do filho esquerdo.
* Todo valor MAIOR ou IGUAL ao valor do nó torna=se o filho DIREITO ou o filho do filho direito
  
## Características principais de uma ABB:
* Organização: Cada nó da árvore possui um valor (chave) único.
* Ordenação:
  * Na subárvore esquerda de cada nó, todos os valores são menores que a chave do nó raiz.
  * Na subárvore direita de cada nó, todos os valores são maiores que a chave do nó raiz.
* Propriedade de Busca: Essa organização permite que a busca por um valor específico na árvore seja realizada de forma rápida e eficiente.

## Exemplo de uma ABB:
Imagine uma agenda telefônica organizada como uma ABB. Cada nó da árvore armazena o nome de um contato e seu número de telefone. Ao buscar por um contato específico, a árvore é percorrida seguindo a regra de ordenação:
* Se o nome procurado for menor que a chave do nó atual, a busca continua na subárvore esquerda.
* Se o nome procurado for maior que a chave do nó atual, a busca continua na subárvore direita.
* Se o nome procurado for igual à chave do nó atual, o contato e seu número de telefone foram encontrados.

# Arvores Binárias X Arvores Binarias de Busca
* Arvores Binarias:
  * Permite qualquer organização dos valores nos nós.
  * Pode não estar ordenada.
  * Não possui propriedades matemáticas específicas.
  * As operações de busca, inserção e remoção podem ser menos eficientes.
  * Pode ser utilizada para diversas aplicações, como árvores de expressão, árvores de jogo e árvores de parse.
  * Útil quando a ordenação não é um requisito fundamental.

* Arvores Binarias de Busca:
  * Possui uma organização estrita:
    * Na subárvore esquerda de cada nó, todos os valores são menores que a chave do nó raiz.
    * Na subárvore direita de cada nó, todos os valores são maiores que a chave do nó raiz.
  * Propriedade de busca eficiente: permite encontrar um valor específico em tempo médio de O(log n), onde n é o número de elementos na árvore.
  * Propriedades de inserção e remoção eficientes: tempo médio de O(log n) para inserir ou remover um elemento.
  * Ideal para armazenar e recuperar informações de forma ordenada e eficiente.
  * Aplicações em bancos de dados, índices, sistemas de busca, etc.

<p align="center">
  <img src="https://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/problemas/210.png" />
</p>

## Como procurar um elemento na Arvore Binária?
* Começamos da RAIZ.
1. Se for igual ao número desejado, o elemento RAIZ é o desejado, caso contrário, comparamos os valores da raiz e do desejado.
2. Se o elemento que procuramos for MAIOR que a Raiz, passamos para o filho DIREITO, caso seja MENOR, passamos para o filho ESQUERDO.
3. Se o elemento não for encontrado, aplicamos as etapas 1 e 2 ao filho até que o elemento seja encontrado.

<p align="center">
  <img src="https://cdn.javarush.com/images/article/6ff96893-86bd-407c-9ccd-469d4b912ab8/512.webp" />
</p>

## Como insetir um elemento na Arvore Binária?
1. Comparamos o novo com o raiz (se não existir, o novo elemento é o raiz).
2. Se for um novo elemento:
    * Se for MENOR, então vamos para o herdeiro ESQUERDO; se não houver, o novo elemento toma o lugar do herdeiro ESQUERDO e o algoritmo é concluído;
    * Se for MAIOR ou IGUAL à raiz, então passamos para o herdeiro DIREITO. E da mesma forma, se este elemento não existir, então um novo elemento tomará o lugar do elemento DIREITO e o algoritmo será concluído.
3. Para o novo elemento em questão, que estava à direita ou à esquerda do passo anterior, repita os passos 1 e 2 até que o elemento inserido esteja no lugar.

<p align="center">
  <img src="https://cdn.javarush.com/images/article/ca7f4622-93b9-4522-aa48-3d172a5b9e8e/512.webp" width="425"/> <img src="https://cdn.javarush.com/images/article/0d23a8f1-b8a1-49b2-86b7-7c1f8e2b6421/512.webp" width="425"/> 
</p>

## Como remover um elemento da Arvore Binária?
Em primeiro lugar, busca-se o elemento a ser excluído, após a descoberta segue-se uma etapa, que pode ter três variações:
1. O nó a ser excluído é um nó folha (não tem filhos).
   * Talvez o mais simples. Tudo se resume ao fato de simplesmente cortá-lo da árvore, sem manipulações desnecessárias.
     <p align="center">
        <img src="https://cdn.javarush.com/images/article/bdf36e4e-02d7-4390-a98b-966ae76ef7c7/512.webp" width="300"/> <img src="https://cdn.javarush.com/images/article/880ff4e2-4051-4c6d-9da7-5e26cdc45acc/512.webp" width="300"/> 
     </p>
2. O nó que está sendo excluído tem um filho.
   * Nesse caso, excluímos o nó selecionado e colocamos seu descendente em seu lugar (em essência, simplesmente cortamos o nó selecionado da cadeia).
     <p align="center">
        <img src="https://cdn.javarush.com/images/article/0dc0a85b-5313-42ac-83bb-3d9342311346/512.webp" width="300"/> <img src="https://cdn.javarush.com/images/article/7136283a-a7b8-406e-856b-1799222ce346/512.webp" width="300"/> 
     </p>
3. O nó que está sendo excluído tem dois filhos.
   * A parte mais interessante. Afinal, se o nó que está sendo excluído tiver dois filhos ao mesmo tempo, você não poderá simplesmente substituí-lo por um desses filhos (especialmente se o filho tiver seus próprios filhos).
     1. Primeiramente devemos ir até o filho direito do nó selecionado, cujo valor deve ser maior que o valor do nó.
     2. Em seguida, passamos para o filho esquerdo do filho direito (se existir), depois para o filho esquerdo do filho esquerdo, etc., seguindo a cadeia de filhos esquerdos.
     3. Conseqüentemente, o último filho esquerdo neste caminho será o sucessor do nó original.
   * Resumidamente, substituimos o que será deletado pelo MENOR nó do seu lado DIREITO.
     <p align="center">
        <img src="https://cdn.javarush.com/images/article/bd373293-9542-416f-948f-8d647ca6f4ea/512.webp" width="300"/> <img src="https://cdn.javarush.com/images/article/3ad40c4f-4f90-4d6a-a757-2822ca665f35/512.webp" width="300"/> 
     </p>

## Como percorrer uma Arvore Binaria?
Há três métodos utilizados para percorrer uma árvore binária:
1. Pré-ordem
   * No percurso pré-ordem, os nós são visitados na seguinte ordem: primeiro o nó pai, em seguida o filho esquerdo e, por último, o filho direito.
   * Essa técnica é útil para criar uma cópia da árvore ou para realizar operações de pré-processamento antes de visitar os nós filhos.
   <p align="center">
      <img src="https://lh7-us.googleusercontent.com/n5v5nn9Ps-UxKvevrA17oiKEwDptu2mx8mr_3SD8Nn7UBvRZGX7v7R-ZKrnuFIr40fXQIPwaOBWD5vMZpT2qz9zIqUaP0dmAM_uKGyMENVpOBcRfjzcEGyNGXvnL3XxlPBF3n4qrHA-re902OUHtOLnbsQDMJfpInpo1q4RzPPBW870f_lEUbHFVgxr6yw" />
   </p>
2. Em ordem (Simétrico)
   * No percurso em ordem,  a árvore é percorrida de forma que os nós sejam visitados na seguinte ordem: primeiro o filho esquerdo, depois o nó pai e, por fim, o filho direito.
   * Essa técnica é comumente utilizada para obter os elementos de uma árvore binária de busca em ordem crescente.
   <p align="center">
      <img src="https://lh7-us.googleusercontent.com/q9NWbxcHoSoMnKcTDc25xNgGOVTwIKnRqQQO2hNbOW0jIKyJWOsvwX7GCQr5t_RjcxXYgGHoT88I_MHqyjm5sGjaLxb0QHKS6iF7Q0blNE1PWZHo0N8c2KsnjE_577qW0L5hUOUjHgmBZUb5hdPw62tXHW8kJOqqWWm0vnnkrjA4dvDtL0oWX1wry21-mQ" />
   </p>
3. Pós-ordem
   * O percurso pós-ordem, envolve a visita aos nós na seguinte ordem: primeiro o filho esquerdo, depois o filho direito e, por último, o nó pai.
   * Essa técnica é frequentemente empregada em cálculos que requerem informações dos nós filhos antes de processar o nó pai, como a avaliação de expressões aritméticas.
   <p align="center">
      <img src="https://lh7-us.googleusercontent.com/SYZbObxEWxDALQn4B_l_2HuKI0Pz86xRt1uxyGTH9AeIA_pyV8X62KHmmru2sNAEfLohd4uOaeOzd99FBml5KYO9lbck442axdJdI_a46bQIhXpNCGNvGcelzjy-DUdsZkmhd2Rd9pMVkqRe4KXEbf4RPxzZIKo-WKOptyror7YjDBUIvRhmyCvO2UlPIQ" />
   </p>

A dica pra entender rapidamente esses métodos de percursos em árvores binárias é seguir essas duas regras:
1. O nó filho da esquerda é sempre visitado antes que o da direita:
2. O nome do método se refere ao momento em que o nó pai é visitado, ou seja:
   * Pré-ordem: o pai é visitado antes dos filhos, ou seja, Pai-Esquerda-Direita;
   * Em ordem: o pai é visitado entre os filhos, ou seja, Esquerda-Pai-Direita;
   * Pós-ordem: o pai é visitado após os filhos, ou seja, Esquerda-Direita-Pai;
<p align="center">
    <img src="https://lh7-us.googleusercontent.com/8E_Kws439QOz_SUK5FBz269tzCG-uE1MLqhCp_czyzbQ3Tk17u7U_1ZYp2XrGC9OEU54O2y8-SHRDcGSqEVIiRGYsQHda3VUpPG6_9wRMwKfnhe3QPRe7xbWm9mJXst2839Px5qxiftgrVjyv5lf-SIQ-Dwbkd92rB66fo0cbZ7AWhkkdTH4MYKTphn7nA" />
</p>   


