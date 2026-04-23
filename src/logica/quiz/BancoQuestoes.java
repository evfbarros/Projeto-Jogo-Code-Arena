package logica.quiz;
import java.util.ArrayList;

public class BancoQuestoes {
    private ArrayList<Questao> listaQuestoes;

    public BancoQuestoes(){
        this.listaQuestoes = new ArrayList<>();
        listaQuestoes.add(new QuestaoVerdadeiroFalso("Napoleao Bonaparte morreu em guerra", 1, "Historia", 'F' ));
        ArrayList<String> alternativas1 = new ArrayList<>();
        alternativas1.add("A) 100");
        alternativas1.add("B) 200");
        alternativas1.add("C) 300");
        alternativas1.add("D) 500");
        listaQuestoes.add(new QuestaoMultiplaEscolha("Quantos anos o Brasil tem", 1, "Historia", alternativas1 , 3));
    }

    public ArrayList<Questao> getListaQuestoes() {
        return listaQuestoes;
    }
}
//isso aqui vai ser mudado dps pq quando o banco de questoes ficar mais extenso do jeuito 
// que esta vai ser iniviavel
//as questoes sao so exemplos genericos que inventei so p poder visualizar melhor