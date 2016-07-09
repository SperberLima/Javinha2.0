/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IProfessorDAO;
import br.cefetmg.inf.model.dao.impl.ProfessorDAO;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.model.service.IManterProfessor;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterProfessor implements IManterProfessor{

    @Override
    public void cadastrar(Professor professor) throws PersistenciaException, NegocioException {
        // Professor deve ter Telefone
        if (professor.getTelefone() == null){
            throw new NegocioException("O professor deve ter telefone");
        }
        
        //Professor deve ter Nome
        if (professor.getNome() == null){
            throw new NegocioException("O professor deve ter nome");
        }
        
        //Professor deve ter Departamento
        if (professor.getDpto() == null){
            throw new NegocioException("O professor deve ter departamento");
        }
        
        //Professor deve ter CPF
        if (professor.getCPF()== null){
            throw new NegocioException("O professor deve ter CPF");
        }
        
        IProfessorDAO professorDAO = new ProfessorDAO();
        Long id = professorDAO.inserir(professor);
        professor.setId(id);
    }

    @Override
    public void alterar(Professor professor) throws PersistenciaException, NegocioException {
        // Professor deve ter Telefone
        if (professor.getTelefone() == null){
            throw new NegocioException("O professor deve ter telefone");
        }
        
        //Professor deve ter Nome
        if (professor.getNome() == null){
            throw new NegocioException("O professor deve ter nome");
        }
        
        //Professor deve ter Departamento
        if (professor.getDpto() == null){
            throw new NegocioException("O professor deve ter departamento");
        }
        
        //Professor deve ter CPF
        if (professor.getCPF()== null){
            throw new NegocioException("O professor deve ter CPF");
        }
        
        IProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.atualizar(professor);
    }

    @Override
    public Professor buscarPorId(Long id) throws PersistenciaException, NegocioException {
        
        IProfessorDAO professorDAO = new ProfessorDAO();
        Professor professor = new Professor();
        professorDAO.consultarPorId(id);
        return professor;
    }

    @Override
    public void excluir(Professor professor) throws PersistenciaException, NegocioException {
        
        IProfessorDAO professorDAO = new ProfessorDAO();
        Long id = professor.getId();
        professorDAO.excluir(id);
    }

    @Override
    public List<Professor> listarTodos() throws PersistenciaException, NegocioException {
        
        IProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> listProfessor = professorDAO.listarTodos();
        return listProfessor;
    }
    
}
