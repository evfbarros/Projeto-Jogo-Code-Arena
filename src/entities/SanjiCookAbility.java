package entities;

import logic.quiz.Question;

public class SanjiCookAbility implements SpecialAbility {

    @Override
    public boolean usar(Character personagem, Question questao, String resposta) {

        // Calcula metade da vida máxima do personagem
        int cura = personagem.getVidaMaxima() / 2;

        // Recupera a vida do personagem.
        // O próprio método recuperarVida já impede passar da vida máxima.
        personagem.recuperarVida(cura);

        // Retorna true para indicar que a habilidade foi usada com sucesso
        return true;
    }
}
