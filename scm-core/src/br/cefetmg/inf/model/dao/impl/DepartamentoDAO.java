package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDepartamentoDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements IDepartamentoDAO {

    @Override
    public Long inserir(Departamento departamento) throws PersistenciaException {

        Long id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO `Departamento` ( `txt_nome`, cod_sigla`, txt_email`, nro_telefone`, cod_cep`, txt_site` ) " + "VALUES( ?, ?, ?, ?, ?, ? ) RETURNING id";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setString(1, departamento.getNome());                        // 0  interrogação.
            statement.setString(2, departamento.getSigla());                        // 1  interrogação.
            statement.setString(3, departamento.getEmail());                        // 2  interrogação.
            statement.setString(4, departamento.getTelefone());                        // 3  interrogação.
            statement.setString(5, departamento.getCEP());                        // 4  interrogação.
            statement.setString(6, departamento.getSite());                        // 5  interrogação.
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getLong("id");
                departamento.setId(id);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
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
                    + " WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, departamento.getNome());                        // 1  interrogação.
            statement.setString(2, departamento.getSigla());                        // 2  interrogação.
            statement.setString(3, departamento.getEmail());                        // 3  interrogação.
            statement.setString(4, departamento.getTelefone());                        // 4  interrogação.
            statement.setString(5, departamento.getCEP());                        // 5  interrogação.
            statement.setString(6, departamento.getSite());                        // 6  interrogação.

            statement.execute();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Departamento consultarPorId(Long id) throws PersistenciaException {
        Departamento dpto = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Departamento` WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultSet.getLong("id"));
                departamento.setNome(resultSet.getString("txt_nome"));
                departamento.setSigla(resultSet.getString("cod_sigla"));
                departamento.setEmail(resultSet.getString("txt_email"));
                departamento.setTelefone(resultSet.getString("nro_telefone"));
                departamento.setCEP(resultSet.getString("cod_cep"));
                departamento.setSite(resultSet.getString("txt_site"));
                dpto = departamento;
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
        return dpto;
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM `Departamento` WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public List<Departamento> listarTodos() throws PersistenciaException {

        List<Departamento> departamentoList = new ArrayList<Departamento>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Departamento`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultSet.getLong("id"));
                departamento.setNome(resultSet.getString("txt_nome"));
                departamento.setSigla(resultSet.getString("cod_sigla"));
                departamento.setEmail(resultSet.getString("txt_email"));
                departamento.setTelefone(resultSet.getString("nro_telefone"));
                departamento.setCEP(resultSet.getString("cod_cep"));
                departamento.setSite(resultSet.getString("txt_site"));
                departamentoList.add(departamento);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
        return departamentoList;
    }

}
