package com.great.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.BuildingDao;
import com.great.cms.db.dao.DayDao;
import com.great.cms.db.dao.RoomDao;
import com.great.cms.db.entity.Building;
import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.MainRoutine;
import com.great.cms.db.entity.Room;
import com.great.cms.db.entity.Teaches;
import com.great.cms.service.DepartmentService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.MainRoutineService;
import com.great.cms.service.RoomService;
import com.great.cms.service.TeacherService;

@Service("RoomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;

	@Autowired
	BuildingDao buildingDao;

	@Autowired
	MainRoutineService mainRoutineService;

	@Autowired
	DepartmentService deptService;

	@Autowired
	ExamCommitteeService examCommitteService;

	@Autowired
	TeacherService teacherService;

	@Autowired
	DayDao dayDao;

	@Override
	public List<Room> getRoomListByDeptId(Department deptId) {
		// TODO Auto-generated method stub
		List<Room> roomList = this.roomDao.getRoomListByDeptId(deptId);
		return roomList;
	}

	@Override
	public void deleteByRoomId(Integer roomId) {

		this.roomDao.deleteById(roomId);

	}

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub

		this.roomDao.save(room);
	}

	@Override
	public void updateRoom(Room room) {
		// TODO Auto-generated method stub

		this.roomDao.update(room);
	}

	@Override
	public Room getRoomByRoomId(Integer roomId) {

		Room room = roomDao.getRoomById(roomId);
		return room;
	}

	@Override
	public List<Building> getBuildings() {

		return buildingDao.findAll();
	}

	@Override
	public List<Room> getAvailableRooms(int dept, int day, int startTime, int com1, int com2, int com3, int com4,
			int currentSemester, int mainRoutineId, int teachesId) {

		System.out.println("INSIDE ROOMSERVICE..... MAIN ROUTINE ID: " + mainRoutineId + " TEACHES ID: " + teachesId);

		Department department = deptService.getDeptById(dept);

		int generalTypeId = 0;

		if (mainRoutineId > 0) {

			MainRoutine mainRoutine = mainRoutineService.getRoutineById(mainRoutineId);
			if (mainRoutine != null)
				generalTypeId = mainRoutine.getTeachesId().getCourseId().getGeneralTypeId().getGeneralTypeId();

		} else {

			Teaches teaches = teacherService.getTeachesById(teachesId);
			if (teaches != null)
				generalTypeId = teaches.getCourseId().getGeneralTypeId().getGeneralTypeId();
		}

		Day dayInput = dayDao.findById(day);

		List<Room> rooms = this.getRoomListByDeptId(department);
		int flag = 0;
		int max = 1000;

		List<MainRoutine> currentRoutine = mainRoutineService.getRoutineForRooms(department, dayInput,
				examCommitteService.getExamCommitteeById(currentSemester));

		if (currentRoutine != null) {

			for (MainRoutine routine : currentRoutine) {

				if (routine.getMainRoutineId() == mainRoutineId) {

					continue;
				}

				if (routine.getStartTime() > startTime) {

					int time = routine.getStartTime() - startTime;

					if (time < max) {
						max = time;
					}

				}

			}
		}

		System.out.println("\n\nMAX TIME IS:...." + max + "\n\n");

		List<MainRoutine> routine1 = mainRoutineService.getRoutineForRooms(department, dayInput,
				examCommitteService.getExamCommitteeById(com1));
		System.out.println("Routine 1: " + routine1 + " ExamCommitteeId: " + com1);

		List<MainRoutine> routine2 = mainRoutineService.getRoutineForRooms(department, dayInput,
				examCommitteService.getExamCommitteeById(com2));
		System.out.println("Routine 2: " + routine2 + " ExamCommitteeId: " + com2);

		List<MainRoutine> routine3 = mainRoutineService.getRoutineForRooms(department, dayInput,
				examCommitteService.getExamCommitteeById(com3));
		System.out.println("Routine 3: " + routine3 + " ExamCommitteeId: " + com3);

		List<MainRoutine> routine4 = mainRoutineService.getRoutineForRooms(department, dayInput,
				examCommitteService.getExamCommitteeById(com4));
		System.out.println("Routine 4: " + routine4 + " ExamCommitteeId: " + com4);

		for (Room room : rooms) {

			if (generalTypeId != room.getGeneralTypeId().getGeneralTypeId()) {

				room.setHour(-200);
				continue;
			}

			flag = 0;
			if (routine1 != null) {

				for (MainRoutine routine : routine1) {

					if (routine.getMainRoutineId() == mainRoutineId) {

						continue;
					}

					if (routine.getRoomId().getRoomId() == room.getRoomId()) {

						flag = 1;

						if (startTime >= routine.getStartTime() && startTime < routine.getEndTime()) {

							room.setHour(-200);
							break;

						} else if (routine.getStartTime() > startTime
								&& (routine.getStartTime() - startTime) < room.getHour()) {

							if ((routine.getStartTime() - startTime) < max) {

								room.setHour(routine.getStartTime() - startTime);

							} else {

								room.setHour(max);
							}

						} else if (routine.getEndTime() <= startTime && (17 - startTime) < room.getHour()) {

							if ((17 - startTime) < max) {

								room.setHour(17 - startTime);

							} else {

								room.setHour(max);
							}

						}

					}
				}
			}

			if (routine2 != null) {

				for (MainRoutine routine : routine2) {

					if (routine.getMainRoutineId() == mainRoutineId) {

						continue;
					}

					if (routine.getRoomId().getRoomId() == room.getRoomId()) {

						flag = 1;

						if (startTime >= routine.getStartTime() && startTime < routine.getEndTime()) {

							room.setHour(-200);
							break;

						} else if (routine.getStartTime() > startTime
								&& (routine.getStartTime() - startTime) < room.getHour()) {

							if ((routine.getStartTime() - startTime) < max) {

								room.setHour(routine.getStartTime() - startTime);

							} else {

								room.setHour(max);
							}

						} else if (routine.getEndTime() <= startTime && (17 - startTime) < room.getHour()) {

							if ((17 - startTime) < max) {

								room.setHour(17 - startTime);

							} else {

								room.setHour(max);
							}

						}

					}

				}
			}

			if (routine3 != null) {

				for (MainRoutine routine : routine3) {

					if (routine.getMainRoutineId() == mainRoutineId) {

						continue;
					}

					if (routine.getRoomId().getRoomId() == room.getRoomId()) {

						flag = 1;

						if (startTime >= routine.getStartTime() && startTime < routine.getEndTime()) {

							room.setHour(-200);
							break;

						} else if (routine.getStartTime() > startTime
								&& (routine.getStartTime() - startTime) < room.getHour()) {

							if ((routine.getStartTime() - startTime) < max) {

								room.setHour(routine.getStartTime() - startTime);

							} else {

								room.setHour(max);
							}

						} else if (routine.getEndTime() <= startTime && (17 - startTime) < room.getHour()) {

							if ((17 - startTime) < max) {

								room.setHour(17 - startTime);

							} else {

								room.setHour(max);
							}

						}

					}

				}
			}

			if (routine4 != null) {

				for (MainRoutine routine : routine4) {

					if (routine.getMainRoutineId() == mainRoutineId) {

						continue;
					}

					if (routine.getRoomId().getRoomId() == room.getRoomId()) {

						flag = 1;

						if (startTime >= routine.getStartTime() && startTime < routine.getEndTime()) {

							room.setHour(-200);
							break;

						} else if (routine.getStartTime() > startTime
								&& (routine.getStartTime() - startTime) < room.getHour()) {

							if ((routine.getStartTime() - startTime) < max) {

								room.setHour(routine.getStartTime() - startTime);

							} else {

								room.setHour(max);
							}

						} else if (routine.getEndTime() <= startTime && (17 - startTime) < room.getHour()) {

							if ((17 - startTime) < max) {

								room.setHour(17 - startTime);

							} else {

								room.setHour(max);
							}

						}

					}

				}
			}

			if (flag == 0) {

				if ((17 - startTime) < max) {

					room.setHour(17 - startTime);

				} else {

					room.setHour(max);
				}
			}

		}

		for (Room room : rooms) {
			System.out.println(room.getHour());
		}

		return rooms;
	}

	@Override
	public List<Room> getTheoryRoomsByDept(Department dept) {

		return roomDao.getTheoryRoomsByDept(dept);
	}

	@Override
	public List<Room> getLabRoomsByDept(Department dept) {

		return roomDao.getLabRoomsByDept(dept);
	}

}
