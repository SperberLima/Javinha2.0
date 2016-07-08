package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IGradeCurricularDAO;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public class GradeCurricularDAO implements IGradeCurricularDAO {

    @Override
    public Long inserir(GradeCurricular obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(GradeCurricular obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public GradeCurricular consultarPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<GradeCurricular> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
