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
public class ManterProfessorDisciplina implements IManterProfessorDisciplina{

    @Override
    public Integer cadastrar(ProfessorDisciplina professorDisciplina) throws PersistenciaException, NegocioException {
        IProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
        Integer id = professorDisciplinaDAO.inserir(professorDisciplina);
        
        return id;
    }

    @Override
    public boolean alterar(ProfessorDisciplina professorDisciplina) throws PersistenciaException, NegocioException {
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
