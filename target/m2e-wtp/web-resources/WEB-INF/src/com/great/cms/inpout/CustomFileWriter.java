package com.great.cms.inpout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.great.cms.controller.bean.CourseAndTeacher;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Room;
import com.great.cms.db.entity.Teacher;

@Component
public class CustomFileWriter {

	private int roomCount;

	public void writeCourse(List<Course> courses) {

		try {

			File file = new File("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/course.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			System.err.println(file.getAbsoluteFile());

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			int count = 1;

			bw.append(String.valueOf(courses.size()));
			bw.append("\n");

			for (Course course : courses) {

				String s = "";

				s += String.format("%02d", count);
				s += " ";
				s += course.getCourseId();
				s += " ";

				s  =  getTimeAndDay(s, course.getGeneralTypeId().getGeneralTypeId(), course.getCredit().doubleValue());

				s += " ";
				s += course.getSemester();
				s += " ";
				s += course.getGeneralTypeId().getGeneralTypeId() - 1;

				bw.append(s);
				bw.append("\n");
				count++;

			}

			bw.close();

			System.out.println("Course writing done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getTimeAndDay(String s, int typeId, double credit) {

		if (typeId == 1) {

			if (credit == 1.0) {

				s += 1;
				s += " ";
				s += 1;

			} else if (credit == 2.0) {

				s += 1;
				s += " ";
				s += 2;

			} else if (credit == 3.0) {

				s += 1;
				s += " ";
				s += 3;

			}

		} else if (typeId == 2) {

			if (credit == 1.0) {

				s += 1;
				s += " ";
				s += 1;

			} else if (credit == 1.5) {

				s += 3;
				s += " ";
				s += 1;

			} else if (credit == 2) {

				s += 2;
				s += " ";
				s += 2;

			} else if (credit == 3) {

				s += 3;
				s += " ";
				s += 2;
			}

		}
		
		return s;
	}

	public void writeTeacher(List<Teacher> teachers) {

		try {

			File file = new File("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/teacher.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			System.err.println(file.getAbsoluteFile());

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			int count = 1;

			bw.append(String.valueOf(teachers.size()));
			bw.append("\n");

			for (Teacher teacher : teachers) {

				String s = "";

				s += String.format("%02d", count);
				s += " ";
				s += teacher.getInstructorId();

				bw.append(s);
				bw.append("\n");
				count++;

			}

			bw.close();

			System.out.println("Teacher writing done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeTheoryRoom(List<Room> theoryRooms) {
		
		roomCount = 0;

		try {

			File file = new File("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/theory.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			System.err.println(file.getAbsoluteFile());

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.append(String.valueOf(theoryRooms.size()));
			bw.append("\n");

			for (Room room : theoryRooms) {

				if (room.getGeneralTypeId().getGeneralTypeId() == 2) {
					continue;
				}

				String s = "";

				s += roomCount;
				s += " ";
				s += room.getRoomId();

				bw.append(s);
				bw.append("\n");
				roomCount++;

			}

			bw.close();

			System.out.println("Theory writing done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeLabRoom(List<Room> labRooms) {
		
		try {

			File file = new File("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/lab.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			System.err.println(file.getAbsoluteFile());

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.append(String.valueOf(labRooms.size()));
			bw.append("\n");

			for (Room room : labRooms) {

				if (room.getGeneralTypeId().getGeneralTypeId() == 1) {
					continue;
				}

				String s = "";

				s += roomCount;
				s += " ";
				s += room.getRoomId();

				bw.append(s);
				bw.append("\n");
				roomCount++;

			}

			bw.close();

			System.out.println("Lab writing done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeTeaches(List<CourseAndTeacher> teachesList) {
		
		try {

			File file = new File("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/teaches.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			System.err.println(file.getAbsoluteFile());

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.append(String.valueOf(teachesList.size()));
			bw.append("\n");
			
			int count = 1;

			for (CourseAndTeacher teaches : teachesList) {

				String s = "";
				
				s += teaches.getCourseId();
				s += " ";
				s += teaches.getInstructorId();

				bw.append(s);
				bw.append("\n");
				count++;

			}

			bw.close();

			System.out.println("Teaches writing done");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
