package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAmbiente_AprendizagemDAO;
import br.cefetmg.inf.model.domain.Ambiente_Aprendizagem;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ambiente_AprendizagemDAO implements IAmbiente_AprendizagemDAO {

    @Override
    public Long inserir(Ambiente_Aprendizagem ambiente_aprendizagem) throws PersistenciaException {

        Long id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO `Ambiente_Aprendizagem` (`des_ambiente`, `qtd_capacidade`, `nro_sala`) " + "VALUES ( ?, ?, ? ) RETURNING id_ambiente";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setString(1, ambiente_aprendizagem.getDescricao());                        // 0  interrogação.
            statement.setInt(2, ambiente_aprendizagem.getCapacidade());                        // 1  interrogação.
            statement.setInt(3, ambiente_aprendizagem.getSala());                        // 2  interrogação.
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getLong("id_ambiente");
                ambiente_aprendizagem.setId(id);
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Ambiente_Aprendizagem ambiente) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE `Ambiente_Aprendizagem` "
                    + " SET  "
                    + "`des_ambiente` = ?, "
                    + "`qtd_capacidade` = ?, "
                    + "`nro_sala` = ?, "
                    + "`id_unidade_de_ensino` = ? "
                    + " WHERE id_ambiente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ambiente.getDescricao());                        // 1  interrogação.
            statement.setInt(2, ambiente.getCapacidade());                          // 2  interrogação.
            statement.setInt(3, ambiente.getSala());
            statement.setLong(4, ambiente.getId());
            statement.setLong(5, ambiente.getU_ensino().getId());

            statement.execute();

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM `Ambiente_Aprendizagem` WHERE id_ambiente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public Ambiente_Aprendizagem consultarPorId(Long id) throws PersistenciaException {
        Ambiente_Aprendizagem ambiente = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Ambiente_Aprendizagem` WHERE id_ambiente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ambiente = new Ambiente_Aprendizagem();
                ambiente.setId(resultSet.getLong("id_ambiente"));
                ambiente.setDescricao(resultSet.getString("des_ambiente"));
                ambiente.setCapacidade(resultSet.getInt("qtd_capacidade"));
                ambiente.setSala(resultSet.getInt("nro_sala"));
                
                UnidadeEnsinoDAO unidade = new UnidadeEnsinoDAO();
                ambiente.setU_ensino(unidade.consultarPorId(resultSet.getLong("id_unidade_de_ensino")));
                
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return ambiente;
    }

    @Override
    public ArrayList<Ambiente_Aprendizagem> listarTodos() throws PersistenciaException {

        ArrayList<Ambiente_Aprendizagem> ambiente_aprendizagemList = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Ambiente_Aprendizagem`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Ambiente_Aprendizagem ambiente = new Ambiente_Aprendizagem();
                ambiente.setId(resultSet.getLong("id_ambiente"));
                ambiente.setDescricao(resultSet.getString("des_ambiente"));
                ambiente.setCapacidade(resultSet.getInt("qtd_capacidade"));
                ambiente.setSala(resultSet.getInt("nro_sala"));
                
                UnidadeEnsinoDAO unidade = new UnidadeEnsinoDAO();
                ambiente.setU_ensino(unidade.consultarPorId(resultSet.getLong("id_unidade_de_ensino")));
                
                ambiente_aprendizagemList.add(ambiente);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return ambiente_aprendizagemList;
    }
}
