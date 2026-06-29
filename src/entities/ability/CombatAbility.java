package entities.ability;

public interface CombatAbility {
    int modificarDano(int danoBase, int rodada);

    default int modificarDanoRecebido(int danoBase, int rodada) {
        return danoBase;
    }

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