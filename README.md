# Role Player Game Book

Esse código é a base de um livro jogo. As interações básicas já foram implementadas e o que está faltando é definir a história.

# Instruções
Cada equipe (de até três pessoas) irá fazer o fork desse projeto e irá extender o projeto com o objetivo em criar o seu próprio livro jogo.

Requisitos:
* Sistema de Combate
* Interface com o usuário
* Leitura de arquivos para a criação da história
* Sistema de Personagem Elaborado
  * Itens
  * Atributos
* Vários tipos de Monstros

## Código
### Event
Na classe _Event_, é importante notar o método _applyHistory_ (o qual é abstrato e deve ser implementado em toda classe que herdar de Evento) realiza a aplicação da descrição do evento para o personagem. Notem, o Evento em si é uma classe abstrata, o que possibilita a criação de diferentes tipos de eventos.

Um exemplo pode ser visto no trecho de código abaixo:

```{.java results="none"}
public void applyHistory(Character character) {

}
```

### Choice
A classe _Choice_, a qual também é abstrata, define as opções que o player irá realizar a cada evento. Duas classes pré defininas que herdam de _Choice_ são _BattleChoice_ e _BlankChoice_. A primeira lida com as escolhas de batalha e deve ser implementada de forma a refletir como as iterações com os inimigos devem acontecer. Já a segunda, é um padrão para execução de escolhas, as quais devem ser implementadas e definidas durante o desenvolvimento do trabalho.

```{.java results="none"}
public void executeChoice(Character character) {

}
```

### Book
A classe _Book_ faz o controle do fluxo da história, onde os eventos são tratados e tem sua interação com o personagem.

### Engine
A classe _Engine_, controla a interação com o usuário e passa as entradas do mesmo para o livro. Quando o personagem avança nos eventos e faz uma escolha diversas coisas podem acontecer: uma batalha, tomar dano, ganhar um item e assim por diante. 

### Character
Ja existe um personagem (_Player_) e um inimigo (_Enemy_), nos quais vocês podem implementar as lógicas relativas às interações do jogo e, além disso, criar suas próprias variações: novos inimigos, novos seres e personagens.

## Dicas
Vocês podem criar novos itens, instâncias, eventos e qualquer interação que acharem relevantes ao jogo.

## Exemplo de uma História

```{.java results="none"}
Event eventoFinal = new BlankEvent("Você morreu porque o Duarte" +
    "não mandou ir para a trilha.", new ArrayList<Choice>());

Collection escolhasIniciais = new ArrayList<Choice>();
Choice escolhaFinalTrilha = new BlankChoice("Segue a trilha", eventoFinal);
Choice escolhaFinalFloresta = new BlankChoice("Fica na floresta", eventoFinal);
escolhasIniciais.add(escolhaFinalTrilha);
escolhasIniciais.add(escolhaFinalFloresta);

Event eventoInitial = new BlankEvent("Você está em uma floresta. " +
    "O Sensei Duarte falou para você ficar na floresta treinando "
    , escolhasIniciais);

Book livro = new Book("A história da Rural", eventoInitial, new Player(10, 10));
```
