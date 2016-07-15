package br.cefetmg.inf.model.service;

import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface GenericManter<Entidade> {
    
    public Integer cadastrar(Entidade e) throws PersistenciaException, NegocioException;
    public boolean alterar(Entidade e) throws PersistenciaException, NegocioException;
    public Entidade buscarPorId(Integer id) throws PersistenciaException, NegocioException;
    public boolean excluir(Integer id) throws PersistenciaException, NegocioException;
    public List<Entidade> listarTodos() throws PersistenciaException, NegocioException;

}
