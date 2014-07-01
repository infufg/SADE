package com.sade.service;

import com.sade.dao.AreaDao;
import com.sade.manager.SimpleEntityManager;
import com.sade.model.Area;

import java.util.List;

/**
 * @author jullianonascimento
 */
public class AreaService {

	private AreaDao dao;
	private SimpleEntityManager simpleEntityManager;

	public AreaService() {

		String persistenceUnitName = "SADEPU";
		this.simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
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

	public Area get(Long idArea) {

		return dao.get(idArea);
	}
}
