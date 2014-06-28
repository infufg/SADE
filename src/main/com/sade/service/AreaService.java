package main.com.sade.service;

import main.com.sade.dao.AreaDao;
import main.com.sade.manager.SimpleEntityManager;
import main.com.sade.model.Area;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class AreaService {

    private AreaDao dao;
    private SimpleEntityManager simpleEntityManager;

    public AreaService(SimpleEntityManager simpleEntityManager) {
        this.simpleEntityManager = simpleEntityManager;
        dao = new AreaDao(simpleEntityManager.getEntityManager());
    }

    public Area save(Area area) {
        try {
            simpleEntityManager.beginTransaction();
            area.validate();
            dao.save(area);
            simpleEntityManager.commit();
            return area;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return null;
    }

    public Area update(Area area) {
        try {
            simpleEntityManager.beginTransaction();
            area.validate();
            dao.update(area);
            simpleEntityManager.commit();
            return area;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return null;
    }

    public boolean delete(Area area) {
        try {
            simpleEntityManager.beginTransaction();
            dao.delete(area);
            simpleEntityManager.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }

        return false;
    }

    public List<Area> list() {
        return dao.list();
    }
}
