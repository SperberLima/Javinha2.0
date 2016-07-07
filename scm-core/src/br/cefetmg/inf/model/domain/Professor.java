package br.cefetmg.inf.model.domain;

public class Professor {
    private Long Id;
    private Departamento Dpto;
    private String Nome, 
                   Descricao,
                   Telefone;

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
