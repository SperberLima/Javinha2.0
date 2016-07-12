/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IHorarioDAO;
import br.cefetmg.inf.model.domain.Horario;
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
public class HorarioDAO implements IHorarioDAO{

    @Override
    public Integer inserir(Horario horario) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(`id_horario`) as id FROM Horario");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                horario.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO `Horario` (`id_horario`, `id_ambiente`, `id_turma`, `id_prof_disc`, `dat_inicio`, `dat_fim`) " + "VALUES ( ?, ?, ?, ?, ?, ?) RETURNING id_horario";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, horario.getId());                        
            statement.setInt(2, horario.getAmbiente().getId());  
            statement.setInt(3, horario.getTurma().getId());
            statement.setInt(4, horario.getProfessorDisciplina().getId());
            statement.setDate(5, horario.getInicio());
            statement.setDate(6, horario.getFim());
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                id = resultSet.getInt("id_horario");
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
    public void atualizar(Horario horario) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE `Professor_Disciplina` "
                    + " SET  "
                    + "`id_ambiente` = ?, "
                    + "`id_turma` = ?, "
                    + "`id_prof_disc` = ?, "
                    + "`id_inicio` = ?, "
                    + "`id_fim` = ? "
                    + " WHERE id_horario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, horario.getAmbiente().getId());                        // 1  interrogação.
            statement.setInt(2, horario.getTurma().getId());                          // 2  interrogação.
            statement.setInt(3, horario.getProfessorDisciplina().getId());
            statement.setDate(4, horario.getInicio());
            statement.setDate(5, horario.getFim());
            statement.setInt(6, horario.getId());
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

            String sql = "DELETE FROM `Horario` WHERE id_horario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Horario consultarPorId(Integer id) throws PersistenciaException {
        Horario horario = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Horario` WHERE id_horario = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                AmbienteAprendizagemDAO ambienteAprendizagemDAO = new AmbienteAprendizagemDAO();
                TurmaDAO turmaDAO = new TurmaDAO();
                ProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
                horario = new Horario();
                horario.setInicio(resultSet.getDate("dat_inicio"));
                horario.setFim(resultSet.getDate("dat_fim"));
                horario.setAmbiente(ambienteAprendizagemDAO.consultarPorId(resultSet.getInt("id_ambiente")));
                horario.setTurma(turmaDAO.consultarPorId(resultSet.getInt("id_turma")));
                horario.setProfessorDisciplina(professorDisciplinaDAO.consultarPorId(resultSet.getInt("id_prof_disc")));
                
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return horario;
    }

    @Override
    public List<Horario> listarTodos() throws PersistenciaException {
        ArrayList<Horario> horarios = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM `Horario`";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AmbienteAprendizagemDAO ambienteAprendizagemDAO = new AmbienteAprendizagemDAO();
                TurmaDAO turmaDAO = new TurmaDAO();
                ProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();
                Horario horario = new Horario();
                horario.setInicio(resultSet.getDate("dat_inicio"));
                horario.setFim(resultSet.getDate("dat_fim"));
                horario.setAmbiente(ambienteAprendizagemDAO.consultarPorId(resultSet.getInt("id_ambiente")));
                horario.setTurma(turmaDAO.consultarPorId(resultSet.getInt("id_turma")));
                horario.setProfessorDisciplina(professorDisciplinaDAO.consultarPorId(resultSet.getInt("id_prof_disc")));
                
                horarios.add(horario);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return horarios;
    }
    
}
