package main.com.sade.service;

import main.com.sade.dao.VersaoDao;
import main.com.sade.manager.SimpleEntityManager;
import main.com.sade.model.Versao;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class VersaoService {
    
    private VersaoDao dao;
    private SimpleEntityManager simpleEntityManager;

    public VersaoService(SimpleEntityManager simpleEntityManager) {
        this.simpleEntityManager = simpleEntityManager;
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
