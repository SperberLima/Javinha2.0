package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IGradeCurricularDAO;
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

public class GradeCurricularDAO implements IGradeCurricularDAO {

    @Override
    public Integer inserir(GradeCurricular gradeCurricular) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_grade) as id FROM \"Grade_Curricular\"");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                gradeCurricular.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO \"Grade_Curricular\" (id_grade, id_curso, nro_serie, txt_descricao) " + "VALUES ( ?, ?, ? ,? ) RETURNING id_grade";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, gradeCurricular.getId());                        
            statement.setInt(2, gradeCurricular.getCurso().getId());                        
            statement.setInt(3, gradeCurricular.getSerie());                        
            statement.setString(4, gradeCurricular.getDescricao());                        
                                                                 
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_grade");
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
    public boolean atualizar(GradeCurricular gradeCurricular) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE \"Grade_Curricular\" "
                    + " SET  "
                    + "id_curso = ?, "
                    + "nro_serie = ?, "
                    + "txt_descricao = ?, "
                    + " WHERE id_grade = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, gradeCurricular.getCurso().getId());                        
            statement.setInt(2, gradeCurricular.getSerie());                        
            statement.setString(3, gradeCurricular.getDescricao());
            statement.setInt(4, gradeCurricular.getId());                        
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

            String sql = "DELETE FROM \"GradeCurricular\" WHERE id_disciplina = ?";

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
    public GradeCurricular consultarPorId(Integer id) throws PersistenciaException {
        GradeCurricular gradeCurricular = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Grade_Curricular\" WHERE id_grade = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                CursoDAO daoCurso = new CursoDAO();
                gradeCurricular = new GradeCurricular();
                gradeCurricular.setId(resultSet.getInt("id_grade"));
                gradeCurricular.setDescricao(resultSet.getString("txt_descricao"));
                gradeCurricular.setSerie(resultSet.getInt("nro_serie"));
                gradeCurricular.setCurso(daoCurso.consultarPorId(resultSet.getInt("id_curso")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return gradeCurricular;
    }

    @Override
    public ArrayList<GradeCurricular> listarTodos() throws PersistenciaException {
        ArrayList<GradeCurricular> gradeCurriculares = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Grade_Curricular\"";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CursoDAO daoCurso = new CursoDAO();
                GradeCurricular gradeCurricular = new GradeCurricular();
                gradeCurricular.setId(resultSet.getInt("id_grade"));
                gradeCurricular.setDescricao(resultSet.getString("txt_descricao"));
                gradeCurricular.setSerie(resultSet.getInt("nro_serie"));
                gradeCurricular.setCurso(daoCurso.consultarPorId(resultSet.getInt("id_curso")));
                
                gradeCurriculares.add(gradeCurricular);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return gradeCurriculares;
    }

    @Override
    public List<GradeCurricular> listarPorCurso(Integer id)  throws PersistenciaException {
        
        ArrayList<GradeCurricular> gradeCurriculares = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Grade_Curricular\" WHERE id_grade = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, id); 
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CursoDAO daoCurso = new CursoDAO();
                GradeCurricular gradeCurricular = new GradeCurricular();
                gradeCurricular.setId(resultSet.getInt("id_grade"));
                gradeCurricular.setDescricao(resultSet.getString("txt_descricao"));
                gradeCurricular.setSerie(resultSet.getInt("nro_serie"));
                gradeCurricular.setCurso(daoCurso.consultarPorId(resultSet.getInt("id_curso")));
                gradeCurriculares.add(gradeCurricular);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return gradeCurriculares;
    }
    
    public List<Disciplina> listarDisciplinas(GradeCurricular gradeCurricular) throws PersistenciaException{
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Disciplina\" WHERE id_disciplina in (SELECT id_disciplina FROM Grade_Disciplina WHERE id_grade = ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, gradeCurricular.getId()); 
            
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
