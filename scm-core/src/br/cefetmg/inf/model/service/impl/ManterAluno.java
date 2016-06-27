package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IAlunoDAO;
import br.cefetmg.inf.model.dao.impl.AlunoDAO;
import br.cefetmg.inf.model.domain.Aluno;
import br.cefetmg.inf.model.service.IManterAluno;
import br.cefetmg.inf.util.CPF;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterAluno implements IManterAluno {

    @Override
    public void cadastrar(Aluno aluno) throws PersistenciaException, NegocioException {
        Confere(aluno);
        
        List<Aluno> alunos = this.listarTodos();

        // Percorre todas as Matrículas, buscando as matrículas existentes para essa turma.
        for (int i = 0; i < alunos.size(); i++) {

            //Confere se o Aluno a ser cadastrado já existe no registro
            if (alunos.get(i).getCpf().equals(aluno.getCpf())) {
                throw new NegocioException("O aluno já existe");
            }

            //Confere se o Aluno a ser cadastrado já existe no registro
            if (alunos.get(i).getNome().equals(aluno.getNome())) {
                throw new NegocioException("O aluno já existe");
            }
        }
        
        IAlunoDAO alunoDAO = new AlunoDAO();
        Long alunoId = alunoDAO.inserir(aluno);
        aluno.setId(alunoId);
    }

    @Override
    public List<Aluno> listarTodos() throws PersistenciaException, NegocioException {
        IAlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> listAluno = alunoDAO.listarTodos();
        return listAluno;
    }

    @Override
    public void alterar(Aluno aluno) throws PersistenciaException, NegocioException {
        Confere(aluno);

        List<Aluno> alunos = this.listarTodos();

        // Percorre todas as Matrículas, buscando as matrículas existentes para essa turma.
        for (int i = 0; i < alunos.size(); i++) {

            //Confere se o Aluno a ser cadastrado já existe no registro
            if (alunos.get(i).getCpf().equals(aluno.getCpf())) {
                throw new NegocioException("O aluno já existe");
            }

            //Confere se o Aluno a ser cadastrado já existe no registro
            if (alunos.get(i).getNome().equals(aluno.getNome())) {
                throw new NegocioException("O aluno já existe");
            }
        }
        
        IAlunoDAO aluno2 = new AlunoDAO();
        aluno2.atualizar(aluno);
    }

    @Override
    public void excluir(Aluno aluno) throws PersistenciaException, NegocioException {
        Confere(aluno);

        //Não existe id negativa...
        if (aluno.getId() < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }

        IAlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.excluir(aluno.getId());
    }

    @Override
    public Aluno buscarPorId(Long id) throws PersistenciaException, NegocioException {
        //Não existe id negativa...
        if (id < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }

        IAlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.consultarPorId(id);
    } 
    
    public Aluno buscarPorNome(String nome) throws PersistenciaException, NegocioException {
        if (nome == null) {
            throw new NegocioException("Nome do aluno deve ser informado.");
        }
        //RN002
        if (nome.split(" ").length < 2) {
            throw new NegocioException("Nome do aluno deve ser informado.");
        }

        IAlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.consultarPorNome(nome);
    }
    
    
    

    private void Confere(Aluno aluno) throws NegocioException {
        //RN001
        if (aluno == null) {
            throw new NegocioException("Dados do aluno não foram informados.");
        }

        //RN001
        if (aluno.getNome() == null) {
            throw new NegocioException("Nome do aluno deve ser informado.");
        }
        //RN002
        if (aluno.getNome().split(" ").length < 2) {
            throw new NegocioException("Nome do aluno deve ser informado.");
        }

        //RN003
        if (aluno.getCpf() == null) {
            throw new NegocioException("Nome do aluno deve ser informado.");
        }
        //RN003
        if (!CPF.ehValido(aluno.getCpf())) {
            throw new NegocioException("RN003: Número do CPF não é válido.");
        }

        //RN004
        if ((aluno.getEndereco() == null) || aluno.getEndereco().isEmpty()) {
            throw new NegocioException("Endereço do aluno deve ser informado.");
        }
    }

}
