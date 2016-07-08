package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

public class Professor {

    private Long Id;
    private Departamento Dpto;
    private String Nome,
            Descricao,
            Telefone,
            CPF;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    private ArrayList<Disciplina> Disciplinas;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return Disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> Disciplinas) {
        this.Disciplinas = Disciplinas;
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

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }
}
