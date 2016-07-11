package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IGradeCurricularDAO;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

public class GradeCurricularDAO implements IGradeCurricularDAO {

    @Override
    public Integer inserir(GradeCurricular obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(GradeCurricular obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public GradeCurricular consultarPorId(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<GradeCurricular> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<GradeCurricular> listarPorCurso(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
