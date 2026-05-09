package logica.quiz;

import java.util.ArrayList;

public class BancoQuestoes {
    private ArrayList<Questao> listaQuestoes;

    public BancoQuestoes(String linkCsv) {
        this.listaQuestoes = CarregadorQuestoesGoogleSheets.carregar(linkCsv);
    }

    public ArrayList<Questao> getListaQuestoes() {
        return listaQuestoes;
    }
}