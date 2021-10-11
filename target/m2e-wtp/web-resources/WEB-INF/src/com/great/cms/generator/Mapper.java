/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapper {

	private Map<Integer, CourseInfo> course;
	private Map<Integer, RoomInfo> classRoom;
	private Map<Integer, RoomInfo> labRoom;
	private Map<Integer, TeacherInfo> teacher;
	private Map<String, Integer> TeacherId;
	private Map<String, Integer> CourseId;

	private final String dirCourse = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/course.txt";
	private final String dirTeacher = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/teacher.txt";
	public static String dirClassRoom = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/theory.txt";
	public static String dirLabRoom = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/lab.txt";

	private Scanner inp;
	private int id, size;
	private Input in = new Input();
	private String Name;

	public Mapper() {

		CourseId = new HashMap<>();
		TeacherId = new HashMap<>();
		classRoom = new HashMap<>();
		labRoom = new HashMap<>();

	}

	public void mapLabRoom() {

		Input.dir = dirLabRoom;
		labRoom = MapRoom(labRoom);

	}

	public void mapClassRoom() {

		Input.dir = dirClassRoom;
		classRoom = MapRoom(classRoom);

	}

	public int getLabNum() {

		Input.dir = dirLabRoom;
		inp = in.inp();
		return inp.nextInt();
	}

	private Map<Integer, RoomInfo> MapRoom(Map<Integer, RoomInfo> room) {

		inp = in.inp();
		size = inp.nextInt();
		for (int i = 0; i < size; i++) {
			id = inp.nextInt();
			room.put(id, new RoomInfo(id, inp.next()));
		}
		return room;
	}

	public void MapCourse() {

		Input.dir = dirCourse;
		inp = in.inp();
		course = new HashMap<>();
		course.clear();
		size = inp.nextInt();
		// System.out.println(size);
		for (int i = 0; i < size; i++) {
			id = inp.nextInt();
			Name = inp.next();
			course.put(id, new CourseInfo(id, Name, inp.nextInt(), inp.nextInt(), inp.nextInt(), inp.nextInt()));
			CourseId.put(Name, id);
		}
	}

	public void MapTeacher() {

		Input.dir = dirTeacher;
		inp = in.inp();
		teacher = new HashMap<>();
		teacher.clear();
		size = inp.nextInt();
		// System.out.println(size);
		for (int i = 0; i < size; i++) {

			id = inp.nextInt();
			Name = inp.next();
			teacher.put(id, new TeacherInfo(id, Name));
			TeacherId.put(Name, id);
		}
	}

	public String getClassRoomName(int id) {

		if (this.classRoom.get(id) == null)
			return null;
		else
			return this.classRoom.get(id).getRoomName();
	}

	public String getLabRoomName(int id) {

		if (this.labRoom.get(id) == null)
			return null;
		else
			return this.labRoom.get(id).getRoomName();
	}

	public int getTeacherId(String Name) {

		if (this.TeacherId.get(Name) == null)
			return -1;
		else
			return this.TeacherId.get(Name);
	}

	public int getCourseId(String Name) {

		if (CourseId.get(Name) == null)
			return -1;
		else
			return this.CourseId.get(Name);
	}

	public String getTeacherName(int teacherId) {

		if (this.teacher.get(teacherId) == null)
			return null;
		else
			return this.teacher.get(teacherId).getTeacherName();
	}

	public String getCourseName(int courseId) {

		if (this.course.get(courseId) == null)
			return null;
		else
			return this.course.get(courseId).getCourseName();
	}

	public int getNumOfClassInWeek(int courseId) {

		if (this.course.get(courseId) == null)
			return -1;
		else
			return this.course.get(courseId).getNumOfClassInWeek();
	}

	public int getClassHour(int courseId) {

		if (this.course.get(courseId) == null)
			return -1;
		else
			return this.course.get(courseId).getClassHour();
	}

	public int getIsLab(int courseId) {

		if (this.course.get(courseId) == null)
			return -1;
		else
			return this.course.get(courseId).getIslab();
	}

	public int getBatch(int courseId) {

		if (this.course.get(courseId) == null)
			return -1;
		else
			return this.course.get(courseId).getBatch();
	}
}
