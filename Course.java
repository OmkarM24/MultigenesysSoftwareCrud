package com.example.MultigenesysSoftwareCrud.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;
	private String courseTitle;
	private Date coursestartDate;
	private Date courseendDate;
	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Date getCoursestartDate() {
		return coursestartDate;
	}
	public void setCoursestartDate(Date coursestartDate) {
		this.coursestartDate = coursestartDate;
	}
	public Date getCourseendDate() {
		return courseendDate;
	}
	public void setCourseendDate(Date courseendDate) {
		this.courseendDate = courseendDate;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", coursestartDate=" + coursestartDate
				+ ", courseendDate=" + courseendDate + "]";
	}
}
