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

        // RN01 : Currículo em oferta deve ser informado
        if (curriculoOferta == null) {
            throw new NegocioException("Todo currículo em oferta deve ser informado");
        }

        // RN02 : Currículo em oferta deve ter um período letivo
        if (curriculoOferta.getPeriodoLetivo() == null) {
            throw new NegocioException("Todo currículo em oferta deve ter um período letivo associado a ele");
        }

        // RN03 : Currículo em oferta deve ter uma grade curricular associada a ele
        if (curriculoOferta.getGradeCurricular() == null) {
            throw new NegocioException("Todo currículo em oferta deve ter uma grade curricular associada a ele");
        }

        ICurriculoOfertaDAO Curriculo_OfertaDAO = new CurriculoOfertaDAO();
        Integer id = Curriculo_OfertaDAO.inserir(curriculoOferta);
        curriculoOferta.setId(id);

        return id;
    }

    @Override
    public boolean alterar(CurriculoOferta curriculoOferta) throws PersistenciaException, NegocioException {
        // RN01 : Currículo em oferta deve ser informado
        if (curriculoOferta == null) {
            throw new NegocioException("Todo currículo em oferta deve ser informado");
        }

        // RN01 : Currículo em oferta deve ser informado
        if (curriculoOferta.getId() == null) {
            throw new NegocioException("Todo currículo em oferta deve ser informado");
        }

        // RN02 : Currículo em oferta deve ter um período letivo
        if (curriculoOferta.getPeriodoLetivo() == null) {
            throw new NegocioException("Todo currículo em oferta deve ter um período letivo associado a ele");
        }

        // RN03 : Currículo em oferta deve ter uma grade curricular associada a ele
        if (curriculoOferta.getGradeCurricular() == null) {
            throw new NegocioException("Todo currículo em oferta deve ter uma grade curricular associada a ele");
        }

        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        return CurriculoOfertaDAO.atualizar(curriculoOferta);
    }

    @Override
    public CurriculoOferta buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        CurriculoOferta curriculoOferta = CurriculoOfertaDAO.consultarPorId(id);
        return curriculoOferta;
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        return CurriculoOfertaDAO.excluir(id);
    }

    @Override
    public List<CurriculoOferta> listarTodos() throws PersistenciaException, NegocioException {
        ICurriculoOfertaDAO CurriculoOfertaDAO = new CurriculoOfertaDAO();
        List<CurriculoOferta> listCurriculoOferta = CurriculoOfertaDAO.listarTodos();
        return listCurriculoOferta;
    }

}
