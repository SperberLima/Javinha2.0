/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IAmbienteAprendizagemDAO;
import br.cefetmg.inf.model.dao.impl.AmbienteAprendizagemDAO;
import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.model.service.IManterAmbienteAprendizagem;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterAmbienteAprendizagem implements IManterAmbienteAprendizagem{

    @Override
    public Integer cadastrar(AmbienteAprendizagem Ambiente_Aprendizagem) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (Ambiente_Aprendizagem.getU_ensino()== null){
            throw new NegocioException("Todo ambiente de aprendizagem deve estar associado a uma unidade de ensino");
        }
        
        //Curso deve ter Nome
        if (Ambiente_Aprendizagem.getDescricao()== null){
            throw new NegocioException("Todo ambiente de aprendizagem necessita de uma descricao");
        }
        
        //Curso deve ter sigla
        if (Ambiente_Aprendizagem.getCapacidade() <= 0){
            throw new NegocioException("Um ambiente de aprendizagem só pode ter capacidade superior a zero");
        }
        
        IAmbienteAprendizagemDAO Ambiente_AprendizagemDAO = new AmbienteAprendizagemDAO();
        Integer id = Ambiente_AprendizagemDAO.inserir(Ambiente_Aprendizagem);
        Ambiente_Aprendizagem.setId(id);
        
        return id;
    }

    @Override
    public boolean alterar(AmbienteAprendizagem AmbienteAprendizagem) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (AmbienteAprendizagem.getU_ensino()== null){
            throw new NegocioException("O curso deve pertencer a um departamento");
        }
        
        //Curso deve ter Nome
        if (AmbienteAprendizagem.getDescricao()== null){
            throw new NegocioException("O curso deve ter nome");
        }
        
        //Curso deve ter sigla
        if (AmbienteAprendizagem.getCapacidade() == 0){
            throw new NegocioException("O curso deve ter sigla");
        }
        
        IAmbienteAprendizagemDAO AmbienteAprendizagemDAO = new AmbienteAprendizagemDAO();
        return AmbienteAprendizagemDAO.atualizar(AmbienteAprendizagem);
    }

    @Override
    public AmbienteAprendizagem buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        
        IAmbienteAprendizagemDAO AmbienteAprendizagemDAO = new AmbienteAprendizagemDAO();
        AmbienteAprendizagem AmbienteAprendizagem = AmbienteAprendizagemDAO.consultarPorId(id);
        return AmbienteAprendizagem;
        
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IAmbienteAprendizagemDAO AmbienteAprendizagemDAO = new AmbienteAprendizagemDAO();
        return AmbienteAprendizagemDAO.excluir(id);
    }

    @Override
    public List<AmbienteAprendizagem> listarTodos() throws PersistenciaException, NegocioException {
        IAmbienteAprendizagemDAO AmbienteAprendizagemDAO = new AmbienteAprendizagemDAO();
        List<AmbienteAprendizagem> listCurso = AmbienteAprendizagemDAO.listarTodos();
        return listCurso;
    }
    
}
