package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.util.db.persistence.GenericDAO;
import java.util.List;

public interface IDisciplinaDAO  extends GenericDAO<Disciplina> {

    public List<Disciplina> listarPorGrade();
    
}
