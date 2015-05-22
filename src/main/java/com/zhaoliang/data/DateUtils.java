package com.zhaoliang.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	public static void main(String[] args) {
		DateFormat format=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss  zZ(zzzzz)",new Locale("China"));
		//format.setTimeZone(TimeZone.getTimeZone("CTS"));
		System.out.println(format.format(new Date()).toString());
	}
}
