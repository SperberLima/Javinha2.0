/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.dao.IGradeCurricularDAO;
import br.cefetmg.inf.model.dao.impl.CursoDAO;
import br.cefetmg.inf.model.dao.impl.GradeCurricularDAO;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterCurso implements IManterCurso {

    @Override
    public Integer cadastrar(Curso curso) throws PersistenciaException, NegocioException {

        // RN01 : Curso deve ter departamento
        if (curso == null) {
            throw new NegocioException("O curso deve ser informado");
        }

        // RN02 : Curso deve ter departamento
        if (curso.getDpto() == null) {
            throw new NegocioException("O curso deve pertencer a um departamento");
        }

        // RN03 : Curso deve ter Nome
        if (curso.getNome() == null) {
            throw new NegocioException("O curso deve ter nome");
        }

        // RN04 : Curso deve ter sigla
        if (curso.getSigla() == null) {
            throw new NegocioException("O curso deve ter sigla");
        }

        // RN05 : Curso deve ter tipo
        if (curso.getTipo() == null) {
            throw new NegocioException("O curso deve ter tipo");
        }

        ICursoDAO cursoDAO = new CursoDAO();
        Integer id = cursoDAO.inserir(curso);
        curso.setId(id);

        return id;
    }

    @Override
    public boolean alterar(Curso curso) throws PersistenciaException, NegocioException {
        // RN01 : Curso deve ter departamento
        if (curso == null) {
            throw new NegocioException("O curso deve ser informado");
        }

        // RN01 : Curso deve ter departamento
        if (curso.getId() == null) {
            throw new NegocioException("O curso deve ser informado");
        }

        // RN02 : Curso deve ter departamento
        if (curso.getDpto() == null) {
            throw new NegocioException("O curso deve pertencer a um departamento");
        }

        // RN03 : Curso deve ter Nome
        if (curso.getNome() == null) {
            throw new NegocioException("O curso deve ter nome");
        }

        // RN04 : Curso deve ter sigla
        if (curso.getSigla() == null) {
            throw new NegocioException("O curso deve ter sigla");
        }

        // RN05 : Curso deve ter tipo
        if (curso.getTipo() == null) {
            throw new NegocioException("O curso deve ter tipo");
        }

        ICursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.atualizar(curso);
    }

    @Override
    public Curso buscarPorId(Integer id) throws PersistenciaException, NegocioException {

        ICursoDAO cursoDAO = new CursoDAO();
        Curso curso = cursoDAO.consultarPorId(id);
        return curso;

    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        ICursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.excluir(id);
    }

    @Override
    public List<Curso> listarTodos() throws PersistenciaException, NegocioException {
        ICursoDAO cursoDAO = new CursoDAO();
        List<Curso> listCurso = cursoDAO.listarTodos();
        return listCurso;
    }

    public List<GradeCurricular> listarGrades(Curso curso) throws PersistenciaException, NegocioException {
        // RN01 : Curso deve ter departamento
        if (curso == null) {
            throw new NegocioException("O curso deve ser informado");
        }

        // RN01 : Curso deve ter departamento
        if (curso.getId() == null) {
            throw new NegocioException("O curso deve ser informado");
        }

        // RN02 : Curso deve ter departamento
        if (curso.getDpto() == null) {
            throw new NegocioException("O curso deve pertencer a um departamento");
        }

        // RN03 : Curso deve ter Nome
        if (curso.getNome() == null) {
            throw new NegocioException("O curso deve ter nome");
        }

        // RN04 : Curso deve ter sigla
        if (curso.getSigla() == null) {
            throw new NegocioException("O curso deve ter sigla");
        }

        // RN05 : Curso deve ter tipo
        if (curso.getTipo() == null) {
            throw new NegocioException("O curso deve ter tipo");
        }

        IGradeCurricularDAO gradeDAO = new GradeCurricularDAO();
        List<GradeCurricular> listGrade = gradeDAO.listarPorCurso(curso.getId());
        return listGrade;
    }
}
