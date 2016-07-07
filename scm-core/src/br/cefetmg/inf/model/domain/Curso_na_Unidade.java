package br.cefetmg.inf.model.domain;

public class Curso_na_Unidade {
    private Long Id;
    private Curso Curso;
    private Unidade_de_Ensino U_ensino;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public Unidade_de_Ensino getU_ensino() {
        return U_ensino;
    }

    public void setU_ensino(Unidade_de_Ensino U_ensino) {
        this.U_ensino = U_ensino;
    }
    
}
