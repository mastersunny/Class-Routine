package com.great.cms.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by phenix on 2/24/15.
 */
public class OutputProcessor {
	private Random rand = new Random();
	Population solution;
	public static String dirClassRoom = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/theory.txt",
			dirLabRoom = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/lab.txt";

	private String dirOutputFile = "/Volumes/Data/STS/greatcms/src/main/webapp/resources/files/out.txt";

	int total_solution;
	Mapper map = new Mapper();

	public OutputProcessor(Population solution, int total_solution) throws IOException {
		this.solution = solution;
		this.total_solution = total_solution;
		Input.dir = dirClassRoom;
		Input.dir = dirLabRoom;
		map.MapCourse();
		map.MapTeacher();
		map.mapClassRoom();
		map.mapLabRoom();
		printFile();
	}

	public void printFile() throws IOException {
		File file = new File(dirOutputFile);
		if (!file.exists())
			file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		String output;
		for (int i = 0; i < solution.chromosome.length; i++) {
			if (solution.chromosome[i] != null) {
				output = "";
				String tmpString = solution.chromosome[i];

				output += Integer.toString(StringProcessor.getBatchId(tmpString));
				output += ",";
				output += Integer.toString(Population.reverseIndex[i][0]) + ","
						+ map.getCourseName(StringProcessor.getSubjectId(tmpString)) + ",";
				if (map.getIsLab(StringProcessor.getSubjectId(tmpString)) == 1) {
					output += map.getLabRoomName(Population.reverseIndex[i][1]) + ",";
				} else {
					output += map.getClassRoomName(Population.reverseIndex[i][1]) + ",";

				}
				output += map.getTeacherName(StringProcessor.findAllTeacher(tmpString,
						rand.nextInt(StringProcessor.getTeacherCount(tmpString)))) + ",";
				output += (Population.reverseIndex[i][2] + 8) + ","
						+ (Population.reverseIndex[i][2] + 8 + StringProcessor.getClassHour(tmpString));
				bufferedWriter.write(output);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}
		bufferedWriter.close();
	}
}
