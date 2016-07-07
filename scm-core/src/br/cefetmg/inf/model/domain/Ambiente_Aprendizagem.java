package br.cefetmg.inf.model.domain;

public class Ambiente_Aprendizagem {
    private Long Id;
    
    private int Capacidade, 
                Sala;
    
    private String Descricao;
    private Unidade_de_Ensino U_Ensino;
    
    
    public Long getId() {
        return Id;
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

    public Unidade_de_Ensino getU_ensino() {
        return U_Ensino;
    }

    public void setU_ensino(Unidade_de_Ensino u_ensino) {
        this.U_Ensino = u_ensino;
    }
}
