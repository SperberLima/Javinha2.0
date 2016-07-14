/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.ICurriculoOfertaDAO;
import br.cefetmg.inf.model.dao.impl.CurriculoOfertaDAO;
import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.service.IManterCurriculoOferta;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Diego
 */
public class ManterCurriculoOferta implements IManterCurriculoOferta {

    @Override
    public Integer cadastrar(CurriculoOferta curriculoOferta) throws PersistenciaException, NegocioException {
        
        //Currículo em oferta deve ter um período letivo associado a ele
        if (curriculoOferta.getPeriodoLetivo() == null){
            throw new NegocioException("O currículo ofertado deve ter um período letivo");
        }
        
        //Currículo em oferta deve ter uma grade curricular associado a ele.
        if(curriculoOferta.getGradeCurricular() == null) {
            throw new NegocioException("O currículo ofertado deve ter uma grade curricular.");
        }
        
        ICurriculoOfertaDAO cursoDAO = new CurriculoOfertaDAO();
        Integer id = cursoDAO.inserir(curriculoOferta);
        curriculoOferta.setId(id);
        
        return id;
    }

    @Override
    public void alterar(CurriculoOferta curriculoOferta) throws PersistenciaException, NegocioException {
        
        //Currículo em oferta deve ter um período letivo associado a ele
        if (curriculoOferta.getPeriodoLetivo() == null){
            throw new NegocioException("O currículo ofertado deve ter um período letivo");
        }
        
        //Currículo em oferta deve ter uma grade curricular associado a ele.
        if(curriculoOferta.getGradeCurricular() == null) {
            throw new NegocioException("O currículo ofertado deve ter uma grade curricular.");
        }
        
        ICurriculoOfertaDAO curriculoOfertaDAO = new CurriculoOfertaDAO();
        curriculoOfertaDAO.atualizar(curriculoOferta);
    }

    @Override
    public CurriculoOferta buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        CurriculoOferta CurriculoOferta = CurriculoOfertaDAO.consultarPorId(id);
        return CurriculoOferta;
    }

    @Override
    public void excluir(CurriculoOferta curriculoOferta) throws PersistenciaException, NegocioException {
        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        CurriculoOfertaDAO.excluir(curriculoOferta.getId());
    }

    @Override
    public List<CurriculoOferta> listarTodos() throws PersistenciaException, NegocioException {
        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        List<CurriculoOferta> listCurriculoOferta = CurriculoOfertaDAO.listarTodos();
        return listCurriculoOferta;
    }
    
}
