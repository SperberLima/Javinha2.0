/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IDisciplinaDAO;
import br.cefetmg.inf.model.dao.impl.DisciplinaDAO;
import br.cefetmg.inf.model.dao.impl.GradeCurricularDAO;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.domain.GradeDisciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterDisciplina implements IManterDisciplina {

    @Override
    public Integer cadastrar(Disciplina disciplina) throws PersistenciaException, NegocioException {
        // RN01 : Diciplina deve ser informada
        if (disciplina == null) {
            throw new NegocioException("A disciplina deve ser informada");
        }

        // RN02 : Disciplina deve ter carga horaria
        if (disciplina.getCargaHoraria() <= 0) {
            throw new NegocioException("A disciplina deve ter carga horaria");
        }

        // RN03 : Disciplina deve ter Nome
        if (disciplina.getNome() == null) {
            throw new NegocioException("A disciplina deve ter nome");
        }

        // RN04 : Disciplina deve ter Departamento
        if (disciplina.getDepartamento() == null) {
            throw new NegocioException("A disciplina deve estar relacionada a um departamento");
        }

        // RN05 : Disciplina deve ter uma Ementa
        if (disciplina.getEmenta() == null) {
            throw new NegocioException("A disciplina deve ter uma ementa");
        }

        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Integer id = disciplinaDAO.inserir(disciplina);
        disciplina.setId(id);

        return id;
    }

    @Override
    public boolean alterar(Disciplina disciplina) throws PersistenciaException, NegocioException {
        // RN01 : Diciplina deve ser informada
        if (disciplina == null) {
            throw new NegocioException("A disciplina deve ser informada");
        }

        // RN01 : Diciplina deve ser informada
        if (disciplina.getId() == null) {
            throw new NegocioException("A disciplina deve ser informada");
        }

        // RN02 : Disciplina deve ter carga horaria
        if (disciplina.getCargaHoraria() <= 0) {
            throw new NegocioException("A disciplina deve ter carga horaria");
        }

        // RN03 : Disciplina deve ter Nome
        if (disciplina.getNome() == null) {
            throw new NegocioException("A disciplina deve ter nome");
        }

        // RN04 : Disciplina deve ter Departamento
        if (disciplina.getDepartamento() == null) {
            throw new NegocioException("A disciplina deve estar relacionada a um departamento");
        }

        // RN05 : Disciplina deve ter uma Ementa
        if (disciplina.getEmenta() == null) {
            throw new NegocioException("A disciplina deve ter uma ementa");
        }
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.atualizar(disciplina);
    }

    @Override
    public Disciplina buscarPorId(Integer id) throws PersistenciaException, NegocioException {

        IDisciplinaDAO dsiciplinaDAO = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        disciplina = dsiciplinaDAO.consultarPorId(id);
        return disciplina;
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {

        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.excluir(id);
    }

    @Override
    public List<Disciplina> listarTodos() throws PersistenciaException, NegocioException {

        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        List<Disciplina> listDisciplina = disciplinaDAO.listarTodos();
        return listDisciplina;

    }
}
