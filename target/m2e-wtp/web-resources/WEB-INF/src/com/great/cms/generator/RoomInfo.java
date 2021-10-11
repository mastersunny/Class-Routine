/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

/**
 *
 * @author Saif_sust
 */
public class RoomInfo {
	
	private String Name;
	private int Id;

	public RoomInfo(int roomId, String Name) {
		
		this.Id = roomId;
		this.Name = Name;
	}

	public String getRoomName() {
		return this.Name;
	}

	public int getRoomId() {
		return this.Id;
	}

}
