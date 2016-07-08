package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

public class Curso {

    private Long Id;
    private Departamento Dpto;
    private String Tipo,
            Nome,
            Sigla;
    private ArrayList<GradeCurricular> Grades;

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public ArrayList<GradeCurricular> getGrades() {
        return Grades;
    }

    public void setGrades(ArrayList<GradeCurricular> Grades) {
        this.Grades = Grades;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Departamento getDpto() {
        return Dpto;
    }

    public void setDpto(Departamento dpto) {
        this.Dpto = dpto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
}
