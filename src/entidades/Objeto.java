package entidades;

public abstract class Objeto {
    protected String nome;
    protected String descricao;
    protected boolean ativo;

    public Objeto(String nome , String descricao , boolean ativo) {
        this.nome = nome ;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public abstract void interagir(Character personagem);
}
