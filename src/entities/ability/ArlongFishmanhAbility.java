package entities.ability;

public class ArlongFishmanhAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        // aumenta 20% a cada rodada
        return danoBase + (danoBase * rodada / 5);
    }
}
