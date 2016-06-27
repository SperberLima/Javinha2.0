package br.cefetmg.inf.model.service;

import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface GenericManter<Entidade> {
    
    public void cadastrar(Entidade e) throws PersistenciaException, NegocioException;
    public void alterar(Entidade e) throws PersistenciaException, NegocioException;
    public Entidade buscarPorId(Long id) throws PersistenciaException, NegocioException;
    public void excluir(Entidade e) throws PersistenciaException, NegocioException;
    public List<Entidade> listarTodos() throws PersistenciaException, NegocioException;

}
