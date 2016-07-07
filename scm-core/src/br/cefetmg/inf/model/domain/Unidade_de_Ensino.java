package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

public class Unidade_de_Ensino {
    
    private Long Id;
    
    private String Sigla,
                   Nome,
                   Email,
                   Telefone,
                   CEP,
                   Site;   
    

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        this.Sigla = sigla;
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

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

    public String getCep() {
        return CEP;
    }

    public void setCep(String cep) {
        this.CEP = cep;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        this.Site = site;
    }
                        
    
}
