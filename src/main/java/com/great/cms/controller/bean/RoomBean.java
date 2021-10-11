package com.great.cms.controller.bean;


public class RoomBean {

	private int roomNum;
	private int roomId;
	private boolean labRoom;
	private String generalType;
	private String buildingName;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public boolean isLabRoom() {
		return labRoom;
	}

	public void setLabRoom(boolean labRoom) {
		this.labRoom = labRoom;
	}

	public String getGeneralType() {
		return generalType;
	}

	public void setGeneralType(String generalType) {
		this.generalType = generalType;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "RoomBean [roomNum=" + roomNum + ", roomId=" + roomId
				+ ", labRoom=" + labRoom + ", generalType=" + generalType
				+ ", buildingName=" + buildingName + "]";
	}
	
	

}
