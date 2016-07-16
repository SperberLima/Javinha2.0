package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICurriculoOfertaDAO;
import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
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
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_curriculo_oferta) as id FROM \"Curriculo_em_Oferta\"");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                curriculoOferta.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO \"Curriculo_em_Oferta\" (id_curriculo_oferta, id_periodo, id_grade) " + "VALUES ( ?, ?, ? ) RETURNING id_curriculo_oferta";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, curriculoOferta.getId());                        
            statement.setInt(2, curriculoOferta.getPeriodoLetivo().getId());  
            statement.setInt(3, curriculoOferta.getGradeCurricular().getId());                                                                    
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
    public boolean atualizar(CurriculoOferta curriculoOferta) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE \"Curriculo_em_Oferta\" "
                    + " SET  "
                    + "id_periodo = ?, "
                    + "id_grade = ?, "
                    + " WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, curriculoOferta.getPeriodoLetivo().getId());                        // 1  interrogação.
            statement.setInt(2, curriculoOferta.getGradeCurricular().getId());                          // 2  interrogação.
            statement.setInt(3, curriculoOferta.getId());
            if(statement.executeUpdate() != 0)
                sucesso = true;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM \"Curriculo_em_Oferta\" WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            if(statement.executeUpdate() != 0)
                sucesso = true;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    @Override
    public CurriculoOferta consultarPorId(Integer id) throws PersistenciaException {
        CurriculoOferta curriculoOferta = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Curriculo_em_Oferta\" WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                GradeCurricularDAO daoGrade = new GradeCurricularDAO();
                PeriodoLetivoDAO daoPeriodo = new PeriodoLetivoDAO();
                curriculoOferta = new CurriculoOferta();
                curriculoOferta.setId(resultSet.getInt("id_curriculo_oferta"));
                curriculoOferta.setGradeCurricular(daoGrade.consultarPorId(resultSet.getInt("id_grade")));
                curriculoOferta.setPeriodoLetivo(daoPeriodo.consultarPorId(resultSet.getInt("id_periodo")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return curriculoOferta;
    }

    @Override
    public ArrayList<CurriculoOferta> listarTodos() throws PersistenciaException {
        ArrayList<CurriculoOferta> curriculoOfertas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Curriculo_em_Oferta\"";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                GradeCurricularDAO daoGrade = new GradeCurricularDAO();
                PeriodoLetivoDAO daoPeriodo = new PeriodoLetivoDAO();
                CurriculoOferta curriculoOferta = new CurriculoOferta();
                curriculoOferta.setId(resultSet.getInt("id_curriculo_oferta"));
                curriculoOferta.setGradeCurricular(daoGrade.consultarPorId(resultSet.getInt("id_grade")));
                curriculoOferta.setPeriodoLetivo(daoPeriodo.consultarPorId(resultSet.getInt("id_periodo")));
                
                curriculoOfertas.add(curriculoOferta);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return curriculoOfertas;
    }
    
}
