package br.cefetmg.inf.model.domain;

public class Curriculo_Oferta {
    private Long Id;
    private Ambiente_Aprendizagem Ambiente;
    private Curso Curso;
    private Periodo_Letivo Periodo;
    private Professor Prof;
    private Curso_Disciplina C_Disciplina;

    public Ambiente_Aprendizagem getAmbiente() {
        return Ambiente;
    }

    public void setAmbiente(Ambiente_Aprendizagem Ambiente) {
        this.Ambiente = Ambiente;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public Periodo_Letivo getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(Periodo_Letivo Periodo) {
        this.Periodo = Periodo;
    }

    public Professor getProf() {
        return Prof;
    }

    public void setProf(Professor Prof) {
        this.Prof = Prof;
    }

    public Curso_Disciplina getC_Disciplina() {
        return C_Disciplina;
    }

    public void setC_Disciplina(Curso_Disciplina C_Disciplina) {
        this.C_Disciplina = C_Disciplina;
    }
    
}
