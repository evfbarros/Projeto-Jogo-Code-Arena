package entities;

public class ArlongFishmanhAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        // aumenta 10% a cada rodada
        return danoBase + (danoBase * rodada / 10);
    }
}
