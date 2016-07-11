package br.cefetmg.inf.model.domain;

public class CurriculoOferta {
    private Integer id;
    private PeriodoLetivo periodoLetivo;
    private GradeCurricular gradeCurricular;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PeriodoLetivo getPeriodoLetivo() {
        return periodoLetivo;
    }

    public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public GradeCurricular getGradeCurricular() {
        return gradeCurricular;
    }

    public void setGradeCurricular(GradeCurricular gradeCurricular) {
        this.gradeCurricular = gradeCurricular;
    }

    
}
