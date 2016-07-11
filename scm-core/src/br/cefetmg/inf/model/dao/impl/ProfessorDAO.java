package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IProfessorDAO;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public class ProfessorDAO implements IProfessorDAO {

    @Override
    public Professor consultarPorNome(String nome) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer inserir(Professor obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Professor obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Professor consultarPorId(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Professor> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ArrayList<Disciplina> listarDisciplinas(Professor professor) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
