/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IGradeDisciplinaDAO;
import br.cefetmg.inf.model.domain.GradeDisciplina;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nome
 */
public class GradeDisciplinaDAO implements IGradeDisciplinaDAO{

    @Override
    public Integer inserir(GradeDisciplina gradeDisciplina) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_grade_disc) as id FROM Grade_Disciplina");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                gradeDisciplina.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO Grade_Disciplina (id_grade_disc, id_disciplina, id_grade) " + "VALUES ( ?, ?, ? ) RETURNING id_curriculo_oferta";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, gradeDisciplina.getId());                        
            statement.setInt(2, gradeDisciplina.getDisciplina().getId());  
            statement.setInt(3, gradeDisciplina.getGradeCurricular().getId());                                                                    
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                id = resultSet.getInt("id_grade_disc");
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
    public boolean atualizar(GradeDisciplina gradeDisciplina) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Grade_Disciplina "
                    + " SET  "
                    + "id_disciplina = ?, "
                    + "id_grade = ? "
                    + " WHERE id_grade_disc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, gradeDisciplina.getDisciplina().getId());                        // 1  interrogação.
            statement.setInt(2, gradeDisciplina.getGradeCurricular().getId());                          // 2  interrogação.
            statement.setInt(3, gradeDisciplina.getId());
            if(statement.executeUpdate() != 0)
                sucesso = true;statement.execute();

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

            String sql = "DELETE FROM Grade_Disciplina WHERE id_grade_disc = ?";

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
    public GradeDisciplina consultarPorId(Integer id) throws PersistenciaException {
        GradeDisciplina gradeDisciplina = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Grade_Disciplina WHERE id_grade_disc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
                gradeDisciplina = new GradeDisciplina();
                gradeDisciplina.setId(resultSet.getInt("id_grade_disc"));
                gradeDisciplina.setGradeCurricular(gradeCurricularDAO.consultarPorId(resultSet.getInt("id_grade")));
                gradeDisciplina.setDisciplina(disciplinaDAO.consultarPorId(resultSet.getInt("id_disciplina")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return gradeDisciplina;
    }

    @Override
    public List<GradeDisciplina> listarTodos() throws PersistenciaException {
        ArrayList<GradeDisciplina> gradeDisciplinas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Grade_Disciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
                GradeDisciplina gradeDisciplina = new GradeDisciplina();
                gradeDisciplina.setId(resultSet.getInt("id_grade_disc"));
                gradeDisciplina.setGradeCurricular(gradeCurricularDAO.consultarPorId(resultSet.getInt("id_grade")));
                gradeDisciplina.setDisciplina(disciplinaDAO.consultarPorId(resultSet.getInt("id_disciplina")));
                
                gradeDisciplinas.add(gradeDisciplina);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return gradeDisciplinas;
    }
    
}
