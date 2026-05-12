## Projeto CodeArena

CodeArena é um jogo de combate em turnos inspirado no universo de One Piece, onde o progresso do jogador depende do seu conhecimento.

Durante as batalhas, o jogador enfrenta diferentes inimigos respondendo perguntas de História e Geografia. Cada resposta certa causa dano aos seus inimigos, e as erradas dificultam o combate.

## Estrutura

src/

main/

Main.java — Inicio do jogo


entities/

Character.java — Classe abstrata para personagens
CrewMember.java — Personagem controlado pelo jogador
Enemy.java — Personagem inimigo
NPC.java — Personagem não-jogável
GameObject.java — Classe abstrata para objetos do cenário
SpecialAbility.java — Classe abstrata para habilidades especiais


logic/

game/

GameManager.java — Controla o loop principal de batalha
LevelManager.java — Gerenciamento de níveis (em desenvolvimento)

quiz/

Question.java — Classe abstrata para questões
MultipleChoiceQuestion.java — Questão de múltipla escolha (A–E)
TrueFalseQuestion.java — Questão de verdadeiro ou falso
Difficulty.java — Enum de dificuldades
QuestionBank.java — Repositório de questões
QuestionManager.java — Sorteio e controle das questões
GoogleSheetsQuestionLoader.java — Carrega questões de uma planilha CSV

## Pré-Requisitos

JDK 11 ou superior 
Conexão com a internet(carregar as questões do Google Sheets)

## Desenvolvido por

Eduardo Barros e Guilherme Alves
