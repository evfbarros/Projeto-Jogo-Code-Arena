package logica.quiz;

public class BancoQuestoes {
    private Questao[] listaQuestoes;
    
    public BancoQuestoes(){
        this.listaQuestoes = new Questao[100];
        listaQuestoes[0] = new QuestaoMultiplaEscolha("Enunciado", 1, "Historia");
    }

    
}
