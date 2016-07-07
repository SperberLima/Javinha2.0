package br.cefetmg.inf.model.domain;

import java.sql.Date;

public class Periodo_Letivo {
    private Long Id;
    private Date Inicio, 
                 Fim;
    
    private String Descricao;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getInicio() {
        return Inicio;
    }

    public void setInicio(Date Inicio) {
        this.Inicio = Inicio;
    }

    public Date getFim() {
        return Fim;
    }

    public void setFim(Date Fim) {
        this.Fim = Fim;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
}
