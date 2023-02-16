/**
 * 
 */
package com.signify.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prati
 *
 */
public class GradeCard {
private int studentId;
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public int getSemester() {
	return semester;
}
public void setSemester(int semester) {
	this.semester = semester;
}
public float getCpi() {
	return cpi;
}
public void setCpi(float cpi) {
	this.cpi = cpi;
}
public List<String> getRegisteredCourses() {
	return registeredCourses;
}
public void setRegisteredCourses(List<String> registeredCourses) {
	this.registeredCourses = registeredCourses;
}
private int semester;
private float cpi;
private List<String> registeredCourses=new ArrayList<String>();
}
