package com.javapages.sohan.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate() {

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "year=" + year + "\nmonth=" + month + "\nday=" + day;
	}

}
