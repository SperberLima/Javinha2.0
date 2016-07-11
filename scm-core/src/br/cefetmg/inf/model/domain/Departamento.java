package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

public class Departamento {
    
    private Integer Id;
    
    private String Sigla,
                   Nome,
                   Email,
                   Telefone,
                   CEP,
                   Site;
    
    UnidadeEnsino UnidadeEnsino;

    public UnidadeEnsino getUnidadeEnsino() {
        return UnidadeEnsino;
    }

    public void setUnidadeEnsino(UnidadeEnsino UnidadeEnsino) {
        this.UnidadeEnsino = UnidadeEnsino;
    }
    
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        this.Site = site;
    }
}
