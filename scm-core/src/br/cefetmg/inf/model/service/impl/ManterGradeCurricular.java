/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IDisciplinaDAO;
import br.cefetmg.inf.model.dao.IGradeCurricularDAO;
import br.cefetmg.inf.model.dao.impl.DisciplinaDAO;
import br.cefetmg.inf.model.dao.impl.GradeCurricularDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterGradeCurricular implements IManterGradeCurricular {

    @Override
    public Integer cadastrar(GradeCurricular gradeCurricular) throws PersistenciaException, NegocioException {

        // RN01 : A grade curricular deve ser informada
        if (gradeCurricular == null) {
            throw new NegocioException("A grade curricular deve ser informada");
        }

        // RN02 : A grade curricular deve ter uma decsrição
        if (gradeCurricular.getDescricao() == null) {
            throw new NegocioException("A grade curricular deve ter uma descrição");
        }

        // RN03 : A grade curricular deve representar uma série válida
        if (gradeCurricular.getSerie() < 0) {
            throw new NegocioException("A grade curricular deve representar uma série válida");
        }

        // RN04 : A grade curricular deve estar associada a um curso
        if (gradeCurricular.getCurso() == null) {
            throw new NegocioException("Toda grade deve estar associada a um curso");
        }

        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        Integer id = GradeCurricularDAO.inserir(gradeCurricular);
        gradeCurricular.setId(id);

        return id;
    }

    @Override
    public boolean alterar(GradeCurricular gradeCurricular) throws PersistenciaException, NegocioException {

        // RN01 : A grade curricular deve ser informada
        if (gradeCurricular == null) {
            throw new NegocioException("A grade curricular deve ser informada");
        }

        // RN01 : A grade curricular deve ser informada
        if (gradeCurricular.getId() == null) {
            throw new NegocioException("A grade curricular deve ser informada");
        }

        // RN02 : A grade curricular deve ter uma decsrição
        if (gradeCurricular.getDescricao() == null) {
            throw new NegocioException("A grade curricular deve ter uma descrição");
        }

        // RN03 : A grade curricular deve representar uma série válida
        if (gradeCurricular.getSerie() < 0) {
            throw new NegocioException("A grade curricular deve representar uma série válida");
        }

        // RN04 : A grade curricular deve estar associada a um curso
        if (gradeCurricular.getCurso() == null) {
            throw new NegocioException("Toda grade deve estar associada a um curso");
        }

        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        return GradeCurricularDAO.atualizar(gradeCurricular);
    }

    @Override
    public GradeCurricular buscarPorId(Integer id) throws PersistenciaException, NegocioException {

        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        GradeCurricular GradeCurricular = GradeCurricularDAO.consultarPorId(id);
        return GradeCurricular;

    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        return GradeCurricularDAO.excluir(id);
    }

    @Override
    public List<GradeCurricular> listarTodos() throws PersistenciaException, NegocioException {
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        List<GradeCurricular> listGrade = GradeCurricularDAO.listarTodos();
        return listGrade;
    }

    public List<Disciplina> listarDisciplinas(GradeCurricular gradeCurricular) throws PersistenciaException, NegocioException {

        // RN01 : A grade curricular deve ser informada
        if (gradeCurricular == null) {
            throw new NegocioException("A grade curricular deve ser informada");
        }

        IGradeCurricularDAO gradeDAO = new GradeCurricularDAO();
        List<Disciplina> listDisciplina = gradeDAO.listarDisciplinas(gradeCurricular);
        return listDisciplina;
    }

}
