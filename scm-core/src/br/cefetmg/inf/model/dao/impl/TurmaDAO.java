package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO implements ITurmaDAO {

    @Override
    public Long inserir(Turma turma) throws PersistenciaException {
        
        Long id = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Comando sql a ser executado.
            String sql = "INSERT INTO turma (curso_id, vagaslimite, inicio, termino) " + "VALUES(?, ?, ?, ?) RETURNING id";
            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql); // por culpa das interrogções;
                                                                            // assim se evita a injeção de SQL                        
            statement.setLong(1, turma.getCurso().getId());                 // 1ª  interrogação
            statement.setInt(2, turma.getVagasLimite());                    // 2ª  ||
            statement.setDate(3, turma.getInicio());                        // 3ª  ||
            statement.setDate(4, turma.getTermino());                       // 4ª  ||

            // Executa a query.
            ResultSet resultSet = statement.executeQuery();                 

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id"));
                turma.setId(id);
            }
            
            // Fecha a conexao com o BD.
            connection.close();
        
        } catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Turma turma) throws PersistenciaException {

        try  {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "UPDATE turma " +
                            " SET vagaslimite = ?, " +    
                            " inicio = ?," +
                            " termino = ?," +
                            " curso_id = ?" +
                            " WHERE id = ?";

            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement atualiza = connection.prepareStatement(sql);

            atualiza.setInt(1, turma.getVagasLimite());
            atualiza.setDate(2, turma.getInicio());
            atualiza.setDate(3, turma.getTermino());
            atualiza.setLong(4, turma.getCurso().getId());
            atualiza.setLong(5, turma.getId());

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
            String sql = "DELETE FROM turma WHERE id = ?";  
            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement exclui = connection.prepareStatement(sql);

            exclui.setLong(1, id); 
            
            // Executa a query.
            exclui.execute();
            
            // Fecha a conexao com o BD.
            connection.close();
        
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException {

        List<Turma> turmaList = new ArrayList<> ();

        try {
            // Abre a única conexão possível com o Banco de Dados.            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM turma";
                
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executa a query.
            ResultSet lista = statement.executeQuery();

            // Percorre toda a 'lista'
            while(lista.next()) {
                    Turma turma = new Turma();
                    turma.setId(lista.getLong("id"));
                    turma.setVagasLimite(lista.getInt("vagasLimite"));
                    turma.setInicio(lista.getDate("inicio"));
                    turma.setTermino(lista.getDate("termino"));

                    // Pega-se não somente a ID, mas sim todo o Curso.
                    try { 
                        ICursoDAO cursoDAO = new CursoDAO();
                        turma.setCurso(cursoDAO.consultarPorId(lista.getLong("curso_id")));
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new PersistenciaException(e.getMessage(), e);
                    }
                    
                    turmaList.add(turma);
            }
            
            // Fecha a conexao com o BD.
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return turmaList;
    }

    @Override
    public Turma consultarPorId(Long id) throws PersistenciaException {

        Turma turma = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM turma WHERE id = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            // Executa a query.
            ResultSet registro = statement.executeQuery();

            if(registro.next()) {
                    turma = new Turma();
                    turma.setId(registro.getLong("id"));
                    turma.setVagasLimite(registro.getInt("vagasLimite"));
                    turma.setInicio(registro.getDate("inicio"));
                    turma.setTermino(registro.getDate("termino"));
                    
                    // Pega-se não somente a ID, mas sim todo o Curso.
                    try { 
                        ICursoDAO cursoDAO = new CursoDAO();
                        turma.setCurso(cursoDAO.consultarPorId(registro.getLong("curso_id")));
                        
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
        return turma;
    }

}
