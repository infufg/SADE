package com.sade.service;

import com.sade.dao.VersaoDao;
import com.sade.manager.SimpleEntityManager;
import com.sade.model.Versao;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class VersaoService {
    
    private VersaoDao dao;
    private SimpleEntityManager simpleEntityManager;

     public VersaoService(){
        String persistenceUnitName = "SADEPU";
        this.simpleEntityManager =  new SimpleEntityManager(persistenceUnitName);
        dao = new VersaoDao(simpleEntityManager.getEntityManager());
    }

    public Versao save(Versao versao) {
        try {
            simpleEntityManager.beginTransaction();
            versao.validate();
            dao.save(versao);
            simpleEntityManager.commit();
            return versao;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return null;
    }

    public Versao update(Versao versao) {
        try {
            simpleEntityManager.beginTransaction();
            versao.validate();
            dao.update(versao);
            simpleEntityManager.commit();
            return versao;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return null;
    }

    public boolean delete(Versao versao) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(versao);
            simpleEntityManager.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return false;
    }

    public List<Versao> list() {
        return dao.list();
    }
}
