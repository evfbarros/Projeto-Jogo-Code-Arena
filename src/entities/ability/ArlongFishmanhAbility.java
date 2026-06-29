package entities.ability;

public class ArlongFishmanhAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {
        return danoBase + (danoBase * rodada / 5);
    }
    @Override
    public String getNome() {
        return "Dentes de Tubarão";
    }

@Override
public String getDescricao() {
    return "Arlong troca seus dentes toda rodada,tornando eles mais fortes e resistentes. Por isso, seu ataque aumenta a cada rodada";
}
}
