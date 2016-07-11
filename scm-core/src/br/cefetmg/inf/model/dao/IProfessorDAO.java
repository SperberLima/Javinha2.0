package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import br.cefetmg.inf.util.db.persistence.GenericNamedDAO;
import java.util.ArrayList;

public interface IProfessorDAO extends GenericNamedDAO<Professor> {
    public ArrayList<Disciplina> listarDisciplinas(Professor professor) throws PersistenciaException;
}
