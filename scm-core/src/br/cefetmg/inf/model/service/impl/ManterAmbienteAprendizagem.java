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
public class ManterAmbienteAprendizagem implements IManterAmbienteAprendizagem {

    @Override
    public Integer cadastrar(AmbienteAprendizagem Ambiente_Aprendizagem) throws PersistenciaException, NegocioException {
        // RN01 : Todo ambiente de aprendizagem deve ser informado
        if (Ambiente_Aprendizagem == null) {
            throw new NegocioException("Todo ambiente de aprendizagem deve ser informado");
        }

        // RN02 : Todo ambiente de aprendizagem deve estar associado a uma unidade de ensino
        if (Ambiente_Aprendizagem.getU_ensino() == null) {
            throw new NegocioException("Todo ambiente de aprendizagem deve estar associado a uma unidade de ensino");
        }

        // RN03 : Todo ambiente de aprendizagem necessita de uma descricao
        if (Ambiente_Aprendizagem.getDescricao() == null) {
            throw new NegocioException("Todo ambiente de aprendizagem necessita de uma descricao");
        }

        // RN04 : Um ambiente de aprendizagem só pode ter capacidade superior a zero
        if (Ambiente_Aprendizagem.getCapacidade() <= 0) {
            throw new NegocioException("Um ambiente de aprendizagem só pode ter capacidade superior a zero");
        }

        IAmbienteAprendizagemDAO Ambiente_AprendizagemDAO = new AmbienteAprendizagemDAO();
        Integer id = Ambiente_AprendizagemDAO.inserir(Ambiente_Aprendizagem);
        Ambiente_Aprendizagem.setId(id);

        return id;
    }

    @Override
    public boolean alterar(AmbienteAprendizagem AmbienteAprendizagem) throws PersistenciaException, NegocioException {

        // RN01 : Todo ambiente de aprendizagem deve ser informado
        if (AmbienteAprendizagem == null) {
            throw new NegocioException("Todo ambiente de aprendizagem deve ser informado");
        }

        // RN01 : Todo ambiente de aprendizagem deve ser informado
        if (AmbienteAprendizagem.getId() == null) {
            throw new NegocioException("Todo ambiente de aprendizagem deve ser informado");
        }

        // RN02 : Todo ambiente de aprendizagem deve estar associado a uma unidade de ensino
        if (AmbienteAprendizagem.getU_ensino() == null) {
            throw new NegocioException("Todo ambiente de aprendizagem deve estar associado a uma unidade de ensino");
        }

        // RN03 : Todo ambiente de aprendizagem necessita de uma descricao
        if (AmbienteAprendizagem.getDescricao() == null) {
            throw new NegocioException("Todo ambiente de aprendizagem necessita de uma descricao");
        }

        // RN04 : Um ambiente de aprendizagem só pode ter capacidade superior a zero
        if (AmbienteAprendizagem.getCapacidade() <= 0) {
            throw new NegocioException("Um ambiente de aprendizagem só pode ter capacidade superior a zero");
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
