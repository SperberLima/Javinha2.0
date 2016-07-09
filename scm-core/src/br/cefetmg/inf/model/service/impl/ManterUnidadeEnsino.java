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
public class ManterUnidadeEnsino implements IManterUnidadeEnsino{

    @Override
    public void cadastrar(UnidadeEnsino UnidadeEnsino) throws PersistenciaException, NegocioException {
        //Professor deve ter CPF
        if (UnidadeEnsino.getSigla()== null){
            throw new NegocioException("A Unidade de Ensino deve ter sigla");
        }
        
        //Professor deve ter Nome
        if (UnidadeEnsino.getNome() == null){
            throw new NegocioException("A Unidade de Ensino deve ter nome");
        }
        
        //Professor deve ter Nome
        if (UnidadeEnsino.getEmail()== null){
            throw new NegocioException("A Unidade de Ensino deve ter email");
        }

        // Professor deve ter Telefone
        if (UnidadeEnsino.getTelefone() == null){
            throw new NegocioException("A Unidade de Ensino deve ter telefone");
        }
        
        //Professor deve ter Departamento
        if (UnidadeEnsino.getCEP() == null){
            throw new NegocioException("A Unidade de Ensino deve ter CEP");
        }
        
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        Long id = UnidadeEnsinoDAO.inserir(UnidadeEnsino);
        UnidadeEnsino.setId(id);
    }

    @Override
    public void alterar(UnidadeEnsino UnidadeEnsino) throws PersistenciaException, NegocioException {
        //Professor deve ter CPF
        if (UnidadeEnsino.getSigla()== null){
            throw new NegocioException("A Unidade de Ensino deve ter sigla");
        }
        
        //Professor deve ter Nome
        if (UnidadeEnsino.getNome() == null){
            throw new NegocioException("A Unidade de Ensino deve ter nome");
        }
        
        //Professor deve ter Nome
        if (UnidadeEnsino.getEmail()== null){
            throw new NegocioException("A Unidade de Ensino deve ter email");
        }

        // Professor deve ter Telefone
        if (UnidadeEnsino.getTelefone() == null){
            throw new NegocioException("A Unidade de Ensino deve ter telefone");
        }
        
        //Professor deve ter Departamento
        if (UnidadeEnsino.getCEP() == null){
            throw new NegocioException("A Unidade de Ensino deve ter CEP");
        }
        
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        UnidadeEnsinoDAO.atualizar(UnidadeEnsino);
    }

    @Override
    public UnidadeEnsino buscarPorId(Long id) throws PersistenciaException, NegocioException {
        
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        UnidadeEnsino UnidadeEnsino = UnidadeEnsinoDAO.consultarPorId(id);
        return UnidadeEnsino;
    }

    @Override
    public void excluir(UnidadeEnsino UnidadeEnsino) throws PersistenciaException, NegocioException {
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        UnidadeEnsinoDAO.excluir(UnidadeEnsino.getId());
    }

    @Override
    public List<UnidadeEnsino> listarTodos() throws PersistenciaException, NegocioException {
        IUnidadeEnsinoDAO UnidadeEnsinoDAO = new UnidadeEnsinoDAO();
        List<UnidadeEnsino> listUnidadeEnsino = UnidadeEnsinoDAO.listarTodos();
        return listUnidadeEnsino;
    }
    
}
