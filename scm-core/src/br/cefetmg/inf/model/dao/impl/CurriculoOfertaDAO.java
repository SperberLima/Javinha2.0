package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICurriculoOfertaDAO;
import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.service.IManterGradeCurricular;
import br.cefetmg.inf.model.service.IManterPeriodoLetivo;
import br.cefetmg.inf.model.service.impl.ManterGradeCurricular;
import br.cefetmg.inf.model.service.impl.ManterPeriodoLetivo;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CurriculoOfertaDAO implements ICurriculoOfertaDAO {

    @Override
    public Integer inserir(CurriculoOferta curriculoOferta) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(`id_curriculo_oferta`) as id FROM Curriculo_em_Oferta");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                if(id == null) id = 1;
                curriculoOferta.setId(id);
            }
            
            String sql = "INSERT INTO `Curriculo_em_Oferta` (`id_curriculo_oferta`, `id_periodo`, `id_grade`) " + "VALUES ( ?, ?, ? ) RETURNING id_curriculo_oferta";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, curriculoOferta.getId());                        
            statement.setInt(2, curriculoOferta.getPeriodoLetivo().getId());  
            statement.setInt(3, curriculoOferta.getGradeCurricular().getId());                                                                    
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_curriculo_oferta");
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(CurriculoOferta curriculoOferta) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE `Curriculo_em_Oferta` "
                    + " SET  "
                    + "`id_periodo` = ?, "
                    + "`id_grade` = ?, "
                    + " WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, curriculoOferta.getPeriodoLetivo().getId());                        // 1  interrogação.
            statement.setInt(2, curriculoOferta.getGradeCurricular().getId());                          // 2  interrogação.
            statement.setInt(3, curriculoOferta.getId());
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

            String sql = "DELETE FROM `Curriculo_em_Oferta` WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public CurriculoOferta consultarPorId(Integer id) throws PersistenciaException {
        CurriculoOferta curriculoOferta = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Curriculo_em_Oferta` WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                IManterGradeCurricular manterGrade = new ManterGradeCurricular();
                IManterPeriodoLetivo manterPeriodo = new ManterPeriodoLetivo();
                curriculoOferta = new CurriculoOferta();
                curriculoOferta.setId(resultSet.getInt("id_curriculo_oferta"));
                curriculoOferta.setGradeCurricular(manterGrade.buscarPorId(resultSet.getInt("id_grade")));
                curriculoOferta.setPeriodoLetivo(manterPeriodo.buscarPorId(resultSet.getInt("id_periodo")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        } catch (NegocioException ex) {
        }
        return curriculoOferta;
    }

    @Override
    public ArrayList<CurriculoOferta> listarTodos() throws PersistenciaException {
        ArrayList<CurriculoOferta> curriculoOfertas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `id_curriculo_oferta`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                IManterGradeCurricular manterGrade = new ManterGradeCurricular();
                IManterPeriodoLetivo manterPeriodo = new ManterPeriodoLetivo();
                CurriculoOferta curriculoOferta = new CurriculoOferta();
                curriculoOferta.setId(resultSet.getInt("id_curriculo_oferta"));
                curriculoOferta.setGradeCurricular(manterGrade.buscarPorId(resultSet.getInt("id_grade")));
                curriculoOferta.setPeriodoLetivo(manterPeriodo.buscarPorId(resultSet.getInt("id_periodo")));
                
                curriculoOfertas.add(curriculoOferta);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        } catch (NegocioException ex) {
            
        }
        return curriculoOfertas;
    }
    
}
