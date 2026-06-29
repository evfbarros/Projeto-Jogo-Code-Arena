package entities.ability;

public class DefaultCombatAbility implements CombatAbility {
    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase;
    }
    @Override
    public String getNome() {
        return "Sem habilidade especial";
    }

    @Override
    public String getDescricao() {
        return "Este inimigo luta de forma comum, sem efeitos especiais de combate.";
    }
}