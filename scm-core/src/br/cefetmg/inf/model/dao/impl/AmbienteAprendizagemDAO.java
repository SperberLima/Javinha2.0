package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAmbienteAprendizagemDAO;
import br.cefetmg.inf.model.domain.AmbienteAprendizagem;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AmbienteAprendizagemDAO implements IAmbienteAprendizagemDAO {

    @Override
    public Integer inserir(AmbienteAprendizagem ambienteAprendizagem) throws PersistenciaException {

        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(`id_ambiente`) as id FROM Ambiente_Aprendizagem");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                ambienteAprendizagem.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO `Ambiente_Aprendizagem` (`id_ambiente`, `id_unidade_de_ensino`, `des_ambiente`, `qtd_capacidade`, `nro_sala`) " + "VALUES ( ?, ?, ?, ?, ? ) RETURNING id_ambiente";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, ambienteAprendizagem.getId());                        
            statement.setInt(2, ambienteAprendizagem.getU_ensino().getId());  
            statement.setString(3, ambienteAprendizagem.getDescricao());                        
            statement.setInt(4, ambienteAprendizagem.getCapacidade());                      
            statement.setInt(5, ambienteAprendizagem.getSala());                                              
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_curriculo_oferta");
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
    public void atualizar(AmbienteAprendizagem ambiente) throws PersistenciaException {

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
            statement.setInt(4, ambiente.getId());
            statement.setInt(5, ambiente.getU_ensino().getId());

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

            String sql = "DELETE FROM `Ambiente_Aprendizagem` WHERE id_ambiente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public AmbienteAprendizagem consultarPorId(Integer id) throws PersistenciaException {
        AmbienteAprendizagem ambiente = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Ambiente_Aprendizagem` WHERE id_ambiente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ambiente = new AmbienteAprendizagem();
                ambiente.setId(resultSet.getInt("id_ambiente"));
                ambiente.setDescricao(resultSet.getString("des_ambiente"));
                ambiente.setCapacidade(resultSet.getInt("qtd_capacidade"));
                ambiente.setSala(resultSet.getInt("nro_sala"));
                
                UnidadeEnsinoDAO unidade = new UnidadeEnsinoDAO();
                ambiente.setU_ensino(unidade.consultarPorId(resultSet.getInt("id_unidade_de_ensino")));
                
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return ambiente;
    }

    @Override
    public ArrayList<AmbienteAprendizagem> listarTodos() throws PersistenciaException {

        ArrayList<AmbienteAprendizagem> ambiente_aprendizagemList = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Ambiente_Aprendizagem`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AmbienteAprendizagem ambiente = new AmbienteAprendizagem();
                ambiente.setId(resultSet.getInt("id_ambiente"));
                ambiente.setDescricao(resultSet.getString("des_ambiente"));
                ambiente.setCapacidade(resultSet.getInt("qtd_capacidade"));
                ambiente.setSala(resultSet.getInt("nro_sala"));
                
                UnidadeEnsinoDAO unidade = new UnidadeEnsinoDAO();
                ambiente.setU_ensino(unidade.consultarPorId(resultSet.getInt("id_unidade_de_ensino")));
                
                ambiente_aprendizagemList.add(ambiente);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return ambiente_aprendizagemList;
    }
}
