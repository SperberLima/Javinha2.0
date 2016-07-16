/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.service.impl;

import br.cefetmg.inf.model.dao.IUsuarioDAO;
import br.cefetmg.inf.model.dao.impl.UsuarioDAO;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.service.IManterUsuario;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ManterUsuario implements IManterUsuario{
    
    @Override
    public Integer cadastrar(Usuario Usuario) throws PersistenciaException, NegocioException {

        if (Usuario.getNome().equals("")){
            throw new NegocioException("O usuario deve ter nome");
        }
        
   
        if (Usuario.getNome().equals("")){
            throw new NegocioException("O usuario deve ter senha");
        }
        
    
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(Usuario);
        
        return 1;
    }

    @Override
    public boolean alterar(Usuario Usuario) throws PersistenciaException, NegocioException {
        if (Usuario.getNome().equals("")){
            throw new NegocioException("O usuario deve ter nome");
        }
        
   
        if (Usuario.getNome().equals("")){
            throw new NegocioException("O usuario deve ter senha");
        }
        
        IUsuarioDAO UsuarioDAO = new UsuarioDAO();
        return UsuarioDAO.atualizar(Usuario);
    }

    public Usuario buscarPorId(String id) throws PersistenciaException, NegocioException {
        
        UsuarioDAO UsuarioDAO = new UsuarioDAO();
        Usuario Usuario = UsuarioDAO.consultarPorId(id);
        return Usuario;
        
    }

    public boolean excluir(String id) throws PersistenciaException, NegocioException {
        UsuarioDAO UsuarioDAO = new UsuarioDAO();
        return UsuarioDAO.excluir(id);
    }

    @Override
    public List<Usuario> listarTodos() throws PersistenciaException, NegocioException {
        IUsuarioDAO UsuarioDAO = new UsuarioDAO();
        List<Usuario> listUsuario = UsuarioDAO.listarTodos();
        return listUsuario;
    }

    @Override
    public Usuario buscarPorId(Integer id) throws PersistenciaException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
