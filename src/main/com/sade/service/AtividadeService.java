package com.sade.service;

import com.sade.dao.AtividadeDao;
import com.sade.manager.SimpleEntityManager;
import com.sade.model.Atividade;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class AtividadeService {
    
    private AtividadeDao dao;
    private SimpleEntityManager simpleEntityManager;

     public AtividadeService(){
        String persistenceUnitName = "SADEPU";
        this.simpleEntityManager =  new SimpleEntityManager(persistenceUnitName);
        dao = new AtividadeDao(simpleEntityManager.getEntityManager());
    }

    public Atividade save(Atividade atividade) {
        try {
            simpleEntityManager.beginTransaction();
            atividade.validate();
            dao.save(atividade);
            simpleEntityManager.commit();
            return atividade;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return null;
    }

    public Atividade update(Atividade atividade) {
        try {
            simpleEntityManager.beginTransaction();
            atividade.validate();
            dao.update(atividade);
            simpleEntityManager.commit();
            return atividade;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return null;
    }

    public boolean delete(Atividade atividade) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(atividade);
            simpleEntityManager.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return false;
    }

    public List<Atividade> list() {
        return dao.list();
    }
    public Atividade get(Long idAtividade){        
        return dao.get(idAtividade);
    }    
}

