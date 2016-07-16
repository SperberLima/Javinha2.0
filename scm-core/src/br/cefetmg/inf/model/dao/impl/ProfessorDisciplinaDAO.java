/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IProfessorDisciplinaDAO;
import br.cefetmg.inf.model.domain.ProfessorDisciplina;
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
public class ProfessorDisciplinaDAO implements IProfessorDisciplinaDAO{

    @Override
    public Integer inserir(ProfessorDisciplina professorDisciplina) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_prof_disc) as id FROM \"Professor_Disciplina\"");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                professorDisciplina.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO \"Professor_Disciplina\" (id_prof_disc, id_disciplina, id_professor) " + "VALUES ( ?, ?, ? ) RETURNING id_prof_disc";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, professorDisciplina.getId());                        
            statement.setInt(2, professorDisciplina.getDisciplina().getId());  
            statement.setInt(3, professorDisciplina.getProfessor().getId());                                                                    
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                id = resultSet.getInt("id_prof_disc");
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
    public boolean atualizar(ProfessorDisciplina professorDisciplina) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE \"Professor_Disciplina\" "
                    + " SET  "
                    + "id_disciplina = ?, "
                    + "id_professor = ? "
                    + " WHERE id_prof_disc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, professorDisciplina.getDisciplina().getId());                        // 1  interrogação.
            statement.setInt(2, professorDisciplina.getProfessor().getId());                          // 2  interrogação.
            statement.setInt(3, professorDisciplina.getId());
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

            String sql = "DELETE FROM \"Professor_Disciplina\" WHERE id_prof_disc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            if(statement.executeUpdate()!=0)
                sucesso = false;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    @Override
    public ProfessorDisciplina consultarPorId(Integer id) throws PersistenciaException {
        ProfessorDisciplina professorDisciplina = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Professor_Disciplina\" WHERE id_prof_disc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                ProfessorDAO professorDAO = new ProfessorDAO();
                professorDisciplina = new ProfessorDisciplina();
                professorDisciplina.setId(resultSet.getInt("id_prof_disc"));
                professorDisciplina.setProfessor(professorDAO.consultarPorId(resultSet.getInt("id_professor")));
                professorDisciplina.setDisciplina(disciplinaDAO.consultarPorId(resultSet.getInt("id_disciplina")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return professorDisciplina;
    }

    @Override
    public List<ProfessorDisciplina> listarTodos() throws PersistenciaException {
        ArrayList<ProfessorDisciplina> professorDisciplinas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Professor_Disciplina\"";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                ProfessorDAO professorDAO = new ProfessorDAO();
                ProfessorDisciplina professorDisciplina = new ProfessorDisciplina();
                professorDisciplina.setId(resultSet.getInt("id_prof_disc"));
                professorDisciplina.setProfessor(professorDAO.consultarPorId(resultSet.getInt("id_professor")));
                professorDisciplina.setDisciplina(disciplinaDAO.consultarPorId(resultSet.getInt("id_disciplina")));
                
                professorDisciplinas.add(professorDisciplina);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return professorDisciplinas;
    }
    
}
