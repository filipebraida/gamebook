# Role Player Game Book

## Código
### Event
Na classe _Event_, é importante notar o método applyHistory (o qual é abstrato e deve ser implementado em toda classe que herdar de Evento) realiza a aplicação da descrição do evento para o personagem. Notem, o Evento em si é uma classe abstrata, o que possibilita a criação de diferentes tipos de eventos.

Um exemplo pode ser visto no trecho de código abaixo:

TODO: colocar exemplo do applyHistory

## Choice
A classe _Choice_, a qual também é abstrata, define as opções que o player irá realizar a cada evento. Duas classes pré defininas que herdam de _Choice_ são _BattleChoice_ e _BlankChoice_. A primeira lida com as escolhas de batalha e deve ser implementada de forma a refletir como as iterações com os inimigos devem acontecer. Já a segunda, é um padrão para execução de escolhas, as quais devem ser implementadas e definidas durante o desenvolvimento do trabalho.

## Book
A classe _Book_ faz o controle do fluxo da história, onde os eventos são tratados e tem sua interação com o personagem.

## Engine
A classe _Engine_, controla a interação com o usuário e passa as entradas do mesmo para o livro. Quando o personagem avança nos eventos e faz uma escolha diversas coisas podem acontecer: uma batalha, tomar dano, ganhar um item e assim por diante. 

## Character
Ja existe um personagem (_Player_) e um inimigo (_Enemy_), nos quais vocês podem implementar as lógicas relativas às interações do jogo e, além disso, criar suas próprias variações: novos inimigos, novos seres e personagens.

**Observações:** Vocês podem criar novos itens, instâncias, eventos e qualquer interação que acharem relevantes ao jogo.
