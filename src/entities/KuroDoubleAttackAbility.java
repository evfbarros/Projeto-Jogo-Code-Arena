package entities;

public class KuroDoubleAttackAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase; // dano normal
    }

    @Override
    public int ataquesExtras(int rodada) {
        if (rodada % 2 == 0) {
            return 2; // ataca 2 vezes
        }
        return 1; // ataque normal
    }
}
