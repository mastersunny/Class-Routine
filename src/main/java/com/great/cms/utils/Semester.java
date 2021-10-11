package com.great.cms.utils;

public class Semester {

	public static Integer getCurrentSemester(String studentReg) {

		int year = (Session.getCurrentSession() - Session
		.getSessionById(studentReg));
		int month = Session.getMonth();
		switch (month) {

		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		return Integer.parseInt((Integer.toString(year) + "1"));
		default:
		return Integer.parseInt((Integer.toString(year) + "2"));

		}

		}


		public static String getDeptCodeByUserId(String code) {

		switch (code) {
		case "33":
		return "CSE";
		case "31":
		return "MAT";
		default:
		return "null";
		}
		}
}
