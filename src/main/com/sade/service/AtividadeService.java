package main.com.sade.service;

import main.com.sade.dao.AtividadeDao;
import main.com.sade.manager.SimpleEntityManager;
import main.com.sade.model.Atividade;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class AtividadeService {
    
    private AtividadeDao dao;
    private SimpleEntityManager simpleEntityManager;

    public AtividadeService(SimpleEntityManager simpleEntityManager) {
        this.simpleEntityManager = simpleEntityManager;
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
}

