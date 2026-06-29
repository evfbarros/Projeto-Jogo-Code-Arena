package entities;

public abstract class GameObject {
    protected String nome;
    protected String descricao;
    protected boolean ativo;

    public GameObject(String nome, String descricao, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public abstract void interagir(Character personagem);
}
