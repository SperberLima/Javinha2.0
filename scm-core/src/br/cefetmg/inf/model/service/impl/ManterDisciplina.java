/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IDisciplinaDAO;
import br.cefetmg.inf.model.dao.impl.DisciplinaDAO;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.service.IManterDisciplina;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterDisciplina implements IManterDisciplina{

    @Override
    public void cadastrar(Disciplina disciplina) throws PersistenciaException, NegocioException {
        // Disciplina deve ter carga horaria
        if (disciplina.getCargaHoraria() == 0){
            throw new NegocioException("A disciplina deve ter carga horaria");
        }
        
        //Disciplina deve ter Nome
        if (disciplina.getNome() == null){
            throw new NegocioException("A disciplina deve ter nome");
        }
        
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Integer id = disciplinaDAO.inserir(disciplina);
        disciplina.setId(id);
    }

    @Override
    public void alterar(Disciplina disciplina) throws PersistenciaException, NegocioException {
        // Disciplina deve ter carga horaria
        if (disciplina.getCargaHoraria() == 0){
            throw new NegocioException("A disciplina deve ter carga horaria");
        }
        
        //Disciplina deve ter Nome
        if (disciplina.getNome() == null){
            throw new NegocioException("A disciplina deve ter nome");
        }
        
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.atualizar(disciplina);
    }

    @Override
    public Disciplina buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        
        IDisciplinaDAO dsiciplinaDAO = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        disciplina = dsiciplinaDAO.consultarPorId(id);
        return disciplina;
    }

    @Override
    public void excluir(Disciplina disciplina) throws PersistenciaException, NegocioException {
        
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Integer id = disciplina.getId();
        disciplinaDAO.excluir(id);
        
    }

    @Override
    public List<Disciplina> listarTodos() throws PersistenciaException, NegocioException {
        
        IDisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        List<Disciplina> listDisciplina = disciplinaDAO.listarTodos();
        return listDisciplina;
        
    }
    
}
