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
public class Turma {
    private Integer id;
    private CurriculoOferta curriculoOferta;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CurriculoOferta getCurriculoOferta() {
        return curriculoOferta;
    }

    public void setCurriculoOferta(CurriculoOferta curriculoOferta) {
        this.curriculoOferta = curriculoOferta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
