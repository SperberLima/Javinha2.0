package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import br.cefetmg.inf.util.db.persistence.GenericDAO;
import java.util.List;

public interface IDisciplinaDAO  extends GenericDAO<Disciplina> {

    public List<Disciplina> listarPorDepartamento(Departamento departamento) throws PersistenciaException;
    
}
