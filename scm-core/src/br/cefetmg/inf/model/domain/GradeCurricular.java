package br.cefetmg.inf.model.domain;

import java.util.ArrayList;
import java.util.Objects;

public class GradeCurricular {
    
    private Long Id;
    
    private String Descricao;
    
    private Periodo_Letivo PeriodoLetivo;
    
    private ArrayList<Disciplina> Disciplinas;

    public GradeCurricular() {
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public Periodo_Letivo getPeriodoLetivo() {
        return PeriodoLetivo;
    }

    public void setPeriodoLetivo(Periodo_Letivo periodoLetivo) {
        this.PeriodoLetivo = periodoLetivo;
    }
    
    public ArrayList<Disciplina> getDisciplinas() {
        return Disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.Disciplinas = disciplinas;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GradeCurricular other = (GradeCurricular) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
}
