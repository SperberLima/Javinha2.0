/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IDepartamentoDAO;
import br.cefetmg.inf.model.dao.impl.DepartamentoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.service.IManterDepartamento;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterDepartamento implements IManterDepartamento{

    @Override
    public void cadastrar(Departamento departamento) throws PersistenciaException, NegocioException {
        //Departamento deve ter sigla
        if (departamento.getSigla() == null){
            throw new NegocioException("Departamento deve ter sigla");
        }
        
        //Departamento deve ter nome
        if (departamento.getNome() == null){
            throw new NegocioException("Departamento deve ter nome");
        }
        
        //Departamento deve ter email
        if (departamento.getEmail() == null){
            throw new NegocioException("Departamento deve ter email");
        }
        
        //Departamento deve ter telefone
        if (departamento.getTelefone() == null){
            throw new NegocioException("Departamento deve ter telefone");
        }
        
        //Departamento deve ter CEP
        if (departamento.getCEP() == null){
            throw new NegocioException("Departamento deve ter CEP");
        }
        
        //Departamento deve estar associado a uma unidade de ensino
        if (departamento.getUnidadeEnsino().getId() == null){
            throw new NegocioException("Departamento deve estar associado a uma unidade de ensino");
        }
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Long id = departamentoDAO.inserir(departamento);
        departamento.setId(id);
    }

    @Override
    public void alterar(Departamento departamento) throws PersistenciaException, NegocioException {
        //Departamento deve ter sigla
        if (departamento.getSigla() == null){
            throw new NegocioException("Departamento deve ter sigla");
        }
        
        //Departamento deve ter nome
        if (departamento.getNome() == null){
            throw new NegocioException("Departamento deve ter nome");
        }
        
        //Departamento deve ter email
        if (departamento.getEmail() == null){
            throw new NegocioException("Departamento deve ter email");
        }
        
        //Departamento deve ter telefone
        if (departamento.getTelefone() == null){
            throw new NegocioException("Departamento deve ter telefone");
        }
        
        //Departamento deve ter CEP
        if (departamento.getCEP() == null){
            throw new NegocioException("Departamento deve ter CEP");
        }
        
        //Departamento deve estar associado a uma unidade de ensino
        if (departamento.getUnidadeEnsino().getId() == null){
            throw new NegocioException("Departamento deve estar associado a uma unidade de ensino");
        }
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamentoDAO.atualizar(departamento);
    }

    @Override
    public Departamento buscarPorId(Long id) throws PersistenciaException, NegocioException {
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Departamento departamento = departamentoDAO.consultarPorId(id);
        return departamento;
        
    }

    @Override
    public void excluir(Departamento departamento) throws PersistenciaException, NegocioException {
        
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamentoDAO.excluir(departamento.getId());
    }

    @Override
    public List<Departamento> listarTodos() throws PersistenciaException, NegocioException {
        IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> listDepartamento = departamentoDAO.listarTodos();
        return listDepartamento;
    }
    
}
