package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ICurriculo_OfertaDAO;
import br.cefetmg.inf.model.domain.Curriculo_Oferta;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public class Curriculo_OfertaDAO implements ICurriculo_OfertaDAO {

    @Override
    public Long inserir(Curriculo_Oferta obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Curriculo_Oferta obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Curriculo_Oferta consultarPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Curriculo_Oferta> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
