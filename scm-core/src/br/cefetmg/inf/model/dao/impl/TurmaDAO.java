/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ITurmaDAO;
import br.cefetmg.inf.model.domain.CurriculoOferta;
import br.cefetmg.inf.model.domain.Turma;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO implements ITurmaDAO{

    @Override
    public Integer inserir(Turma turma) throws PersistenciaException {
        Integer id = null;

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            // Busca o maior id
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(id_turma) as id FROM Turma");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                turma.setId(id+1);
            }else{
                id = 1;
            }
            
            String sql = "INSERT INTO Turma (id_turma, id_curriculo_oferta, txt_nome) " + "VALUES ( ?, ?, ? ) RETURNING id_turma";

            PreparedStatement statement = connection.prepareStatement(sql); // por culpa dos ????;
            // assim se evita a injeção de SQL                        
            statement.setInt(1, turma.getId());                        
            statement.setInt(2, turma.getCurriculoOferta().getId());  
            statement.setString(3, turma.getNome());                                                                    
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                id = resultSet.getInt("id_turma");
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
    public boolean atualizar(Turma turma) throws PersistenciaException {
        boolean sucesso = false;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Curriculo_em_Oferta "
                    + " SET  "
                    + "id_curriculo_oferta = ?, "
                    + "txt_nome = ? "
                    + " WHERE id_turma = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, turma.getCurriculoOferta().getId());                        // 1  interrogação.
            statement.setString(2, turma.getNome());                          // 2  interrogação.
            statement.setInt(3, turma.getId());
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

            String sql = "DELETE FROM Turma WHERE id_turma = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            if(statement.executeUpdate()!= 0)
                sucesso = true;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return sucesso;
    }

    @Override
    public Turma consultarPorId(Integer id) throws PersistenciaException {
        Turma turma = null;
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Curriculo_em_Oferta WHERE id_curriculo_oferta = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                CurriculoOfertaDAO curriculoOfertaDAO = new CurriculoOfertaDAO();
                turma = new Turma();
                turma.setId(resultSet.getInt("id_turma"));
                turma.setCurriculoOferta(curriculoOfertaDAO.consultarPorId(resultSet.getInt("id_curriculo_oferta")));
                turma.setNome(resultSet.getString("txt_nome"));
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return turma;
    }

    @Override
    public List<Turma> listarTodos() throws PersistenciaException {
        ArrayList<Turma> turmas = new ArrayList<>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Turma";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CurriculoOfertaDAO curriculoOfertaDAO = new CurriculoOfertaDAO();
                Turma turma = new Turma();
                turma.setId(resultSet.getInt("id_turma"));
                turma.setCurriculoOferta(curriculoOfertaDAO.consultarPorId(resultSet.getInt("id_curriculo_oferta")));
                turma.setNome(resultSet.getString("txt_nome"));
                
                turmas.add(turma);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return turmas;
    }
    
}
