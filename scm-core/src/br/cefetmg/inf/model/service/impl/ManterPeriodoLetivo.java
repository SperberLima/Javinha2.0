/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IPeriodoLetivoDAO;
import br.cefetmg.inf.model.dao.impl.PeriodoLetivoDAO;
import br.cefetmg.inf.model.domain.PeriodoLetivo;
import br.cefetmg.inf.model.service.IManterPeriodoLetivo;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterPeriodoLetivo implements IManterPeriodoLetivo {

    @Override
    public Integer cadastrar(PeriodoLetivo periodoLetivo) throws PersistenciaException, NegocioException {
        // RN01 : O período deve ser informado
        if (periodoLetivo == null) {
            throw new NegocioException("O periodo letivo deve ser informado");
        }

        // RN02 : O período deve ter uma data de início
        if (periodoLetivo.getInicio() == null) {
            throw new NegocioException("O periodo letivo deve ter uma data de inicio");
        }

        // RN03 : O período deve ter uma data de encerramento
        if (periodoLetivo.getFim() == null) {
            throw new NegocioException("O periodo letivo deve ter uma data de encerramento");
        }

        // RN04 : O período deve ter uma descrição
        if (periodoLetivo.getDescricao() == null) {
            throw new NegocioException("O periodo letivo deve ter uma descricao");
        }

        IPeriodoLetivoDAO Periodo_LetivoDAO = new PeriodoLetivoDAO();
        Integer id = Periodo_LetivoDAO.inserir(periodoLetivo);
        periodoLetivo.setId(id);

        return id;
    }

    @Override
    public boolean alterar(PeriodoLetivo periodoLetivo) throws PersistenciaException, NegocioException {
        // RN01 : O período deve ser informado
        if (periodoLetivo == null) {
            throw new NegocioException("O periodo letivo deve ser informado");
        }

        // RN01 : O período deve ser informado
        if (periodoLetivo.getId() == null) {
            throw new NegocioException("O periodo letivo deve ser informado");
        }

        // RN02 : O período deve ter uma data de início
        if (periodoLetivo.getInicio() == null) {
            throw new NegocioException("O periodo letivo deve ter uma data de inicio");
        }

        // RN03 : O período deve ter uma data de encerramento
        if (periodoLetivo.getFim() == null) {
            throw new NegocioException("O periodo letivo deve ter uma data de encerramento");
        }

        // RN04 : O período deve ter uma descrição
        if (periodoLetivo.getDescricao() == null) {
            throw new NegocioException("O periodo letivo deve ter uma descricao");
        }

        IPeriodoLetivoDAO PeriodoLetivoDAO = new PeriodoLetivoDAO();
        return PeriodoLetivoDAO.atualizar(periodoLetivo);
    }

    @Override
    public PeriodoLetivo buscarPorId(Integer id) throws PersistenciaException, NegocioException {

        IPeriodoLetivoDAO PeriodoLetivoDAO = new PeriodoLetivoDAO();
        PeriodoLetivo PeriodoLetivo = PeriodoLetivoDAO.consultarPorId(id);
        return PeriodoLetivo;

    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IPeriodoLetivoDAO PeriodoLetivoDAO = new PeriodoLetivoDAO();
        return PeriodoLetivoDAO.excluir(id);
    }

    @Override
    public List<PeriodoLetivo> listarTodos() throws PersistenciaException, NegocioException {
        IPeriodoLetivoDAO PeriodoLetivoDAO = new PeriodoLetivoDAO();
        List<PeriodoLetivo> listPeriodoLetivo = PeriodoLetivoDAO.listarTodos();
        return listPeriodoLetivo;
    }

}
