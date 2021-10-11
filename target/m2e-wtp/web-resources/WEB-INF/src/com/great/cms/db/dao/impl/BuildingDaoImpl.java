package com.great.cms.db.dao.impl;

import javax.persistence.EntityExistsException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.BuildingDao;
import com.great.cms.db.entity.Building;

@Repository("BuildingDao")
public class BuildingDaoImpl extends GenericDaoImpl<Building, Integer>
		implements BuildingDao {

	@Autowired
	Building building;

	public BuildingDaoImpl() {
		super(Building.class);
	}

	@Override
	public String createBuilding(String buildingName, String buildingCode) {
		// TODO Auto-generated method stub
		building.setBuildingCode(buildingCode);
		building.setBuildingName(buildingName);

		try {
			this.save(building);
		} catch (EntityExistsException ex) {
			return "Entry already exists";
		}

		return "Created Successfully";
	}

	@Override
	public void deleteall() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("DELETE FROM Building");
		query.executeUpdate();

	}

	@Override
	public String getBuildingCodeById(Integer buildingId) {
		// TODO Auto-generated method stub

		return ((String) this.em.createNamedQuery("Building.findByBuildingId")
				.getResultList().get(2));
	}
}
