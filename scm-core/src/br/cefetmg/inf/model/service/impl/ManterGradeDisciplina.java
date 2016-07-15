/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IGradeDisciplinaDAO;
import br.cefetmg.inf.model.dao.impl.GradeDisciplinaDAO;
import br.cefetmg.inf.model.domain.GradeDisciplina;
import br.cefetmg.inf.model.service.IManterGradeDisciplina;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Nome
 */
public class ManterGradeDisciplina implements IManterGradeDisciplina{

    @Override
    public Integer cadastrar(GradeDisciplina e) throws PersistenciaException, NegocioException {
        IGradeDisciplinaDAO gradeDisciplinaDAO = new GradeDisciplinaDAO();
        return gradeDisciplinaDAO.inserir(e);
    }

    @Override
    public boolean alterar(GradeDisciplina e) throws PersistenciaException, NegocioException {
        IGradeDisciplinaDAO gradeDisciplinaDAO = new GradeDisciplinaDAO();
        return gradeDisciplinaDAO.atualizar(e);
    }

    @Override
    public GradeDisciplina buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        IGradeDisciplinaDAO gradeDisciplinaDAO = new GradeDisciplinaDAO();
        return gradeDisciplinaDAO.consultarPorId(id);
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IGradeDisciplinaDAO gradeDisciplinaDAO = new GradeDisciplinaDAO();
        return gradeDisciplinaDAO.excluir(id);
    }

    @Override
    public List<GradeDisciplina> listarTodos() throws PersistenciaException, NegocioException {
        IGradeDisciplinaDAO gradeDisciplinaDAO = new GradeDisciplinaDAO();
        return gradeDisciplinaDAO.listarTodos();
    }
    
}
