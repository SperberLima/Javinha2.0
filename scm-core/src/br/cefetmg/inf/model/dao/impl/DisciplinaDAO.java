package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDisciplinaDAO;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.GradeCurricular;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO implements IDisciplinaDAO {

    @Override
    public Integer inserir(Disciplina disciplina) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_disciplina) as id FROM Disciplina");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                disciplina.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO Disciplina (id_disciplina, id_departamento, txt_nome, qtd_carga_horaria, txt_ementa) " + "VALUES ( ?, ?, ?, ? ,? ) RETURNING id_disciplina";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, disciplina.getId());                        
            statement.setInt(2, disciplina.getDepartamento().getId());                        
            statement.setString(3, disciplina.getNome());                        
            statement.setInt(4, disciplina.getCargaHoraria());                        
            statement.setString(5, disciplina.getEmenta());                        
                                                                 
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
    public void atualizar(Disciplina disciplina) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Disciplina "
                    + " SET  "
                    + "id_departamento = ?, "
                    + "txt_nome = ?, "
                    + "qtd_carga_horaria = ?, "
                    + "txt_ementa = ?, "
                    + " WHERE id_disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(5, disciplina.getId());                        
            statement.setInt(1, disciplina.getDepartamento().getId());                        
            statement.setString(2, disciplina.getNome());                        
            statement.setInt(3, disciplina.getCargaHoraria());                        
            statement.setString(4, disciplina.getEmenta());
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

            String sql = "DELETE FROM Disciplina WHERE id_disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Disciplina consultarPorId(Integer id) throws PersistenciaException {
        Disciplina disciplina = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Disciplina WHERE id_disciplina = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DepartamentoDAO daoDepartamento = new DepartamentoDAO();
                disciplina = new Disciplina();
                disciplina.setId(resultSet.getInt("id_disciplina"));
                disciplina.setCargaHoraria(resultSet.getInt("qtd_carga_horaria"));
                disciplina.setEmenta(resultSet.getString("txt_ementa"));
                disciplina.setNome(resultSet.getString("txt_nome"));
                disciplina.setDepartamento(daoDepartamento.consultarPorId(resultSet.getInt("id_departamento")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return disciplina;
    }

    @Override
    public ArrayList<Disciplina> listarTodos() throws PersistenciaException {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Disciplina";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DepartamentoDAO daoDepartamento = new DepartamentoDAO();
                Disciplina disciplina = new Disciplina();
                disciplina.setId(resultSet.getInt("id_disciplina"));
                disciplina.setCargaHoraria(resultSet.getInt("qtd_carga_horaria"));
                disciplina.setEmenta(resultSet.getString("txt_ementa"));
                disciplina.setNome(resultSet.getString("txt_nome"));
                disciplina.setDepartamento(daoDepartamento.consultarPorId(resultSet.getInt("id_departamento")));
                
                disciplinas.add(disciplina);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return disciplinas;
    }
    
    @Override
    public List<Disciplina> listarPorDepartamento(Departamento departamento) throws PersistenciaException{
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Disciplina WHERE id_departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, departamento.getId()); 
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DepartamentoDAO daoDepartamento = new DepartamentoDAO();
                Disciplina disciplina = new Disciplina();
                disciplina.setId(resultSet.getInt("id_disciplina"));
                disciplina.setCargaHoraria(resultSet.getInt("qtd_carga_horaria"));
                disciplina.setEmenta(resultSet.getString("txt_ementa"));
                disciplina.setNome(resultSet.getString("txt_nome"));
                disciplina.setDepartamento(daoDepartamento.consultarPorId(resultSet.getInt("id_departamento")));
                
                disciplinas.add(disciplina);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return disciplinas;
    }
    
}
