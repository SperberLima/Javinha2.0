package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUnidadeEnsinoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeEnsinoDAO implements IUnidadeEnsinoDAO {

    @Override
    public Long inserir(UnidadeEnsino obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(UnidadeEnsino obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UnidadeEnsino consultarPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UnidadeEnsino> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    
    
}
