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
public class ManterGradeCurricular implements IManterGradeCurricular{
    
    @Override
    public void cadastrar(GradeCurricular GradeCurricular) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (GradeCurricular.getCurso()== null){
            throw new NegocioException("Toda grade deve estar associada a um curso");
        }
        
        //Curso deve ter Nome
        if (GradeCurricular.getDescricao()== null){
            throw new NegocioException("Toda grade precissa de uma descricao");
        }
        
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        Integer id = GradeCurricularDAO.inserir(GradeCurricular);
        GradeCurricular.setId(id);
    }

    @Override
    public void alterar(GradeCurricular GradeCurricular) throws PersistenciaException, NegocioException {
         // Curso deve ter departamento
        if (GradeCurricular.getCurso()== null){
            throw new NegocioException("Toda grade deve estar associada a um curso");
        }
        
        //Curso deve ter Nome
        if (GradeCurricular.getDescricao()== null){
            throw new NegocioException("Toda grade necessita de uma descricao");
        }
        
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        GradeCurricularDAO.atualizar(GradeCurricular);
    }

    @Override
    public GradeCurricular buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        GradeCurricular GradeCurricular = GradeCurricularDAO.consultarPorId(id);
        return GradeCurricular;
        
    }

    @Override
    public void excluir(GradeCurricular GradeCurricular) throws PersistenciaException, NegocioException {
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        GradeCurricularDAO.excluir(GradeCurricular.getId());
    }

    @Override
    public List<GradeCurricular> listarTodos() throws PersistenciaException, NegocioException {
        IGradeCurricularDAO GradeCurricularDAO = new GradeCurricularDAO();
        List<GradeCurricular> listGrade = GradeCurricularDAO.listarTodos();
        return listGrade;
    }
    
    public List<Disciplina> listarDisciplinas(GradeCurricular gradeCurricular) throws PersistenciaException, NegocioException {
        IGradeCurricularDAO gradeDAO = new GradeCurricularDAO();
        List<Disciplina> listDisciplina = gradeDAO.listarDisciplinas(gradeCurricular);
        return listDisciplina;
    }
    
}
