package br.cefetmg.inf.model.domain;

import java.sql.Date;
import java.util.Objects;

public class Turma {
    
    private Long id;
    private Curso curso;
    private int vagasLimite;
    private Date inicio, termino;

    public Turma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getVagasLimite() {
        return vagasLimite;
    }

    public void setVagasLimite(int vagasLimite) {
        this.vagasLimite = vagasLimite;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
     
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + this.vagasLimite;
        hash = 67 * hash + Objects.hashCode(this.inicio);
        hash = 67 * hash + Objects.hashCode(this.termino);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.vagasLimite != other.vagasLimite) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.termino, other.termino)) {
            return false;
        }
        return true;
    }    
    
}
