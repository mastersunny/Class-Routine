package com.great.cms.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.great.cms.db.dao.BuildingDao;
import com.great.cms.db.dao.RoomDao;
import com.great.cms.db.entity.Day;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.Room;
import com.great.cms.db.entity.Teaches;
import com.great.cms.service.CourseService;
import com.great.cms.service.TeacherService;
import com.great.cms.service.TeachesService;

public class Routine {

	private Integer mainRoutineId;
	private Day dayId;
	private ExamCommittee examCommitteeId;
	private int startTime;
	private int endTime;
	private Teaches teachesId;
	private Room roomId;

	@Autowired
	RoomDao roomDao;
	@Autowired
	BuildingDao buildingDao;
	@Autowired
	CourseService courseService;
	@Autowired
	TeachesService teachesService;
	@Autowired
	TeacherService teacherService;

	public Routine(Integer mainRoutineId, Day dayId,
			ExamCommittee examCommitteeId, int startTime, int endTime,
			Teaches teachesId, Room roomId) {
		this.mainRoutineId = mainRoutineId;
		this.dayId = dayId;
		this.examCommitteeId = examCommitteeId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.teachesId = teachesId;
		this.roomId = roomId;
	}

	public Integer getMainRoutineId() {
		return mainRoutineId;
	}

	public void setMainRoutineId(Integer mainRoutineId) {
		this.mainRoutineId = mainRoutineId;
	}

	public Day getDayId() {
		return dayId;
	}

	public void setDayId(Day dayId) {
		this.dayId = dayId;
	}

	public ExamCommittee getExamCommitteeId() {
		return examCommitteeId;
	}

	public void setExamCommitteeId(ExamCommittee examCommitteeId) {
		this.examCommitteeId = examCommitteeId;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {

		Integer roomId = (Integer) (this.roomId.getRoomId());
		Integer buildingId = (Integer) roomDao.getBuildingIdByRoomId(roomId);
		String roomNumber = roomDao.getRoomNumById(roomId) + ":"
				+ buildingDao.getBuildingCodeById(buildingId);

		return roomNumber;
	}

	public String getCourseCode() {

		Integer courseId = this.teachesService.getCourseIdByTeachesId(teachesId
				.getTeachesId());

		return ((String) courseService.getCourseCodeById(courseId));
	}

	public String getTeacherCode() {
		Long instructorId = (Long) this.teachesService
				.getTeacherIdByTeachesId(teachesId.getTeachesId());
		return ((String) teacherService.getTeacherCodeById(instructorId));
	}
}
