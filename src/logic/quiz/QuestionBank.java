package logic.quiz;

import java.util.ArrayList;

public class QuestionBank {
    private ArrayList<Question> listaQuestoes;

    public QuestionBank(String linkCsv) {
        this.listaQuestoes = GoogleSheetsQuestionLoader.carregar(linkCsv);
    }

    public ArrayList<Question> getListaQuestoes() {
        return listaQuestoes;
    }
}