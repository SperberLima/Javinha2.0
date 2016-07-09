package br.cefetmg.inf.model.domain;

import java.util.ArrayList;
import java.util.Objects;

public class UnidadeEnsino {

    private Long Id;
    private String Sigla;
    private String Nome;
    private String Email;
    private String Telefone;
    private Long CEP;
    private String Site;
    private ArrayList<Ambiente_Aprendizagem> Ambientes;
    private ArrayList<Departamento> Departamentos;

    public UnidadeEnsino() {
    }

    public Long getCEP() {
        return CEP;
    }

    public void setCEP(Long CEP) {
        this.CEP = CEP;
    }

    public ArrayList<Ambiente_Aprendizagem> getAmbientes() {
        return Ambientes;
    }

    public void setAmbientes(ArrayList<Ambiente_Aprendizagem> Ambientes) {
        this.Ambientes = Ambientes;
    }

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

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        this.Site = site;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.Departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeEnsino other = (UnidadeEnsino) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
}
