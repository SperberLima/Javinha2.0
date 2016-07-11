package br.cefetmg.inf.model.domain;

public class Disciplina {

    private Integer Id;
    private String Nome,
            Ementa;
    private int CargaHoraria;
    private Departamento departamento;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmenta() {
        return Ementa;
    }

    public void setEmenta(String Ementa) {
        this.Ementa = Ementa;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
