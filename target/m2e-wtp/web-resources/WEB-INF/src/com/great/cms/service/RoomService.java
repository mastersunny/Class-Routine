package com.great.cms.service;

import java.util.List;

import org.hibernate.context.CurrentSessionContext;

import com.great.cms.db.entity.Building;
import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.Room;

public interface RoomService {

	public void deleteByRoomId(Integer roomId);

	public void addRoom(Room room);

	public void updateRoom(Room room);

	public Room getRoomByRoomId(Integer roomId);

	public List<Room> getRoomListByDeptId(Department deptId);

	public List<Building> getBuildings();

	List<Room> getAvailableRooms(int dept, int day, int startTime, int com1, int com2, int com3, int com4,
			int CurrentSemester, int mainRoutineId, int teachesId);

	List<Room> getTheoryRoomsByDept(Department dept);

	List<Room> getLabRoomsByDept(Department dept);

}
