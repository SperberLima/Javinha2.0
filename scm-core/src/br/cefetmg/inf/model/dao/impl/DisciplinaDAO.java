package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDisciplinaDAO;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public class DisciplinaDAO implements IDisciplinaDAO {

    @Override
    public Long inserir(Disciplina obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Disciplina obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Disciplina consultarPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Disciplina> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
