package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICursoDAO;
import br.cefetmg.inf.model.domain.Curso;
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
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(`id_curso`) as id FROM Curso");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                if(id == null) id = 1;
                curso.setId(id);
            }
            
            // Comando sql a ser executado.
            String sql = "INSERT INTO Curso (`id_curso`, `txt_nome`, `idt_tipo`, `txt_sigla`, `id_departamento`) " + "VALUES(?, ?, ?, ?, ?) RETURNING id_curso";

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
                id = resultSet.getInt("id_curso");
                curso.setId(id);
            }

            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

        return id;
    }

    @Override
    public void atualizar(Curso curso) throws PersistenciaException {

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "UPDATE Curso "
                    + " SET "
                    + "`txt_nome` = ?, "
                    + "`idt_tipo` = ?, "
                    + "`txt_sigla` = ?, "
                    + "`id_departamento` = ? "
                    + " WHERE id_curso = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement atualiza = connection.prepareStatement(sql);

            atualiza.setString(1, curso.getNome());                        // 1ª  interrogação                    
            atualiza.setString(2, curso.getTipo());                        // 1ª  interrogação                    
            atualiza.setString(3, curso.getSigla());                        // 1ª  interrogação
            atualiza.setLong(4, curso.getDpto().getId());                        // 1ª  interrogação
            atualiza.setLong(5, curso.getId());                        // 1ª  interrogação


            // Executa a query.
            atualiza.execute();

            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {

        try {
            // Abre a única conexão possível com o Banco de Dados.
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            // Comando sql a ser executado.
            String sql = "DELETE FROM Curso WHERE id_curso = ?";

            // Prepara o comando sql, a fim de evitar injeção de sql.
            PreparedStatement excluir = connection.prepareStatement(sql);

            excluir.setLong(1, id);

            // Executa a query.
            excluir.execute();

            // Fecha a conexao com o BD.
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }

    }

    @Override
    public ArrayList<Curso> listarTodos() throws PersistenciaException {

        ArrayList<Curso> cursoList = new ArrayList<>();

        try {
            // Abre a única conexão possível com o Banco de Dados.            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Curso";

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

            String sql = "SELECT * FROM Curso ";

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
            String sql = "SELECT * FROM curso WHERE txt_nome = ?";

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
}
