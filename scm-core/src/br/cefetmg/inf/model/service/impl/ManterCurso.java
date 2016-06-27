package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.dao.impl.CursoDAO;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.service.IManterCurso;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterCurso implements IManterCurso {

    @Override
    public void cadastrar(Curso curso) throws PersistenciaException, NegocioException {
        Confere(curso);

        ICursoDAO cursoDAO = new CursoDAO();
        cursoDAO.inserir(curso);
    }

    @Override
    public void alterar(Curso curso) throws PersistenciaException, NegocioException {
        Confere(curso);

        ICursoDAO cursoDAO = new CursoDAO();
        cursoDAO.atualizar(curso);
    }

    @Override
    public List<Curso> listarTodos() throws PersistenciaException, NegocioException {
        ICursoDAO cursoDAO = new CursoDAO();
        List<Curso> listCurso = cursoDAO.listarTodos();
        return listCurso;
    }

    @Override
    public Curso buscarPorId(Long id) throws PersistenciaException, NegocioException {
        
        //Não existe id negativa...
        if(id < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }
        
        ICursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.consultarPorId(id);
    
    }
    
    public Curso buscarPorNome(String nome) throws PersistenciaException, NegocioException {
        
        if(nome == null) {
            throw new NegocioException("O Nome do Curso deve ser informado.");
        }
        
        ICursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.consultarPorNome(nome);
    
    }

    @Override
    public void excluir(Curso curso) throws PersistenciaException, NegocioException {
        Confere(curso);
        
        //Não existe id negativa...
        if(curso.getId() < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }
        
        ICursoDAO cursoDAO = new CursoDAO();
        cursoDAO.excluir(curso.getId());
    }

    private void Confere(Curso curso) throws NegocioException {
        //RN007: O nome do curso é obrigatório.
        if (curso == null) {
            throw new NegocioException("Dados do curso não foram informados");
        }

        //RN007: O nome do curso é obrigatório.
        if (curso.getNome() == null || curso.getNome().isEmpty()) {
            throw new NegocioException("O nome do curso não foi informado");
        }

        //O Curso não pode ter 0 ou menos horas. 
        if (curso.getCargaHoraria() <= 0) {
            throw new NegocioException("O nome do curso não foi informado");
        }
    }

}
