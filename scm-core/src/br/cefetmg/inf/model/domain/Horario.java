/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.domain;

/**
 *
 * @author Nome
 */
public class Horario {
    private Integer id;
    private AmbienteAprendizagem ambiente;
    private Turma turma;
    private ProfessorDisciplina professorDisciplina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AmbienteAprendizagem getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(AmbienteAprendizagem ambiente) {
        this.ambiente = ambiente;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ProfessorDisciplina getProfessorDisciplina() {
        return professorDisciplina;
    }

    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
        this.professorDisciplina = professorDisciplina;
    }
    
    
}
