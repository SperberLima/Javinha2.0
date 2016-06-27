package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAlunoDAO;
import br.cefetmg.inf.model.dao.IMatriculaDAO;
import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.domain.Matricula;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO implements IMatriculaDAO {

    @Override
    public Long inserir(Matricula mat) throws PersistenciaException {
        Long id = null;
        
        try { 
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String sql = "INSERT INTO matricula "
                    + "(turma_id, "
                    + "aluno_id, "
                    + "datainscricao, "
                    + "notafinal) " + "VALUES (?, ?, ?, ?) RETURNING id;";
            
            PreparedStatement inclui = connection.prepareStatement(sql);
            
            inclui.setLong(1, mat.getTurma().getId());
            inclui.setLong(2, mat.getAluno().getId());
            inclui.setDate(3, mat.getDataInscricao());
            inclui.setDouble(4, mat.getNotaFinal());
            
            ResultSet result = inclui.executeQuery();
            
            if(result.next()) {
                id = result.getLong("id");
                mat.setId(id);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return id;
    }

    @Override
    public void atualizar(Matricula mat) throws PersistenciaException {
        try  {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "UPDATE matricula " +
                            " SET datainscricao = ?, " +
                            " turma_id = ?," +
                            " aluno_id = ?," +
                            " notafinal = ?" +
                            " WHERE id = ?";

            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement atualiza = connection.prepareStatement(sql);

            atualiza.setDate(1, mat.getDataInscricao());
            atualiza.setLong(2, mat.getTurma().getId());
            atualiza.setLong(3, mat.getAluno().getId());
            atualiza.setDouble(4, mat.getNotaFinal());
            atualiza.setLong(5, mat.getId());

            // Executa a query.
            atualiza.execute();

            // Fecha a conexao com o BD.
            connection.close();
        
        } catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "DELETE FROM matricula WHERE id = ?";  
            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement exclui = connection.prepareStatement(sql);

            exclui.setLong(1, id); 
            
            // Executa a query.
            exclui.execute();
            
            // Fecha a conexao com o BD.
            connection.close();
        
        } catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Matricula consultarPorId(Long id) throws PersistenciaException {
        
        Matricula mat = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM matricula WHERE id = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            // Executa a query.
            ResultSet registro = statement.executeQuery();

            if(registro.next()) {
                    mat = new Matricula();
                    mat.setId(registro.getLong("id"));
                    mat.setDataInscricao(registro.getDate("datainscricao"));
                    mat.setNotaFinal(registro.getDouble("notafinal"));
            
                    // Pega-se não somente a ID da Turma, mas sim toda a Turma.
                    try { 
                        ITurmaDAO turmaDAO = new TurmaDAO();
                        mat.setTurma(turmaDAO.consultarPorId(registro.getLong("turma_id")));
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new PersistenciaException(e.getMessage(), e);
                    }
                    // Pega-se não somente a ID da Aluno, mas sim todo o Aluno.
                    try { 
                        IAlunoDAO alunoDAO = new AlunoDAO();
                        mat.setAluno(alunoDAO.consultarPorId(registro.getLong("aluno_id")) );
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new PersistenciaException(e.getMessage(), e);
                    }
            }
            
            // Fecha a conexao com o BD.
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return mat;
    }

    @Override
    public List<Matricula> listarTodos() throws PersistenciaException {
        
        List<Matricula> matList = new ArrayList<> ();

        try {
            // Abre a única conexão possível com o Banco de Dados.            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM matricula";
                
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executa a query.
            ResultSet lista = statement.executeQuery();

            // Percorre toda a 'lista'
            while(lista.next()) {
                    Matricula mat = new Matricula();
                    mat.setId(lista.getLong("id"));
                    mat.setDataInscricao(lista.getDate("datainscricao"));
                    mat.setNotaFinal(lista.getDouble("notafinal"));

                    // Pega-se não somente a ID, mas sim toda a Turma.
                    try { 
                        ITurmaDAO turmaDAO = new TurmaDAO();
                        mat.setTurma(turmaDAO.consultarPorId(lista.getLong("turma_id")));
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new PersistenciaException(e.getMessage(), e);
                    }
                    try { 
                        IAlunoDAO alunoDAO = new AlunoDAO();
                        mat.setAluno(alunoDAO.consultarPorId(lista.getLong("aluno_id")));
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new PersistenciaException(e.getMessage(), e);
                    }
                    
                    matList.add(mat);
            }
            
            // Fecha a conexao com o BD.
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return matList;
        
    }

    
}
