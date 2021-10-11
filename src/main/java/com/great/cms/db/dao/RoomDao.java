package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Room;

public interface RoomDao extends GenericDao<Room, Integer> {

	Integer getRoomNumById(Integer roomId);

	Integer getBuildingIdByRoomId(Integer roomId);

	List<Room> getRoomListByDeptId(Department deptId);

	Room getRoomById(Integer roomId);

	List<Room> getTheoryRoomsByDept(Department dept);

	List<Room> getLabRoomsByDept(Department dept);

}
