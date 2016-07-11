package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.util.db.persistence.GenericDAO;
import java.util.List;

public interface IGradeCurricularDAO extends GenericDAO<GradeCurricular> {

    public List<GradeCurricular> listarPorCurso(Integer id);
    
}
