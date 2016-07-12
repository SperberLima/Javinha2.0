/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.dao.impl.TurmaDAO;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Nome
 */
public class ManterTurma implements IManterTurma{

    @Override
    public void cadastrar(Turma turma) throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.inserir(turma);
    }

    @Override
    public void alterar(Turma turma) throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.atualizar(turma);
    }

    @Override
    public Turma buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.consultarPorId(id);
    }

    @Override
    public void excluir(Turma turma) throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.excluir(turma.getId());
    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
