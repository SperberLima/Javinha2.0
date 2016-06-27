package br.cefetmg.inf.model.domain;

import java.sql.Date;
import java.util.Objects;

public class Matricula {
    
    private Turma turma;
    private Aluno aluno;
    private Long id;
    private Date dataInscricao;
    private boolean situacao; // ?
    private double notaFinal;

    public Matricula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.turma);
        hash = 79 * hash + Objects.hashCode(this.aluno);
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dataInscricao);
        hash = 79 * hash + (this.situacao ? 1 : 0);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.notaFinal) ^ (Double.doubleToLongBits(this.notaFinal) >>> 32));
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
        final Matricula other = (Matricula) obj;
        if (this.situacao != other.situacao) {
            return false;
        }
        if (Double.doubleToLongBits(this.notaFinal) != Double.doubleToLongBits(other.notaFinal)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataInscricao, other.dataInscricao)) {
            return false;
        }
        return true;
    }
    
}
