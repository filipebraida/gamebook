# Role Player Game Book

Na classe Evento, é importante notar o método applyHistory (o qual é abstrato e deve ser implementado em toda classe que herdar de Evento) realiza a aplicação da descrição do evento para o personagem. Notem, o Evento em si é uma classe abstrata, o que possibilita a criação de diferentes tipos de eventos.

Um exemplo pode ser visto no trecho de código abaixo:

=== colocar exemplo do applyHistory

A classe Choice, a qual também é abstrata, define as opções que o player irá realizar a cada evento. Duas classes que herdam de Choice são BattleChoice e BlankChoice. A primeira lida com as escolhas de batalha e deve ser implementada de forma a refletir como as iterações com os inimigos devem acontecer. Já a segunda, é um padrão para execução de escolhas, as quais devem ser implementadas e definidas durante o desenvolvimento do trabalho.

A classe livro faz o controle do fluxo da história, onde os eventos são tratados e tem sua interação com o personagem. Já a classe engine, controla a interação com o usuário e passa as entradas do mesmo para o livro.

Quando o personagem avança nos eventos e faz uma escolha diversas coisas podem acontecer: uma batalha, tomar dano, ganhar um item e assim por diante. 

Ja existe um personagem e um inimigo, nos quais vocês podem implementar as lógicas relativas às interações do jogo e, além disso, criar suas próprias variações: novos inimigos, novos seres e personagens.

**Observações:** Vocês podem criar novos itens, instâncias, eventos e qualquer interação que acharem relevantes ao jogo.
