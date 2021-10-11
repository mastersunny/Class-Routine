package com.great.cms.db.dao;

import com.great.cms.db.entity.Building;

public interface BuildingDao extends GenericDao<Building, Integer> {
	
	public String createBuilding(String buildingName , String buildingCode);
	public void deleteall();
	public String getBuildingCodeById(Integer buildingId);
}
