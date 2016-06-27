package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IMatriculaDAO;
import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.dao.impl.MatriculaDAO;
import br.cefetmg.inf.model.dao.impl.TurmaDAO;
import br.cefetmg.inf.model.domain.Matricula;
import br.cefetmg.inf.model.service.IManterMatricula;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/*
RN009: Não pode se matricular mais alunos que o limite de vagas por turma.

RN EXTRA 3: Não se deve matricular turmas que o limite de alunos seja 0.

- Matricula
RN008: Aluno não pode se matricular mais de uma vez na mesma turma.
RN010: Data da matrícula não pode ser posterior à data de início da turma.
RN006: Um aluno não pode se matricular em um curso no qual já tenha se matriculado anteriormente.
 */
public class ManterMatricula implements IManterMatricula {

    @Override
    public void cadastrar(Matricula mat) throws PersistenciaException, NegocioException {
        Confere(mat);
        
        
        
        // Pega o número de alunos na turma...
        List<Matricula> mats = this.listarTodos();
        
        // Número de Matrículas nessa Turma.
        int matsTurma = 0;
        
        
        // Percorre todas as Matrículas, buscando as matrículas existentes para essa turma.
        for(int i = 0 ; i < mats.size() ; i++ ) {
            
            //Incrementa o numero de Matrículas para essa turma, se a ID da turma dessa matrícula for igual a ID da turma da matrícula que se deseja registrar.
            if( mats.get(i).getTurma().getId().equals(mat.getTurma().getId())) {  
                matsTurma++;
            }
            
            //Confere se o Aluno a ser cadastrado já existe no registro
            if(mats.get(i).getAluno().getCpf().equals(mat.getAluno().getCpf())) {
                throw new NegocioException("O aluno já existe");
            }

            //Confere se o Aluno a ser cadastrado já existe no registro
            if(mats.get(i).getAluno().getNome().equals(mat.getAluno().getNome())) {
                throw new NegocioException("O aluno já existe");
            }
            
            
            //Confere se o Aluno a ser cadastrado já existe no registro
            if(mats.get(i).getAluno().getId().equals(mat.getAluno().getNome())) {
                throw new NegocioException("O aluno já existe");
            }
            
        }
        
        if(mat.getTurma().getVagasLimite() == matsTurma ) {
            throw new NegocioException("Numero máximo de matrículas atingido para esta turma.");
        }
              
        // RN010: Data da matrícula não pode ser posterior à data de início da turma.
        if (mat.getDataInscricao().after(mat.getTurma().getInicio())) {
            throw new NegocioException("Inscrições fechadas para esta turma.");
        }
        
        IMatriculaDAO matDAO = new MatriculaDAO();
        matDAO.inserir(mat);
    }

    @Override
    public void alterar(Matricula mat) throws PersistenciaException, NegocioException {
        Confere(mat);

        // Pega o número de alunos na turma...
        List<Matricula> mats = this.listarTodos();
        
        // Número de Matrículas nessa Turma.
        int matsTurma = 0, 
            mesmoAluno = 0;
        
        // Percorre todas as Matrículas, buscando as matrículas existentes para essa turma.
        for(int i = 0 ; i < mats.size() ; i++ ) {
            
            //Incrementa o numero de Matrículas para essa turma, se a ID da turma dessa matrícula for igual a ID da turma da matrícula que se deseja registrar.
            if( mats.get(i).getTurma().getId().equals(mat.getTurma().getId())) {  
                matsTurma++;
            }
            //Confere se o Aluno a ser cadastrado já existe no registro
            if(mats.get(i).getAluno().getNome().equals(mat.getAluno().getNome())) {
                mesmoAluno++;
            }
            
        }
        
        if(mesmoAluno > 2) {
            throw new NegocioException("O aluno já existe");
        }
        
        
        if(mat.getTurma().getVagasLimite() == matsTurma ) {
            throw new NegocioException("Numero máximo de matrículas atingido para esta turma.");
        }
        
        IMatriculaDAO matDAO = new MatriculaDAO();
        matDAO.atualizar(mat);
    }

    @Override
    public List<Matricula> listarTodos() throws PersistenciaException, NegocioException {
        IMatriculaDAO matDAO = new MatriculaDAO();
        return matDAO.listarTodos(); 
    }

    @Override
    public Matricula buscarPorId(Long id) throws PersistenciaException, NegocioException {
        //Não existe id negativa...
        if(id < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }
        
        IMatriculaDAO matDAO = new MatriculaDAO();
        return matDAO.consultarPorId(id);
    }

    @Override
    public void excluir(Matricula mat) throws PersistenciaException, NegocioException {
        Confere(mat);

        if(mat.getId() == null) {
            throw new NegocioException("Informe a Id");
        }
        
        //Não existe id negativa...
        if(mat.getId() < 0) {
            throw new NegocioException("Id's não podem ser negativas...");
        }
        
        IMatriculaDAO matDAO = new MatriculaDAO();
        matDAO.excluir(mat.getId());
    }

    private void Confere(Matricula mat) throws NegocioException {
        if (mat == null) {
            throw new NegocioException("Os dados da matrícula não foram fornecidos.");
        }

        if (mat.getTurma() == null) {
            throw new NegocioException("Os dados da turma que se deseja matricular não foram fornecidos.");
        }

        if (mat.getAluno() == null) {
            throw new NegocioException("Os dados do aluno não foram fornecidos.");
        }

        if (mat.getDataInscricao() == null) {
            throw new NegocioException("Os dados do aluno não foram fornecidos.");
        }
    }

}
