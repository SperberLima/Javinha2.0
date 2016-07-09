/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IAmbiente_AprendizagemDAO;
import br.cefetmg.inf.model.dao.impl.Ambiente_AprendizagemDAO;
import br.cefetmg.inf.model.domain.Ambiente_Aprendizagem;
import br.cefetmg.inf.model.service.IManterAmbiente_Aprendizagem;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterAmbiente_Aprendizagem implements IManterAmbiente_Aprendizagem{

    @Override
    public void cadastrar(Ambiente_Aprendizagem Ambiente_Aprendizagem) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (Ambiente_Aprendizagem.getU_ensino()== null){
            throw new NegocioException("O curso deve pertencer a um departamento");
        }
        
        //Curso deve ter Nome
        if (Ambiente_Aprendizagem.getDescricao()== null){
            throw new NegocioException("O curso deve ter nome");
        }
        
        //Curso deve ter sigla
        if (Ambiente_Aprendizagem.getCapacidade() == 0){
            throw new NegocioException("O curso deve ter sigla");
        }
        
        IAmbiente_AprendizagemDAO Ambiente_AprendizagemDAO = new Ambiente_AprendizagemDAO();
        Long id = Ambiente_AprendizagemDAO.inserir(Ambiente_Aprendizagem);
        Ambiente_Aprendizagem.setId(id);
    }

    @Override
    public void alterar(Ambiente_Aprendizagem Ambiente_Aprendizagem) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (Ambiente_Aprendizagem.getU_ensino()== null){
            throw new NegocioException("O curso deve pertencer a um departamento");
        }
        
        //Curso deve ter Nome
        if (Ambiente_Aprendizagem.getDescricao()== null){
            throw new NegocioException("O curso deve ter nome");
        }
        
        //Curso deve ter sigla
        if (Ambiente_Aprendizagem.getCapacidade() == 0){
            throw new NegocioException("O curso deve ter sigla");
        }
        
        IAmbiente_AprendizagemDAO Ambiente_AprendizagemDAO = new Ambiente_AprendizagemDAO();
        Ambiente_AprendizagemDAO.atualizar(Ambiente_Aprendizagem);
    }

    @Override
    public Ambiente_Aprendizagem buscarPorId(Long id) throws PersistenciaException, NegocioException {
        
        IAmbiente_AprendizagemDAO Ambiente_AprendizagemDAO = new Ambiente_AprendizagemDAO();
        Ambiente_Aprendizagem Ambiente_Aprendizagem = Ambiente_AprendizagemDAO.consultarPorId(id);
        return Ambiente_Aprendizagem;
        
    }

    @Override
    public void excluir(Ambiente_Aprendizagem Ambiente_Aprendizagem) throws PersistenciaException, NegocioException {
        IAmbiente_AprendizagemDAO Ambiente_AprendizagemDAO = new Ambiente_AprendizagemDAO();
        Ambiente_AprendizagemDAO.excluir(Ambiente_Aprendizagem.getId());
    }

    @Override
    public List<Ambiente_Aprendizagem> listarTodos() throws PersistenciaException, NegocioException {
        IAmbiente_AprendizagemDAO Ambiente_AprendizagemDAO = new Ambiente_AprendizagemDAO();
        List<Ambiente_Aprendizagem> listCurso = Ambiente_AprendizagemDAO.listarTodos();
        return listCurso;
    }
    
}
