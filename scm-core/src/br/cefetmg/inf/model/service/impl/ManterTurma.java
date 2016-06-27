package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.impl.TurmaDAO;
import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.model.service.IManterTurma;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterTurma implements IManterTurma {

    @Override
    public void cadastrar(Turma turma) throws PersistenciaException, NegocioException {
        Confere(turma);

        ITurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.inserir(turma);
    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException, NegocioException {
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.listarTodos();
    }

    @Override
    public void alterar(Turma turma) throws PersistenciaException, NegocioException {
        Confere(turma);

        ITurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.atualizar(turma);
    }

    @Override
    public Turma buscarPorId(Long id) throws PersistenciaException, NegocioException {
        //Não existe id negativa...
        if(id < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }
        
        ITurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.consultarPorId(id);
    }

    @Override
    public void excluir(Turma turma) throws PersistenciaException, NegocioException {
        Confere(turma);
        
        if(turma.getId() == 0) {
            throw new NegocioException("A id não foi iunformada.");
        }
        
        //Não existe id negativa...
        if(turma.getId() < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }
        
        ITurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.excluir(turma.getId());
    }

    private void Confere(Turma turma) throws NegocioException {
        // RN EXTRA 2: A turma deve existir...
        if (turma == null) {
            throw new NegocioException("Os dados da turma devem ser informados.");
        }

        // RN EXTRA 1: Toda Turma deve pertencer a um Curso.
        if (turma.getCurso() == null || turma.getCurso().getId() == null) {
            throw new NegocioException("O curso ao qual a turma está ligada deve ser informado.");
        }


        //RN EXTRA 3: Não se deve matricular turmas que o limite de alunos seja 0.
        if (turma.getVagasLimite() <= 0) {
            throw new NegocioException("O numero de vagas deve ser maior que 0.");
        }
    }

}
