package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IProfessorDAO;
import br.cefetmg.inf.model.domain.Disciplina;
import br.cefetmg.inf.model.domain.Professor;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO implements IProfessorDAO {

    @Override
    public Professor consultarPorNome(String nome) throws PersistenciaException {
        Professor professor = new Professor();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Professor\" WHERE txt_nome ILIKE ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+nome+"%");
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DepartamentoDAO daoDepartamento = new DepartamentoDAO();
                professor.setId(resultSet.getInt("id_professor"));
                professor.setDescricao(resultSet.getString("txt_descricao"));
                professor.setNome(resultSet.getString("txt_nome"));
                professor.setCPF(resultSet.getString("cod_cpf"));
                professor.setTelefone(resultSet.getString("nro_telefone"));
                professor.setDpto(daoDepartamento.consultarPorId(resultSet.getInt("id_departamento")));

            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return professor;
    }

    @Override
    public Integer inserir(Professor professor) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_professor) as id FROM Professor");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                professor.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO \"Professor\" (id_professor, id_departamento, txt_nome, nro_telefone, cod_cpf, txt_descricao) " + "VALUES ( ?, ?, ? , ?, ?, ? ) RETURNING id_professor";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, professor.getId());
            statement.setInt(2, professor.getDpto().getId());
            statement.setString(3, professor.getNome());
            statement.setString(4, professor.getTelefone());
            statement.setString(5, professor.getCPF());
            statement.setString(6, professor.getDescricao());
                                                                 
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_professor");
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
    public boolean atualizar(Professor professor) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE \"Professor\" "
                    + " SET  "
                    + "id_departamento = ?, "
                    + "txt_nome = ?, "
                    + "nro_telefone = ?, "
                    + "cod_cpf = ?, "
                    + "txt_descricao = ?, "
                    + " WHERE id_professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, professor.getDpto().getId());                        
            statement.setString(2, professor.getNome());                        
            statement.setString(3, professor.getTelefone());
            statement.setString(4, professor.getCPF());                        
            statement.setString(5, professor.getDescricao());
            statement.setInt(6, professor.getId());
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

            String sql = "DELETE FROM \"Professor\" WHERE id_professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            if(statement.executeUpdate()!=0)
                sucesso = true;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    @Override
    public Professor consultarPorId(Integer id) throws PersistenciaException {
        Professor professor = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Professor\" WHERE id_professor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DepartamentoDAO daoDepartamento = new DepartamentoDAO();
                professor = new Professor();
                professor.setId(resultSet.getInt("id_professor"));
                professor.setDescricao(resultSet.getString("txt_descricao"));
                professor.setNome(resultSet.getString("txt_nome"));
                professor.setCPF(resultSet.getString("cod_cpf"));
                professor.setTelefone(resultSet.getString("nro_telefone"));
                professor.setDpto(daoDepartamento.consultarPorId(resultSet.getInt("id_departamento")));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return professor;
    }

    @Override
    public ArrayList<Professor> listarTodos() throws PersistenciaException {
        ArrayList<Professor> professores = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Professor\"";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DepartamentoDAO daoDepartamento = new DepartamentoDAO();
                Professor professor = new Professor();
                professor.setId(resultSet.getInt("id_professor"));
                professor.setDescricao(resultSet.getString("txt_descricao"));
                professor.setNome(resultSet.getString("txt_nome"));
                professor.setCPF(resultSet.getString("cod_cpf"));
                professor.setTelefone(resultSet.getString("nro_telefone"));
                professor.setDpto(daoDepartamento.consultarPorId(resultSet.getInt("id_departamento")));
                professores.add(professor);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return professores;
    }
    
    public ArrayList<Disciplina> listarDisciplinas(Professor professor) throws PersistenciaException {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Disciplina\" WHERE id_disciplina in (SELECT id_disciplina FROM Professor_Disciplina WHERE id_professor = ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, professor.getId());
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
