package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUnidadeEnsinoDAO;
import br.cefetmg.inf.model.domain.UnidadeEnsino;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeEnsinoDAO implements IUnidadeEnsinoDAO {

    @Override
    public Integer inserir(UnidadeEnsino unidadeEnsino) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_unidade_de_ensino) as id FROM \"Unidade de Ensino\"");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                unidadeEnsino.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO \"Unidade de Ensino\" (id_unidade_de_ensino, cod_sigla, txt_nome, txt_email, nro_telefone, cod_cep, txt_site ) " + "VALUES ( ?, ?, ?, ?, ?, ?, ? ) RETURNING id_unidade_de_ensino";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, unidadeEnsino.getId());
            statement.setString(2, unidadeEnsino.getSigla());
            statement.setString(3, unidadeEnsino.getNome());
            statement.setString(4, unidadeEnsino.getEmail());
            statement.setString(5, unidadeEnsino.getTelefone());
            statement.setString(6, unidadeEnsino.getCEP());
            statement.setString(7, unidadeEnsino.getSite());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_unidade_de_ensino");
            }else{
                id = null;
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(UnidadeEnsino unidadeEnsino) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE \"Unidade de Ensino\" "
                    + " SET "
                    + "cod_sigla = ?, "
                    + "txt_nome = ?, "
                    + "txt_email = ?, "
                    + "nro_telefone = ?, "
                    + "cod_cep = ?, "
                    + "txt_site = ?"
                    + " WHERE id_unidade_de_ensino = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            
            statement.setString(1, unidadeEnsino.getSigla());
            statement.setString(2, unidadeEnsino.getNome());
            statement.setString(3, unidadeEnsino.getEmail());
            statement.setString(4, unidadeEnsino.getTelefone());
            statement.setString(5, unidadeEnsino.getCEP());
            statement.setString(6, unidadeEnsino.getSite());
            statement.setInt(7, unidadeEnsino.getId());
            
            
            statement.execute();

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM \"Unidade de Ensino\" WHERE id_unidade_ensino = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public UnidadeEnsino consultarPorId(Integer id) throws PersistenciaException {
        UnidadeEnsino unidadeEnsino = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Unidade de Ensino\" WHERE id_unidade_de_ensino = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                unidadeEnsino = new UnidadeEnsino();
                unidadeEnsino.setId(resultSet.getInt("id_unidade_de_ensino"));
                unidadeEnsino.setCEP(resultSet.getString("cod_cep"));
                unidadeEnsino.setEmail(resultSet.getString("txt_email"));
                unidadeEnsino.setNome(resultSet.getString("txt_nome"));
                unidadeEnsino.setSigla(resultSet.getString("cod_sigla"));
                unidadeEnsino.setSite(resultSet.getString("txt_site"));
                unidadeEnsino.setTelefone(resultSet.getString("nro_telefone"));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return unidadeEnsino;
    }

    @Override
    public List<UnidadeEnsino> listarTodos() throws PersistenciaException {
        ArrayList<UnidadeEnsino> unidadesEnsino = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Unidade de Ensino\"";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UnidadeEnsino unidadeEnsino = new UnidadeEnsino();
                unidadeEnsino.setId(resultSet.getInt("id_unidade_de_ensino"));
                unidadeEnsino.setCEP(resultSet.getString("cod_cep"));
                unidadeEnsino.setEmail(resultSet.getString("txt_email"));
                unidadeEnsino.setNome(resultSet.getString("txt_nome"));
                unidadeEnsino.setSigla(resultSet.getString("cod_sigla"));
                unidadeEnsino.setSite(resultSet.getString("txt_site"));
                unidadeEnsino.setTelefone(resultSet.getString("nro_telefone"));
                
                unidadesEnsino.add(unidadeEnsino);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return unidadesEnsino;
    }
    
}
