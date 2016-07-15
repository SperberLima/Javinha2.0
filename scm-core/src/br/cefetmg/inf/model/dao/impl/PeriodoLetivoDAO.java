package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IPeriodoLetivoDAO;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.cefetmg.inf.model.domain.PeriodoLetivo;


public class PeriodoLetivoDAO implements IPeriodoLetivoDAO {
    @Override
    public Integer inserir(PeriodoLetivo periodoLetivo) throws PersistenciaException {

        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_periodo) as id FROM Periodo_Letivo");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                periodoLetivo.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO Periodo_Letivo ( id_periodo, dat_inicio, dat_fim, txt_descricao ) " + "VALUES( ?, ?, ?, ? ) RETURNING id_periodo";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, periodoLetivo.getId());
            statement.setDate(2, periodoLetivo.getInicio());                        // 1  interrogação.
            statement.setDate(3, periodoLetivo.getFim());                           // 2  interrogação.
            statement.setString(4, periodoLetivo.getDescricao());                   // 3  interrogação.
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_disciplina");
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
    public void atualizar(PeriodoLetivo periodo) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Periodo_Letivo "
                    + " SET  "
                    + "dat_inicio = ?, "
                    + "dat_fim = ?, "
                    + "txt_descricao = ? "
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
    public void excluir(Integer id) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Periodo_Letivo WHERE id_periodo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public PeriodoLetivo consultarPorId(Integer id) throws PersistenciaException {
        PeriodoLetivo ambiente = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Periodo_Letivo WHERE id_periodo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ambiente = new PeriodoLetivo();
                ambiente.setId(resultSet.getInt("id_periodo"));
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
    public List<PeriodoLetivo> listarTodos() throws PersistenciaException {

        List<PeriodoLetivo> periodoList = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Periodo_Letivo";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PeriodoLetivo periodo = new PeriodoLetivo();
                periodo.setId(resultSet.getInt("id_periodo"));
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
