package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDisciplinaDAO;
import br.cefetmg.inf.model.domain.Disciplina;
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
            
            PreparedStatement search = connection.prepareStatement("SELECT MAX(`id_disciplina`) as id FROM Disciplina");
            
            ResultSet resultSearch = search.executeQuery();

            if (resultSearch.next()) {
                id = resultSearch.getInt("id");
                if(id == null) id = 1;
                disciplina.setId(id);
            }
            
            String sql = "INSERT INTO `Curriculo_em_Oferta` (`id_disciplina`, `id_departamento`, `txt_nome`, `qtd_carga_horaria`, `txt_ementa`) " + "VALUES ( ?, ?, ?, ? ,? ) RETURNING id_disciplina";

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

            String sql = "UPDATE `Disciplina` "
                    + " SET  "
                    + "`id_departamento` = ?, "
                    + "`txt_nome` = ?, "
                    + "`qtd_carga_horaria` = ?, "
                    + "`txt_ementa` = ?, "
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Disciplina consultarPorId(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Disciplina> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Disciplina> listarPorGrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
