package com.great.cms.controller.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainRoutineBean {

	private int startTime;
	private int endTime;
	private int teachesId;
	private int roomId;
	private int deptId;
	private int examCommitteeId;
	private int dayId;

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

	public int getTeachesId() {
		return teachesId;
	}

	public void setTeachesId(int teachesId) {
		this.teachesId = teachesId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getExamCommitteeId() {
		return examCommitteeId;
	}

	public void setExamCommitteeId(int examCommitteeId) {
		this.examCommitteeId = examCommitteeId;
	}

	public int getDayId() {
		return dayId;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	@Override
	public String toString() {
		return "MainRoutineBean [startTime=" + startTime + ", endTime=" + endTime + ", teachesId=" + teachesId
				+ ", roomId=" + roomId + ", deptId=" + deptId + ", examCommitteeId=" + examCommitteeId + ", dayId="
				+ dayId + "]";
	}

}
