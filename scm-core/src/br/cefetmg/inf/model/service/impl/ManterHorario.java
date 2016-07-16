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
public class ManterHorario implements IManterHorario {

    @Override
    public Integer cadastrar(Horario horario) throws PersistenciaException, NegocioException {
        // RN01 : O horário deve ser informado
        if (horario == null) {
            throw new NegocioException("O horário deve ser informado");
        }

        // RN02 : A data de início deve ser informada
        if (horario.getInicio() == null) {
            throw new NegocioException("A data de início deve ser informada");
        }

        // RN03 : A data de fim deve ser informada
        if (horario.getFim() == null) {
            throw new NegocioException("A data de fim deve ser informada");
        }

        // RN04 : O professor e a disciplina devem ser informados
        if (horario.getProfessorDisciplina() == null) {
            throw new NegocioException("O professor e a disciplina devem ser informados");
        }

        // RN05 : A turma deve ser informada
        if (horario.getTurma() == null) {
            throw new NegocioException("A turma deve ser informada");
        }

        // RN06 : O ambiente de aprendizagem deve ser informado
        if (horario.getAmbiente() == null) {
            throw new NegocioException("O ambiente de aprendizagem deve ser informado");
        }

        IHorarioDAO horarioDAO = new HorarioDAO();
        Integer id = horarioDAO.inserir(horario);

        return id;
    }

    @Override
    public boolean alterar(Horario horario) throws PersistenciaException, NegocioException {
        // RN01 : O horário deve ser informado
        if (horario == null) {
            throw new NegocioException("O horário deve ser informado");
        }

        // RN01 : O horário deve ser informado
        if (horario.getId() == null) {
            throw new NegocioException("O horário deve ser informado");
        }

        // RN02 : A data de início deve ser informada
        if (horario.getInicio() == null) {
            throw new NegocioException("A data de início deve ser informada");
        }

        // RN03 : A data de fim deve ser informada
        if (horario.getFim() == null) {
            throw new NegocioException("A data de fim deve ser informada");
        }

        // RN04 : O professor e a disciplina devem ser informados
        if (horario.getProfessorDisciplina() == null) {
            throw new NegocioException("O professor e a disciplina devem ser informados");
        }

        // RN05 : A turma deve ser informada
        if (horario.getTurma() == null) {
            throw new NegocioException("A turma deve ser informada");
        }

        // RN06 : O ambiente de aprendizagem deve ser informado
        if (horario.getAmbiente() == null) {
            throw new NegocioException("O ambiente de aprendizagem deve ser informado");
        }

        IHorarioDAO horarioDAO = new HorarioDAO();
        return horarioDAO.atualizar(horario);
    }

    @Override
    public Horario buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        return horarioDAO.consultarPorId(id);
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        return horarioDAO.excluir(id);
    }

    @Override
    public List<Horario> listarTodos() throws PersistenciaException, NegocioException {
        IHorarioDAO horarioDAO = new HorarioDAO();
        return horarioDAO.listarTodos();
    }

}
