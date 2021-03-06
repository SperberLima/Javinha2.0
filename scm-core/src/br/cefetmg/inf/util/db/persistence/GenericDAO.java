package br.cefetmg.inf.util.db.persistence;

import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface GenericDAO<Entidade> {

    Integer inserir(Entidade obj) throws PersistenciaException;
    boolean atualizar(Entidade obj) throws PersistenciaException;
    boolean excluir(Integer id) throws PersistenciaException;
    Entidade consultarPorId(Integer id) throws PersistenciaException;
    List<Entidade> listarTodos() throws PersistenciaException;

}
