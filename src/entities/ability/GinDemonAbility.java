package entities.ability;
public class GinDemonAbility implements CombatAbility {

    @Override
    public int modificarDano(int danoBase, int rodada) {

        if (rodada >= 3) {
            return danoBase + 40;
        }

        return danoBase;
    }
    @Override
    public String getNome() {
        return "Homem Demonio";
    }

    @Override
    public String getDescricao() {
        return "A partir da terceira rodada, Gin entra em um estado mais agressivo e causa dano adicional.";
    }
}