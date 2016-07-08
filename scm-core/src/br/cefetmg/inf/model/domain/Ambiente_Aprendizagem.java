package br.cefetmg.inf.model.domain;

public class Ambiente_Aprendizagem {
    private Long Id;
    
    private int Capacidade, 
                Sala;
    
    private String Descricao;
    private UnidadeEnsino U_Ensino;
    
    
    public Long getId() {
        return Id;
    }

    public int getSala() {
        return Sala;
    }

    public void setSala(int Sala) {
        this.Sala = Sala;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public int getCapacidade() {
        return Capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.Capacidade = capacidade;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public UnidadeEnsino getU_ensino() {
        return U_Ensino;
    }

    public void setU_ensino(UnidadeEnsino u_ensino) {
        this.U_Ensino = u_ensino;
    }
}
