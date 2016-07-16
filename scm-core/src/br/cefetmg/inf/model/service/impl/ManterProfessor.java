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
public class ManterProfessor implements IManterProfessor {

    @Override
    public Integer cadastrar(Professor professor) throws PersistenciaException, NegocioException {
        // RN01 : Professor deve ser informado
        if (professor == null) {
            throw new NegocioException("O professor deve ser informado");
        }

        // RN02 : Professor deve ter Telefone
        if (professor.getTelefone() == null) {
            throw new NegocioException("O professor deve ter telefone");
        }

        // RN03 :  Professor deve ter Nome
        if (professor.getNome() == null) {
            throw new NegocioException("O professor deve ter nome");
        }

        // RN04 : Professor deve ter Departamento
        if (professor.getDpto() == null) {
            throw new NegocioException("O professor deve ter departamento");
        }

        // RN05 : Professor deve ter CPF
        if (professor.getCPF() == null) {
            throw new NegocioException("O professor deve ter CPF");
        }

        // RN06 : Professor deve ter uma descrição
        if (professor.getDescricao() == null) {
            throw new NegocioException("O professor deve ter uma Descrição");
        }

        IProfessorDAO professorDAO = new ProfessorDAO();
        Integer id = professorDAO.inserir(professor);
        professor.setId(id);

        return id;
    }

    @Override
    public boolean alterar(Professor professor) throws PersistenciaException, NegocioException {
        // RN01 : Professor deve ser informado
        if (professor == null) {
            throw new NegocioException("O professor deve ser informado");
        }

        // RN01 : Professor deve ser informado
        if (professor.getId() == null) {
            throw new NegocioException("O professor deve ser informado");
        }

        // RN02 : Professor deve ter Telefone
        if (professor.getTelefone() == null) {
            throw new NegocioException("O professor deve ter telefone");
        }

        // RN03 :  Professor deve ter Nome
        if (professor.getNome() == null) {
            throw new NegocioException("O professor deve ter nome");
        }

        // RN04 : Professor deve ter Departamento
        if (professor.getDpto() == null) {
            throw new NegocioException("O professor deve ter departamento");
        }

        // RN05 : Professor deve ter CPF
        if (professor.getCPF() == null) {
            throw new NegocioException("O professor deve ter CPF");
        }

        // RN06 : Professor deve ter uma descrição
        if (professor.getDescricao() == null) {
            throw new NegocioException("O professor deve ter uma Descrição");
        }

        IProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.atualizar(professor);
    }

    @Override
    public Professor buscarPorId(Integer id) throws PersistenciaException, NegocioException {

        IProfessorDAO professorDAO = new ProfessorDAO();
        Professor professor = new Professor();
        professorDAO.consultarPorId(id);
        return professor;
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        IProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.excluir(id);
    }

    @Override
    public List<Professor> listarTodos() throws PersistenciaException, NegocioException {

        IProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> listProfessor = professorDAO.listarTodos();
        return listProfessor;
    }

}
