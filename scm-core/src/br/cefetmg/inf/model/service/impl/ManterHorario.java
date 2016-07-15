/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IHorarioDAO;
import br.cefetmg.inf.model.dao.impl.HorarioDAO;
import br.cefetmg.inf.model.domain.Horario;
import br.cefetmg.inf.model.service.IManterHorario;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Nome
 */
public class ManterHorario implements IManterHorario{

    @Override
    public Integer cadastrar(Horario horario) throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        Integer id = horarioDAO.inserir(horario);
        
        return id;
    }

    @Override
    public void alterar(Horario horario) throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        horarioDAO.atualizar(horario);
    }

    @Override
    public Horario buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        return horarioDAO.consultarPorId(id);
    }

    @Override
    public void excluir(Horario horario) throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        horarioDAO.excluir(horario.getId());
    }

    @Override
    public List<Horario> listarTodos() throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        return horarioDAO.listarTodos();
    }
    
}
