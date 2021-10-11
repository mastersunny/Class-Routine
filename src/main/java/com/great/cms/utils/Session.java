package com.great.cms.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Session {

	public static Integer getCurrentSession() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(Calendar.getInstance().getTime());

		String year = (String) timeStamp.substring(0, 4);
		int session = Integer.parseInt(year);

		return session;
	}

	public static Integer getSessionById(String studentReg) {
		String studentSession = studentReg.substring(0, 4);

		return (Integer.parseInt(studentSession));
	}

	public static Integer getMonth() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(Calendar.getInstance().getTime());

		String month = (String) timeStamp.substring(4, 6);

		return (Integer.parseInt(month));
	}
}
