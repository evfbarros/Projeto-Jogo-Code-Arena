# East Blue Chronicles

**East Blue Chronicles** é um RPG de quiz por turnos inspirado no universo de *One Piece*, desenvolvido como projeto da disciplina de Linguagem de Programação Orientada a Objetos (LPOO) na Escola Politécnica da Universidade de Pernambuco (Poli UPE).

O jogador percorre as 5 ilhas da East Blue — Shells Town, Orange Town, Vila Syrup, Baratie e Arlong Park — enfrentando inimigos em batalhas baseadas em perguntas de História e Geografia. Respostas corretas concedem ataques, respostas erradas deixam o jogador na defensiva.

---

## Funcionalidades

- Batalhas por turnos com sistema de perguntas (múltipla escolha, verdadeiro/falso e abertas)
- 5 personagens jogáveis: Luffy, Zoro, Nami, Usopp e Sanji — cada um com habilidade especial única
- Sistema de XP e progressão de nível com melhoria de atributos
- 5 ilhas com NPCs, mini-bosses e bosses
- Perguntas carregadas dinamicamente via Google Sheets (CSV)
- Dificuldade das perguntas varia por ilha
- Sistema de defesa e desvio com usos limitados
- Menu principal com opções de jogo, instruções e informações

---

## Como executar

**Requisitos:**
- JDK 11 ou superior
- Conexão com a internet (para carregar as questões do Google Sheets)

**Passos:**
1. Baixe e extraia o arquivo `.zip`
2. Abra a pasta extraída na sua IDE (recomendado: VS Code ou IntelliJ)
3. Localize `Main.java` em `src/main/`
4. Execute a classe `Main`

---

## Estrutura do projeto

```
src/
├── main/           # Ponto de entrada (Main.java)
├── entities/       # Personagens, ataques e habilidades
│   └── ability/    # Interfaces e implementações de habilidades
├── logic/
│   ├── game/       # GameManager, CampaignManager
│   └── quiz/       # Questões, banco de perguntas, dificuldade
├── screens/        # Telas do terminal (Menu, Batalha, Questão, etc.)
├── world/          # Ilhas e criação de rotas
└── exceptions/     # Exceções customizadas
```

---

## Tecnologias utilizadas

- Java (JDK 11+)
- Google Sheets como banco de questões (via CSV público)
- Terminal como interface (sem bibliotecas gráficas)

---

## Desenvolvido por

- Eduardo Vinícius
- Guilherme Alves
