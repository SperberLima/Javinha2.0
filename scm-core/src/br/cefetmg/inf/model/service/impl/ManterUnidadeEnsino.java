/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IUnidadeEnsinoDAO;
import br.cefetmg.inf.model.dao.impl.UnidadeEnsinoDAO;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.model.service.IManterUnidadeEnsino;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterUnidadeEnsino implements IManterUnidadeEnsino {

    @Override
    public Integer cadastrar(UnidadeEnsino UnidadeEnsino) throws PersistenciaException, NegocioException {
        // RN01 : A unidade de ensino deve ser informada
        if (UnidadeEnsino == null) {
            throw new NegocioException("A Unidade de Ensino deve ser informada");
        }

        // RN02 : A Unidade de Ensino deve ter sigla
        if (UnidadeEnsino.getSigla() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter sigla");
        }

        // RN03 : A Unidade de Ensino deve ter um nome 
        if (UnidadeEnsino.getNome() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter nome");
        }

        // RN04 : A Unidade de Ensino deve ter um email
        if (UnidadeEnsino.getEmail() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter email");
        }

        // RN05 : A Unidade de Ensino deve ter um telefone
        if (UnidadeEnsino.getTelefone() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter telefone");
        }

        //RN06 : A Unidade de Ensino deve ter um CEP 
        if (UnidadeEnsino.getCEP() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter CEP");
        }

        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        Integer id = UnidadeEnsinoDAO.inserir(UnidadeEnsino);
        UnidadeEnsino.setId(id);

        return id;
    }

    @Override
    public boolean alterar(UnidadeEnsino UnidadeEnsino) throws PersistenciaException, NegocioException {
        // RN01 : A unidade de ensino deve ser informada
        if (UnidadeEnsino == null) {
            throw new NegocioException("A Unidade de Ensino deve ser informada");
        }

        // RN02 : A Unidade de Ensino deve ter sigla
        if (UnidadeEnsino.getSigla() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter sigla");
        }

        // RN03 : A Unidade de Ensino deve ter um nome 
        if (UnidadeEnsino.getNome() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter nome");
        }

        // RN04 : A Unidade de Ensino deve ter um email
        if (UnidadeEnsino.getEmail() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter email");
        }

        // RN05 : A Unidade de Ensino deve ter um telefone
        if (UnidadeEnsino.getTelefone() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter telefone");
        }

        //RN06 : A Unidade de Ensino deve ter um CEP 
        if (UnidadeEnsino.getCEP() == null) {
            throw new NegocioException("A Unidade de Ensino deve ter CEP");
        }

        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        return UnidadeEnsinoDAO.atualizar(UnidadeEnsino);
    }

    @Override
    public UnidadeEnsino buscarPorId(Integer id) throws PersistenciaException, NegocioException {

        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        UnidadeEnsino UnidadeEnsino = UnidadeEnsinoDAO.consultarPorId(id);
        return UnidadeEnsino;
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        return UnidadeEnsinoDAO.excluir(id);
    }

    @Override
    public List<UnidadeEnsino> listarTodos() throws PersistenciaException, NegocioException {
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        List<UnidadeEnsino> listUnidadeEnsino = UnidadeEnsinoDAO.listarTodos();
        return listUnidadeEnsino;
    }

}
