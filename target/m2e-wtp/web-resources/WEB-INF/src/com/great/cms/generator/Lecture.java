/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Saif_sust
 */
public final class Lecture {

	private File file;
	private FileWriter fileWriter;

	private Input in = new Input();
	private Mapper map = new Mapper();

	private ArrayList<String> classList;
	private Scanner inp, inp2;
	private BufferedWriter buffer;
	private int size, courseId, teacherId, NumOfClassInWeek;
	private String tempStr, inpStr, NumOfteacher = "01";

	public Lecture() {
		map.MapCourse();
		map.MapTeacher();
		makeLectureWithoutFixedClass();
		writeClassInformation();
	}

	/*
	 * 
	 * 
	 * buffer
	 */
	public BufferedWriter getBuffer(String dir) {
		try {

			file = new File(dir);
			file.createNewFile();
			fileWriter = new FileWriter(file);
			buffer = new BufferedWriter(fileWriter);
			return buffer;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public void writeClassInformation() {
		try {

			int labNum, classNum;
			Input.dir = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/theory.txt";
			inp = in.inp();
			classNum = inp.nextInt();
			Input.dir = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/lab.txt";
			inp2 = in.inp();
			labNum = inp2.nextInt();

			buffer = getBuffer("/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/in.txt");
			buffer.write(Integer.toString(classList.size()));
			buffer.newLine();

			for (int i = 0; i < classList.size(); i++) {
				buffer.write(classList.get(i));
				buffer.newLine();
			}
			// buffer.newLine();
			buffer.write(Integer.toString(0));
			buffer.newLine();
			buffer.write(Integer.toString(classNum + labNum));
			buffer.newLine();
			buffer.write(Integer.toString(labNum));
			buffer.newLine();
			buffer.write(Integer.toString(9));
			buffer.newLine();
			buffer.write(Integer.toString(5));
			buffer.newLine();
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * lecture without fixed issue
	 * 
	 */
	private void makeLectureWithoutFixedClass() {

		classList = new ArrayList<>();
		classList.clear();
		Input.dir = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/teaches.txt";
		inp = in.inp();

		size = inp.nextInt();

		for (int i = 0; i < size; i++) {
			tempStr = null;

			tempStr = "00";

			inpStr = inp.next();

			NumOfClassInWeek = map.getNumOfClassInWeek(map.getCourseId(inpStr));

			if (map.getCourseId(inpStr) / 10 == 0)
				tempStr += "0" + Integer.toString(map.getCourseId(inpStr)) + NumOfteacher
						+ Integer.toString(map.getBatch(map.getCourseId(inpStr))) + "0"
						+ Integer.toString(map.getClassHour(map.getCourseId(inpStr))) + "0"
						+ Integer.toString(map.getIsLab(map.getCourseId(inpStr)));
			else
				tempStr += Integer.toString(map.getCourseId(inpStr)) + NumOfteacher
						+ Integer.toString(map.getBatch(map.getCourseId(inpStr))) + "0"
						+ Integer.toString(map.getClassHour(map.getCourseId(inpStr))) + "0"
						+ Integer.toString(map.getIsLab(map.getCourseId(inpStr)));

			inpStr = inp.next();

			if (map.getTeacherId(inpStr) / 10 == 0) {
				tempStr += Integer.toString(0) + Integer.toString(map.getTeacherId(inpStr));
			} else
				tempStr += Integer.toString(map.getTeacherId(inpStr));

			for (int k = 0; k < NumOfClassInWeek; k++) {
				classList.add(tempStr);
			}

		}

		for (int i = 0; i < classList.size(); i++) {
			System.out.println(classList.get(i));
		}
	}

}
