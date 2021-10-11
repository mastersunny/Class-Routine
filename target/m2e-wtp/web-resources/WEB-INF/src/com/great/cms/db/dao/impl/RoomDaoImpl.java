package com.great.cms.db.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.RoomDao;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Room;

@Repository("RoomDao")
public class RoomDaoImpl extends GenericDaoImpl<Room, Integer> implements RoomDao {

	@Override
	public Integer getRoomNumById(Integer roomId) {
		// TODO Auto-generated method stub
		Query query = this.em.createNamedQuery("Room.findByRoomId");
		Integer roomNum = (Integer) query.getResultList().get(1);
		return roomNum;
	}

	@Override
	public Integer getBuildingIdByRoomId(Integer roomId) {
		// TODO Auto-generated method stub
		Query query = this.em.createNamedQuery("Room.findByRoomId");
		Integer buildingId = (Integer) query.getResultList().get(3);
		return buildingId;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Room> getRoomListByDeptId(Department deptId) {

		Query query = this.em.createQuery("from Room r where r.deptId = :deptId");
		query.setParameter("deptId", deptId);

		List<Room> rooms = query.getResultList();

		return rooms;
	}

	@Override
	public Room getRoomById(Integer roomId) {

		Query query = this.em.createQuery("from Room r where r.roomId =:roomId");
		query.setParameter("roomId", roomId);
		List<Room> room = query.getResultList();
		if (room == null || room.isEmpty() || room.size() > 1)
			return null;
		return room.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Room> getTheoryRoomsByDept(Department dept) {

		Query query = this.em.createQuery("from Room r where r.deptId = :deptId and r.generalTypeId = 1");
		query.setParameter("deptId", dept);

		List<Room> rooms = query.getResultList();

		return rooms;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Room> getLabRoomsByDept(Department dept) {

		Query query = this.em.createQuery("from Room r where r.deptId = :deptId and r.generalTypeId = 2");
		query.setParameter("deptId", dept);

		List<Room> rooms = query.getResultList();

		return rooms;
	}

}
