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
public class ManterPeriodoLetivo implements IManterPeriodoLetivo{
    
    @Override
    public Integer cadastrar(PeriodoLetivo PeriodoLetivo) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (PeriodoLetivo.getInicio()== null){
            throw new NegocioException("O periodo letivo deve ter uma data de inicio");
        }
        
        //Curso deve ter Nome
        if (PeriodoLetivo.getFim()== null){
            throw new NegocioException("O periodo letivo deve ter uma data de encerramento");
        }
        
        //Curso deve ter sigla
        if (PeriodoLetivo.getDescricao()== null){
            throw new NegocioException("O periodo letivo deve ter uma descricao");
        }
        
        IPeriodoLetivoDAO Periodo_LetivoDAO = new PeriodoLetivoDAO();
        Integer id = Periodo_LetivoDAO.inserir(PeriodoLetivo);
        PeriodoLetivo.setId(id);
        
        return id;
    }

    @Override
    public boolean alterar(PeriodoLetivo PeriodoLetivo) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (PeriodoLetivo.getInicio()== null){
            throw new NegocioException("O periodo letivo deve ter uma data de inicio");
        }
        
        //Curso deve ter Nome
        if (PeriodoLetivo.getFim()== null){
            throw new NegocioException("O periodo letivo deve ter uma data de termino");
        }
        
        //Curso deve ter sigla
        if (PeriodoLetivo.getDescricao()== null){
            throw new NegocioException("O periodo letivo deve ter uma descricao");
        }
        
        IPeriodoLetivoDAO PeriodoLetivoDAO = new PeriodoLetivoDAO();
        return PeriodoLetivoDAO.atualizar(PeriodoLetivo);
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
