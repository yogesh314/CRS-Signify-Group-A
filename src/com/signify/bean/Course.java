/**
 * 
 */
package com.signify.bean;

/**
 * @author prati
 *
 */
public class Course {
private String courseCode;
private String Name;
private boolean isOffered;
private String instructor;

public String getCourseCode() {
	return courseCode;
}
public void setCourseCode(String courseCode) {
	this.courseCode = courseCode;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public boolean isOffered() {
	return isOffered;
}
public void setOffered(boolean isOffered) {
	this.isOffered = isOffered;
}
public String getInstructor() {
	return instructor;
}
public void setInstructor(String instructor) {
	this.instructor = instructor;
}

}
