package entities.ability;

public interface CombatAbility {
    // Modifica o dano que o inimigo vai causar
    int modificarDano(int danoBase, int rodada);

    // Modifica o dano que o inimigo vai receber (para Don Krieg)
    default int modificarDanoRecebido(int danoBase, int rodada) {
        return danoBase;
    }

    // Permite adicionar efeitos extras, como ataque extra ou chance de esquiva
    default int ataquesExtras(int rodada) {
        return 1; // normalmente 1 ataque
    }
     default String getNome() {
        return "Habilidade de combate";
    }

    default String getDescricao() {
        return "Nenhuma descrição disponível.";
    }
}