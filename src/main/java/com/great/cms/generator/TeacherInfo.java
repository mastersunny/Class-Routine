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
public class TeacherInfo {

	private String Name;
	private int TeacherId;

	public TeacherInfo(int TeacherId, String Name) {

		this.TeacherId = TeacherId;
		this.Name = Name;
	}

	public String getTeacherName() {
		return this.Name;
	}

	public int getTeacherId() {
		return this.TeacherId;
	}
}
