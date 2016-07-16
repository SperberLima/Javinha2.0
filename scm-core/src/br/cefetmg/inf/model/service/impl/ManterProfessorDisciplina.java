/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IProfessorDisciplinaDAO;
import br.cefetmg.inf.model.dao.impl.ProfessorDisciplinaDAO;
import br.cefetmg.inf.model.domain.ProfessorDisciplina;
import br.cefetmg.inf.model.service.IManterProfessorDisciplina;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Nome
 */
public class ManterProfessorDisciplina implements IManterProfessorDisciplina {

    @Override
    public Integer cadastrar(ProfessorDisciplina professorDisciplina) throws PersistenciaException, NegocioException {
        // RN01 : A disciplina e o professor devem ser informados
        if (professorDisciplina == null) {
            throw new NegocioException("A disciplina e o professor devem ser informados");
        }

        // RN02 : A disciplina deve ser informada
        if (professorDisciplina.getDisciplina() == null) {
            throw new NegocioException("A disciplina deve ser informada");
        }

        // RN03 : O professor deve ser informado
        if (professorDisciplina.getProfessor() == null) {
            throw new NegocioException("O professor deve ser informado");
        }

        IProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
        Integer id = professorDisciplinaDAO.inserir(professorDisciplina);

        return id;
    }

    @Override
    public boolean alterar(ProfessorDisciplina professorDisciplina) throws PersistenciaException, NegocioException {
        // RN01 : A disciplina e o professor devem ser informados
        if (professorDisciplina == null) {
            throw new NegocioException("A disciplina e o professor devem ser informados");
        }

        // RN01 : A disciplina e o professor devem ser informados
        if (professorDisciplina.getId() == null) {
            throw new NegocioException("A disciplina e o professor devem ser informados");
        }

        // RN02 : A disciplina deve ser informada
        if (professorDisciplina.getDisciplina() == null) {
            throw new NegocioException("A disciplina deve ser informada");
        }

        // RN03 : O professor deve ser informado
        if (professorDisciplina.getProfessor() == null) {
            throw new NegocioException("O professor deve ser informado");
        }

        IProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
        return professorDisciplinaDAO.atualizar(professorDisciplina);
    }

    @Override
    public ProfessorDisciplina buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        IProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
        return professorDisciplinaDAO.consultarPorId(id);
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
        return professorDisciplinaDAO.excluir(id);
    }

    @Override
    public List<ProfessorDisciplina> listarTodos() throws PersistenciaException, NegocioException {
        IProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
        return professorDisciplinaDAO.listarTodos();
    }

}
