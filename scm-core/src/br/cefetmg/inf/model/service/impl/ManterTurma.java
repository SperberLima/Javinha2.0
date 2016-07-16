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
public class ManterTurma implements IManterTurma {

    @Override
    public Integer cadastrar(Turma turma) throws PersistenciaException, NegocioException {
        // RN01 : A turma deve ser informada.
        if (turma == null) {
            throw new NegocioException("A turma deve ser informada");
        }

        // RN02 : A turma deve estar relacionada à algum currículo em oferta.
        if (turma.getCurriculoOferta() == null) {
            throw new NegocioException("A turma deve estar relacionada à algum currículo em oferta.");
        }

        // RN02 : A turma deve ter nome.
        if (turma.getNome() == null) {
            throw new NegocioException("A turma deve ter nome");
        }

        ITurmaDAO turmaDAO = new TurmaDAO();
        Integer id = turmaDAO.inserir(turma);

        return id;
    }

    @Override
    public boolean alterar(Turma turma) throws PersistenciaException, NegocioException {
        // RN01 : A turma deve ser informada.
        if (turma == null) {
            throw new NegocioException("A turma deve ser informada");
        }
        
        // RN01 : A turma deve ser informada.
        if (turma.getId() == null) {
            throw new NegocioException("A turma deve ser informada");
        }
        
        // RN02 : A turma deve estar relacionada à algum currículo em oferta.
        if (turma.getCurriculoOferta() == null) {
            throw new NegocioException("A turma deve estar relacionada à algum currículo em oferta.");
        }

        // RN02 : A turma deve ter nome.
        if (turma.getNome() == null) {
            throw new NegocioException("A turma deve ter nome");
        }
        
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.atualizar(turma);
    }

    @Override
    public Turma buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.consultarPorId(id);
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.excluir(id);
    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.listarTodos();
    }

}
