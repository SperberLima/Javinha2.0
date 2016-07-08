package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IPeriodo_LetivoDAO;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.cefetmg.inf.model.domain.Periodo_Letivo;


public class Periodo_LetivoDAO implements IPeriodo_LetivoDAO {
    @Override
    public Long inserir(Periodo_Letivo ambiente_aprendizagem) throws PersistenciaException {

        Long id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO `Periodo_Letivo` ( `dat_inicio`, `dat_fim`, `txt_descricao` ) " + "VALUES( ?, ?, ? ) RETURNING id_periodo";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setDate(1, ambiente_aprendizagem.getInicio());                        // 1  interrogação.
            statement.setDate(2, ambiente_aprendizagem.getFim());                           // 2  interrogação.
            statement.setString(3, ambiente_aprendizagem.getDescricao());                   // 3  interrogação.
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getLong("id_periodo");
                ambiente_aprendizagem.setId(id);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }
    
    @Override
    public void atualizar(Periodo_Letivo periodo) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE `Periodo_Letivo` "
                    + " SET  "
                    + "`dat_inicio` = ?, "
                    + "`dat_fim` = ?, "
                    + "`txt_descricao` = ? "
                    + " WHERE id_periodo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDate(1, periodo.getInicio());                        // 1  interrogação.
            statement.setDate(2, periodo.getFim());                          // 2  interrogação.
            statement.setString(3, periodo.getDescricao());                                // 3  interrogação.

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

            String sql = "DELETE FROM `Periodo_Letivo` WHERE id_periodo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public Periodo_Letivo consultarPorId(Long id) throws PersistenciaException {
        Periodo_Letivo ambiente = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Periodo_Letivo` WHERE id_periodo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ambiente = new Periodo_Letivo();
                ambiente.setId(resultSet.getLong("id_periodo"));
                ambiente.setDescricao(resultSet.getString("txt_descricao"));
                ambiente.setInicio(resultSet.getDate("dat_inicio"));
                ambiente.setFim(resultSet.getDate("dat_fim"));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return ambiente;
    }

    @Override
    public List<Periodo_Letivo> listarTodos() throws PersistenciaException {

        List<Periodo_Letivo> periodoList = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Periodo_Letivo`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Periodo_Letivo periodo = new Periodo_Letivo();
                periodo.setId(resultSet.getLong("id_periodo"));
                periodo.setDescricao(resultSet.getString("des_ambiente"));
                periodo.setInicio(resultSet.getDate("dat_inicio"));
                periodo.setFim(resultSet.getDate("dat_fim"));
                periodoList.add(periodo);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return periodoList;
    }
}
