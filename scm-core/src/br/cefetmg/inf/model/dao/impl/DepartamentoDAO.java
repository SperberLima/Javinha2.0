package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDepartamentoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentoDAO implements IDepartamentoDAO {

    @Override
    public Integer inserir(Departamento departamento) throws PersistenciaException {

        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(`id_departamento`) as id FROM Departamento ");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                if(id == null) id = 1;
                departamento.setId(id);
            }
            
            String sql = "INSERT INTO `Departamento` ( `id_departamento`, `txt_nome`, `cod_sigla`, `txt_email`, `nro_telefone`, `cod_cep`, `txt_site` ) " + "VALUES(?, ?, ?, ?, ?, ?, ? ) RETURNING id_departamento";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL 
            statement.setInt(1, departamento.getId());
            statement.setString(2, departamento.getNome());                        // 0  interrogação.
            statement.setString(3, departamento.getSigla());                        // 1  interrogação.
            statement.setString(4, departamento.getEmail());                        // 2  interrogação.
            statement.setString(5, departamento.getTelefone());                        // 3  interrogação.
            statement.setString(6, departamento.getCEP());                        // 4  interrogação.
            statement.setString(7, departamento.getSite());                        // 5  interrogação.
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_departamento");
                departamento.setId(id);
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Departamento departamento) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE `Departamento` "
                    + " SET  "
                    + "`txt_nome` = ?, "
                    + "`cod_sigla` = ?, "
                    + "`txt_email` = ?, "
                    + "`nro_telefone` = ?, "
                    + "`cod_cep` = ?, "
                    + "`txt_site` = ? "
                    + " WHERE id_departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, departamento.getNome());                        // 1  interrogação.
            statement.setString(2, departamento.getSigla());                        // 2  interrogação.
            statement.setString(3, departamento.getEmail());                        // 3  interrogação.
            statement.setString(4, departamento.getTelefone());                        // 4  interrogação.
            statement.setString(5, departamento.getCEP());                        // 5  interrogação.
            statement.setString(6, departamento.getSite());                        // 6  interrogação.

            statement.execute();

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Departamento consultarPorId(Integer id) throws PersistenciaException {
        Departamento dpto = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Departamento` WHERE id_departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultSet.getInt("id_departamento"));
                departamento.setNome(resultSet.getString("txt_nome"));
                departamento.setSigla(resultSet.getString("cod_sigla"));
                departamento.setEmail(resultSet.getString("txt_email"));
                departamento.setTelefone(resultSet.getString("nro_telefone"));
                departamento.setCEP(resultSet.getString("cod_cep"));
                departamento.setSite(resultSet.getString("txt_site"));
                
                dpto = departamento;
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return dpto;
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM `Departamento` WHERE id_departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public ArrayList<Departamento> listarTodos() throws PersistenciaException {

        ArrayList<Departamento> departamentoList = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Departamento`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultSet.getInt("id_departamento"));
                departamento.setNome(resultSet.getString("txt_nome"));
                departamento.setSigla(resultSet.getString("cod_sigla"));
                departamento.setEmail(resultSet.getString("txt_email"));
                departamento.setTelefone(resultSet.getString("nro_telefone"));
                departamento.setCEP(resultSet.getString("cod_cep"));
                departamento.setSite(resultSet.getString("txt_site"));
                
                departamentoList.add(departamento);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        
        return departamentoList;
    }

}
