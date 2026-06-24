package entities.ability;

public class DefaultCombatAbility implements CombatAbility {
    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase;
    }
}