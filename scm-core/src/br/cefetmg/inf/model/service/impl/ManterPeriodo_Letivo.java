/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IPeriodo_LetivoDAO;
import br.cefetmg.inf.model.dao.impl.Periodo_LetivoDAO;
import br.cefetmg.inf.model.domain.Periodo_Letivo;
import br.cefetmg.inf.model.service.IManterPeriodo_Letivo;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterPeriodo_Letivo implements IManterPeriodo_Letivo{
    
    @Override
    public void cadastrar(Periodo_Letivo Periodo_Letivo) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (Periodo_Letivo.getInicio()== null){
            throw new NegocioException("O curso deve pertencer a um departamento");
        }
        
        //Curso deve ter Nome
        if (Periodo_Letivo.getFim()== null){
            throw new NegocioException("O curso deve ter nome");
        }
        
        //Curso deve ter sigla
        if (Periodo_Letivo.getDescricao()== null){
            throw new NegocioException("O curso deve ter sigla");
        }
        
        IPeriodo_LetivoDAO Periodo_LetivoDAO = new Periodo_LetivoDAO();
        Long id = Periodo_LetivoDAO.inserir(Periodo_Letivo);
        Periodo_Letivo.setId(id);
    }

    @Override
    public void alterar(Periodo_Letivo Periodo_Letivo) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (Periodo_Letivo.getInicio()== null){
            throw new NegocioException("O curso deve pertencer a um departamento");
        }
        
        //Curso deve ter Nome
        if (Periodo_Letivo.getFim()== null){
            throw new NegocioException("O curso deve ter nome");
        }
        
        //Curso deve ter sigla
        if (Periodo_Letivo.getDescricao()== null){
            throw new NegocioException("O curso deve ter sigla");
        }
        
        IPeriodo_LetivoDAO Periodo_LetivoDAO = new Periodo_LetivoDAO();
        Periodo_LetivoDAO.atualizar(Periodo_Letivo);
    }

    @Override
    public Periodo_Letivo buscarPorId(Long id) throws PersistenciaException, NegocioException {
        
        IPeriodo_LetivoDAO Periodo_LetivoDAO = new Periodo_LetivoDAO();
        Periodo_Letivo Periodo_Letivo = Periodo_LetivoDAO.consultarPorId(id);
        return Periodo_Letivo;
        
    }

    @Override
    public void excluir(Periodo_Letivo Periodo_Letivo) throws PersistenciaException, NegocioException {
        IPeriodo_LetivoDAO Periodo_LetivoDAO = new Periodo_LetivoDAO();
        Periodo_LetivoDAO.excluir(Periodo_Letivo.getId());
    }

    @Override
    public List<Periodo_Letivo> listarTodos() throws PersistenciaException, NegocioException {
        IPeriodo_LetivoDAO Periodo_LetivoDAO = new Periodo_LetivoDAO();
        List<Periodo_Letivo> listPeriodo_Letivo = Periodo_LetivoDAO.listarTodos();
        return listPeriodo_Letivo;
    }
    
}
