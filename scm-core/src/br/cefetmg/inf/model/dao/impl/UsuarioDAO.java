/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUsuarioDAO;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO{
   
    @Override
    public Integer inserir(Usuario usuario) throws PersistenciaException {
        Integer ok=0;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
                    
            
            String sql = "INSERT INTO \"Usuario\" (txt_nome, txt_nome) " + "VALUES ( ?, ? )";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                          
            statement.setString(1, usuario.getNome());      
            statement.setString(2, usuario.getSenha());                                                                    
            ResultSet resultSet = statement.executeQuery();
            
            ok = 1;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return ok;
    }

    @Override
    public boolean atualizar(Usuario usuario) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE \"Usuario\" "
                    + " SET  "
                    + "txt_nome = ?, "
                    + "txt_senha = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            
            statement.setString(1, usuario.getNome());              
            statement.setString(2, usuario.getSenha());
            
            if(statement.executeUpdate() != 0)
                sucesso = true;

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    
    public boolean excluir(String nome) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM \"Usuario\" WHERE txt_nome = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nome);

            if(statement.executeUpdate()!= 0)
                sucesso = true;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

   
    public Usuario consultarPorId(String id) throws PersistenciaException {
        Usuario usuario = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Usuario\" WHERE txt_nome = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                CurriculoOfertaDAO curriculoOfertaDAO = new CurriculoOfertaDAO();
                usuario = new Usuario();
                usuario.setNome(resultSet.getString("txt_nome"));
                usuario.setSenha(resultSet.getString("txt_senha"));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() throws PersistenciaException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Usuario\"";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CurriculoOfertaDAO curriculoOfertaDAO = new CurriculoOfertaDAO();
                Usuario usuario = new Usuario();
                usuario.setNome(resultSet.getString("txt_nome"));
                usuario.setSenha(resultSet.getString("txt_senha"));
                
                usuarios.add(usuario);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return usuarios;
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarPorId(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
