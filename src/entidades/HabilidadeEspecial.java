package entidades;

public abstract class HabilidadeEspecial {
    String nome; 
    String descricao ;
    int custoStamina;
    int tempoRecarga ;
    boolean disponivel ;

    public HabilidadeEspecial( String nome , String descricao , int custoStamina , int tempoRecarga){
        this.nome= nome ;
        this.descricao = descricao ;
        this.custoStamina = custoStamina;
        this.tempoRecarga = tempoRecarga ;
        this.disponivel = true ;
    }
    
    public abstract void usar(Character personagem);

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCustoStamina() {
        return custoStamina;
    }
    public void setCustoStamina(int custoStamina) {
        this.custoStamina = custoStamina;
    }
    public int getTempoRecarga() {
        return tempoRecarga;
    }
    public void setTempoRecarga(int tempoRecarga) {
        this.tempoRecarga = tempoRecarga;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

