package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ICursoDAO {
    
    @Override
    public Long inserir(Curso curso) throws PersistenciaException {
        
        Long id = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "INSERT INTO curso (nome, cargaHoraria) " + "VALUES(?, ?) RETURNING id";
            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql); // por culpa das interrogções;
                                                                            // assim se evita a injeção de SQL                        
            statement.setString(1, curso.getNome());                        // 1ª  interrogação
            statement.setInt(2, curso.getCargaHoraria());                   // 2ª  ||

            // Executa a query.
            ResultSet resultSet = statement.executeQuery();                 

            if (resultSet.next()) {
                id = new Long(resultSet.getLong("id"));
                curso.setId(id);
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
    public void atualizar(Curso curso) throws PersistenciaException {

        try  {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "UPDATE curso " +
                            " SET nome = ?, " +
                            " cargahoraria = ?" +
                            " WHERE id = ?";

            
            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement atualiza = connection.prepareStatement(sql);

            atualiza.setString(1, curso.getNome());
            atualiza.setInt(2, curso.getCargaHoraria());
            atualiza.setLong(3, curso.getId());

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
            String sql = "DELETE FROM curso WHERE id = ?";  
            
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
    public List<Curso> listarTodos() throws PersistenciaException {

        List<Curso> cursoList = new ArrayList<> ();

        try {
            // Abre a única conexão possível com o Banco de Dados.            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM curso";
                
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executa a query.
            ResultSet lista = statement.executeQuery();

            // Percorre toda a 'lista'
            while(lista.next()) {
                    Curso curso = new Curso();
                    curso.setId(lista.getLong("id"));
                    curso.setNome(lista.getString("nome"));
                    curso.setCargaHoraria(lista.getInt("cargaHoraria"));

                    cursoList.add(curso);
            }
            
            // Fecha a conexao com o BD.
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return cursoList;
    }

    @Override
    public Curso consultarPorId(Long id) throws PersistenciaException {

        Curso curso = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM curso WHERE id = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            // Executa a query.
            ResultSet registro = statement.executeQuery();

            if(registro.next()) {
                    curso = new Curso();
                    curso.setId(registro.getLong("id"));
                    curso.setNome(registro.getString("nome"));
                    curso.setCargaHoraria(registro.getInt("cargaHoraria"));
            }
            // Fecha a conexao com o BD.
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curso;
    }

    @Override
    public Curso consultarPorNome(String nome) throws PersistenciaException {

        Curso curso = null;
        
        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Comando sql a ser executado.
            String sql = "SELECT * FROM curso WHERE nome = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, nome);

            // Executa a query.
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                    curso = new Curso();
                    curso.setId(resultSet.getLong("id"));
                    curso.setNome(resultSet.getString("nome"));
                    curso.setCargaHoraria(resultSet.getInt("cargaHoraria"));
            }
            // Fecha a conexao com o BD.
            connection.close();

        } catch (Exception e) {
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return curso;
    }

}
