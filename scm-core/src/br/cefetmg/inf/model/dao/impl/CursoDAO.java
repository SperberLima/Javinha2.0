package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.domain.Curso;
import br.cefetmg.inf.model.domain.Departamento;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO implements ICursoDAO {

    @Override
    public Integer inserir(Curso curso) throws PersistenciaException {

        Integer id = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_curso) as id FROM \"Curso\"");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                curso.setId(id+1);
            }else{
                id = 1;
            }
            
            // Comando sql a ser executado.
            String sql = "INSERT INTO \"Curso\" (id_curso, txt_nome, idt_tipo, txt_sigla, id_departamento) " + "VALUES(?, ?, ?, ?, ?) RETURNING id_curso";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement inserir = connection.prepareStatement(sql); // por culpa das interrogções;
            // assim se evita a injeção de SQL                        
            inserir.setInt(1, curso.getId());
            inserir.setString(2, curso.getNome());                        // 1ª  interrogação                    
            inserir.setString(3, curso.getTipo());                        // 1ª  interrogação                    
            inserir.setString(4, curso.getSigla());                       // 1ª  interrogação
            inserir.setInt(5, curso.getDpto().getId());                  // 1ª  interrogação

            // Executa a query.
            ResultSet resultSet = inserir.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_curriculo_oferta");
            }else{
                id = null;
            }

            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public boolean atualizar(Curso curso) throws PersistenciaException {
        boolean sucesso = false;
        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "UPDATE \"Curso\" "
                    + " SET "
                    + "txt_nome = ?, "
                    + "idt_tipo = ?, "
                    + "txt_sigla = ?, "
                    + "id_departamento = ? "
                    + " WHERE id_curso = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement atualiza = connection.prepareStatement(sql);

            atualiza.setString(1, curso.getNome());                        // 1ª  interrogação                    
            atualiza.setString(2, curso.getTipo());                        // 1ª  interrogação                    
            atualiza.setString(3, curso.getSigla());                        // 1ª  interrogação
            atualiza.setInt(4, curso.getDpto().getId());                        // 1ª  interrogação
            atualiza.setInt(5, curso.getId());                        // 1ª  interrogação


            // Executa a query.
            if(atualiza.executeUpdate() != 0)
                sucesso = true;

            // Fecha a conexao com o BD.
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
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "DELETE FROM \"Curso\" WHERE id_curso = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement excluir = connection.prepareStatement(sql);

            excluir.setInt(1, id);

            // Executa a query.
            if(excluir.executeUpdate()!=0)
                sucesso = true;

            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    @Override
    public ArrayList<Curso> listarTodos() throws PersistenciaException {

        ArrayList<Curso> cursoList = new ArrayList<>();

        try {
            // Abre a única conexão possível com o Banco de Dados.            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Curso\"";

            PreparedStatement listar = connection.prepareStatement(sql);

            // Executa a query.
            ResultSet lista = listar.executeQuery();

            // Percorre toda a 'lista'
            while (lista.next()) {
                Curso curso = new Curso();
                curso.setId(lista.getInt("id_curso"));
                curso.setNome(lista.getString("txt_nome"));
                curso.setSigla(lista.getString("txt_sigla"));
                curso.setTipo(lista.getString("idt_tipo"));

                DepartamentoDAO dpto = new DepartamentoDAO();
                curso.setDpto(dpto.consultarPorId(lista.getInt("id_departamento")));
                
                cursoList.add(curso);
            }

            // Fecha a conexao com o BD.
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return cursoList;
    }

    @Override
    public Curso consultarPorId(Integer id) throws PersistenciaException {

        Curso curso = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Curso\" ";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            // Executa a query.
            ResultSet registro = statement.executeQuery();

            if (registro.next()) {
                curso = new Curso();
                curso.setId(registro.getInt("id_curso"));
                curso.setNome(registro.getString("txt_nome"));
                curso.setSigla(registro.getString("txt_sigla"));
                curso.setTipo(registro.getString("idt_tipo"));
                
                DepartamentoDAO dpto = new DepartamentoDAO();
                curso.setDpto(dpto.consultarPorId(registro.getInt("id_departamento")));
                
                GradeCurricularDAO grade = new GradeCurricularDAO();
            }
            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return curso;
    }

    @Override
    public Curso consultarPorNome(String nome) throws PersistenciaException {

        Curso curso = null;

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "SELECT * FROM \"Curso\" WHERE txt_nome = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nome);

            // Executa a query.
            ResultSet registro = statement.executeQuery();

            if (registro.next()) {
                curso = new Curso();
                curso.setId(registro.getInt("id_curso"));
                curso.setNome(registro.getString("txt_nome"));
                curso.setSigla(registro.getString("txt_sigla"));
                curso.setTipo(registro.getString("idt_tipo"));

                DepartamentoDAO dpto = new DepartamentoDAO  ();
                curso.setDpto(dpto.consultarPorId(registro.getInt("id_departamento")));
            }
            
            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        
        return curso;
    }
    
    public ArrayList<Curso> listarPorDepartamento(Departamento departamento) throws PersistenciaException{
        ArrayList<Curso> cursos = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM \"Curso\" WHERE id_departamento = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, departamento.getId()); 
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Curso curso = new Curso();
                curso.setId(resultSet.getInt("id_curso"));
                curso.setNome(resultSet.getString("txt_nome"));
                curso.setSigla(resultSet.getString("txt_sigla"));
                curso.setTipo(resultSet.getString("idt_tipo"));
                DepartamentoDAO dpto = new DepartamentoDAO  ();
                curso.setDpto(dpto.consultarPorId(resultSet.getInt("id_departamento")));
                cursos.add(curso);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return cursos;
    }
}
