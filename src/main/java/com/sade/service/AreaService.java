package com.sade.service;

import com.sade.dao.AreaDao;
import com.sade.model.Area;

import java.util.List;

/**
 * @author jullianonascimento
 */
public class AreaService {

	private AreaDao dao;

	public AreaService() {

		dao = new AreaDao();
	}

	public Area save(Area area) {

		return dao.save(area);
	}

	public Area update(Area area) {

		return dao.update(area);
	}

	public boolean delete(Area area) {

		return dao.delete(area);
	}

	public List<Area> list() {

		return dao.list();
	}

	public Area get(Long idArea) {

		return dao.get(idArea);
	}
}
