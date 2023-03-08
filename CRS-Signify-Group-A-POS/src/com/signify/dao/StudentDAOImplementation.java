/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.signify.bean.Course;
import com.signify.bean.Grades;
import com.signify.bean.OfflinePayment;
import com.signify.bean.OnlinePayment;
import com.signify.bean.Payment;
import com.signify.bean.RegisteredCourse;
import com.signify.bean.Student;
import com.signify.constants.SQLConstants;
import com.signify.exception.CourseLimitExceedException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.SemesterNotRegisteredException;
import com.signify.exception.StudentNotRegisteredException;
import com.signify.utils.DBUtils;

/**
 * @author manoj
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface {
	/** 
	 * Method to register
	 * @param  student
	 * @return void
	 */

	public void register(Student student) {

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt_student = null;
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.REGISTER_USER);
			String doj = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			stmt.setString(1, student.getUserId());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getPassword());
			stmt.setString(4, student.getAddress());
			stmt.setDate(5, Date.valueOf(doj));
			stmt.setInt(6, 1);
			stmt.executeUpdate();
			stmt.close();

			stmt_student = conn.prepareStatement(SQLConstants.REGISTER_STUDENT);
			stmt_student.setString(1, student.getUserId());
			stmt_student.setString(2, student.getStudentId());
			stmt_student.setString(3, student.getName());
			stmt_student.setString(4, student.getBranch());
			stmt_student.setInt(5, student.getAge());
			stmt_student.setString(6, student.getBloodgroup());
			stmt_student.setString(7, student.getFname());
			stmt_student.setString(8, student.getPhnum());
			stmt_student.setInt(9, 0);
			stmt_student.setInt(10, 0);
			stmt_student.setInt(11, 0);
			stmt_student.executeUpdate();
			stmt_student.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * Method to semesterRegister
	 * @param  studentid, sem
	 * @return void
	 */

	public void semesterRegister(String studentid, int sem) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String student_id = "";

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SEMESTER_REGISTRATION);
			stmt.setInt(1, sem);
			stmt.setString(2, studentid);
			int row = stmt.executeUpdate();
			if (row == 0) {
				throw new StudentNotRegisteredException(studentid);
			}
			stmt.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	/** 
	 * Method to semesterRegister
	 * @param  studentid, sem
	 * @return String
	 */
	
	public String getStudentId(String userid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String student_id = "";

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.GET_STUDENT_ID);
			stmt.setString(1, userid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				student_id = rs.getString("studentid");
			}
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student_id;
	}
	
	/** 
	 * Method to getIsApprovedStatus
	 * @param  studentid
	 * @return int
	 */

	public int getIsApprovedStatus(String studentid) {

		Connection conn = null;
		PreparedStatement stmt = null;
		int isapproved = 0;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.GET_ISAPPROVED_STATUS);
			stmt.setString(1, studentid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				isapproved = rs.getInt("isapproved");
			}
			rs.close();
			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isapproved;
	}

	/** 
	 * Method to getAvailableCourses
	 * @param  studentid
	 * @return List<Course>
	 * @throws SemesterNotRegisteredException
	 */
	public List<Course> getAvailableCourses(String studentid) throws SemesterNotRegisteredException {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement smt = null;

		List<Course> ac = new ArrayList<Course>();

		try {

			conn = DBUtils.getConnection();
			smt = conn.prepareStatement(SQLConstants.GET_SEMESTER);
			smt.setString(1, studentid);
			ResultSet rs1 = smt.executeQuery();
			int sem = -1;
			while (rs1.next()) {
				sem = rs1.getInt("semester");
			}
			if (sem == 0) {
				throw new SemesterNotRegisteredException(studentid);
			}

			stmt = conn.prepareStatement(SQLConstants.GET_AVAILABLE_COURSES);
			stmt.setInt(1, sem);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Course c = new Course();
				c.setCourseCode(rs.getString("coursecode"));
				c.setName(rs.getString("coursename"));
				c.setInstructor(rs.getString("instructor"));
				c.setNumStudents(rs.getInt("numstudents"));
				ac.add(c);
			}
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (SemesterNotRegisteredException e) {
			throw new SemesterNotRegisteredException(studentid);
		}
		return ac;
	}

	/** 
	 * Method to AddCourse
	 * @param  studentid,CourseCode,type
	 * @return void
	 * @throws CourseLimitExceedException
	 */
	
	public void addCourse(String studentid, String courseCode, int type) throws CourseLimitExceedException {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;

		PreparedStatement smt1 = null;
		PreparedStatement smt2 = null;

		try {
			conn = DBUtils.getConnection();

			AdminDAOImplementation adi = new AdminDAOImplementation();
			adi.viewCourseDetails(courseCode);

			stmt1 = conn.prepareStatement(SQLConstants.GET_SEMESTER);
			stmt1.setString(1, studentid);
			ResultSet rs1 = stmt1.executeQuery();
			int sem = 0;
			while (rs1.next()) {
				sem = rs1.getInt("semester");
			}

			int c1 = 0, c2 = 0;
			if (type == 1) {
				smt1 = conn.prepareStatement(SQLConstants.GET_NUM_TYPE_1_COURSES);
				smt1.setString(1, studentid);
				ResultSet rs_1 = smt1.executeQuery();
				while (rs_1.next()) {
					c1 = rs_1.getInt("count(*)");
				}
				if (c1 == 4 && type == 1) {
					throw new CourseLimitExceedException(studentid);
				}
			}
			else if (type == 2) {
				smt2 = conn.prepareStatement(SQLConstants.GET_NUM_TYPE_2_COURSES);
				smt2.setString(1, studentid);
				ResultSet rs_2 = smt2.executeQuery();
				while (rs_2.next()) {
					c2 = rs_2.getInt("count(*)");
				}
				if (c2 == 2) {
					throw new CourseLimitExceedException(studentid);
				}
			}

			String sql = "insert into registeredcourse (coursecode, semester, studentId, grade, type) values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseCode);
			stmt.setInt(2, sem);
			stmt.setString(3, studentid);
			stmt.setString(4, "NA");
			stmt.setInt(5, type);
			stmt.executeUpdate();
			stmt.close();

		} catch (CourseLimitExceedException e) {
			throw new CourseLimitExceedException(studentid);
		} catch (SQLException se) {
			System.out.println("\nYOU ARE ALREADY REGISTERED FOR THIS COURSE!\n");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/** 
	 * Method to dropCourse
	 * @param  studentid,CourseId
	 * @return void
	 * @throws CourseNotFoundException
	 */

	public void dropCourse(String studentid, String courseId) throws CourseNotFoundException {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt_1 = null;
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.DELETE_USER_COURSE);
			stmt.setString(1, courseId);
			stmt.setString(2, studentid);
			int row = stmt.executeUpdate();

			if (row == 0) {
				throw new CourseNotFoundException(courseId);
			}
			stmt.close();

			stmt_1 = conn.prepareStatement(SQLConstants.UPADTE_CATALOG_AFTER_STUDENT);
			stmt_1.setString(1, studentid);
			stmt_1.executeUpdate();
			stmt_1.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (CourseNotFoundException e) {
			throw new CourseNotFoundException(courseId);
		}

	}


	/** 
	 * Method to viewGrade
	 * @param  studentid
	 * @return List<Grades>
	
	 */
	
	public List<Grades> viewGrades(String studentid) {

		Connection conn = null;
		PreparedStatement stmt = null;
		List<Grades> grades = new ArrayList<Grades>();
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_GRADES);
			stmt.setString(1, studentid);
			ResultSet rs = stmt.executeQuery();
			if (!(rs.next())) {
				System.out.println("\nNO COURSES FOUND!\n");
			} else {
				while (rs.next()) {
					String cc = rs.getString("coursecode");
					String cn = rs.getString("coursename");
					String grade = rs.getString("grade");
					Grades g = new Grades();
					g.setCourseCode(cc);
					g.setCourseName(cn);
					g.setGrade(grade);
					grades.add(g);
				}
			}
			rs.close();
			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grades;
	}
	
	/** 
	 * Method to viewRegisteredCourses
	 * @param  studentid
	 * @return List<RegisteredCourse>
	
	 */
	

	public List<RegisteredCourse> viewRegisteredCourses(String studentid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<RegisteredCourse> rcourses = new ArrayList<RegisteredCourse>();
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_REGISTERED_COURSES);
			stmt.setString(1, studentid);
			ResultSet rs = stmt.executeQuery();
			if (rs == null) {
				System.out.println("\nNO COURSES FOUND!\n");
			} else {
				while (rs.next()) {
					String cc = rs.getString("coursecode");
					int sem = rs.getInt("semester");
					String cn = rs.getString("coursename");
					int type = rs.getInt("type");

					RegisteredCourse c = new RegisteredCourse();
					c.setCourseCode(cc);
					c.setCourseName(cn);
					c.setSemester(sem);
					c.setType(type);
					rcourses.add(c);
				}
			}
			rs.close();
			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rcourses;
	}

	/** 
	 * Method to getFees
	 * @param  studentid
	 * @return List<Course>
	
	 */

	
	public List<Course> getFees(String studentid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.GET_FEES);
			stmt.setString(1, studentid);
			ResultSet rs = stmt.executeQuery();
			if (rs == null) {
				System.out.println("\nNO COURSES FOUND!\n");
			} else {
				System.out.println("\nCOURSE CODE\tCOURSE NAME\tCOURSE FEE\n");
				while (rs.next()) {
					String coursecode = rs.getString("coursecode");
					String coursename = rs.getString("coursename");
					int fee = rs.getInt("coursefee");
					Course c = new Course();
					c.setCourseCode(coursecode);
					c.setName(coursename);
					c.setFee(fee);
					courses.add(c);
				}
			}

			rs.close();
			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/** 
	 * Method to payFeesByCard
	 * @param  onp,p
	 * @return void
	
	 */

	
	@Override
	public void payFeesByCard(OnlinePayment onp, Payment p) {
		Connection conn = null;
		PreparedStatement stmt = null, stmt_s = null;
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.PAYMENT_CARD);
			stmt.setString(1, p.getReferencedId());
			stmt.setString(2, p.getStudentId());
			stmt.setString(3, p.getMode());
			stmt.setString(4, "PAID");
			stmt.setDouble(5, p.getAmount());

			stmt_s = conn.prepareStatement(SQLConstants.PAYMENT_CARD_ONLINE);
			stmt_s.setString(1, onp.getReferencedId());
			stmt_s.setInt(2, onp.getCard());
			stmt_s.setString(3, onp.getCardNumber());
			stmt_s.setString(4, onp.getCardType());
			stmt_s.setString(5, onp.getModeOfTransfer());
			stmt_s.setString(6, onp.getAccountNumber());
			stmt_s.setString(7, onp.getIfscode());

			stmt.executeUpdate();
			stmt_s.execute();
			System.out.println("\nFEE PAID BY CARD\n");

			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Method to payFeesByNetBanking
	 * @param  onp,p
	 * @return void
	 */
	@Override
	public void payFeesByNetBanking(OnlinePayment onp, Payment p) {
		Connection conn = null;
		PreparedStatement stmt = null, stmt_s = null;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.PAYMENT_NETBANK);
			stmt.setString(1, p.getReferencedId());
			stmt.setString(2, p.getStudentId());
			stmt.setString(3, p.getMode());
			stmt.setString(4, "PAID");
			stmt.setDouble(5, p.getAmount());

			stmt_s = conn.prepareStatement(SQLConstants.PAYMENT_NETBANK_ONLINE);
			stmt_s.setString(1, onp.getReferencedId());
			stmt_s.setInt(2, onp.getCard());
			stmt_s.setString(3, onp.getCardNumber());
			stmt_s.setString(4, onp.getCardType());
			stmt_s.setString(5, onp.getModeOfTransfer());
			stmt_s.setString(6, onp.getAccountNumber());
			stmt_s.setString(7, onp.getIfscode());

			stmt.executeUpdate();
			stmt_s.execute();
			System.out.println("\nFEE PAID BY NET BANKING\n");

			stmt.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Method to payFeesByCheque
	 * @param  ofp,p
	 * @return void	
	 */
	
	@Override
	public void payFeesByCheque(OfflinePayment ofp, Payment p) {
		Connection conn = null;
		PreparedStatement stmt = null, stmt_s = null;

		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.PAYMENT_CHEQUE);
			stmt.setString(1, p.getReferencedId());
			stmt.setString(2, p.getStudentId());
			stmt.setString(3, p.getMode());
			stmt.setString(4, "PAID");
			stmt.setDouble(5, p.getAmount());

			stmt_s = conn.prepareStatement(SQLConstants.PAYMENT_CHEQUE_OFFLINE);
			stmt_s.setString(1, ofp.getReferencedId());
			stmt_s.setInt(2, ofp.getCash());
			stmt_s.setInt(3, ofp.getChequeNumber());
			stmt_s.setString(4, ofp.getBankName());

			stmt.executeUpdate();
			stmt_s.execute();
			System.out.println("\nFEE PAID BY CHEQUE\n");

			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Method to payFeesByCash
	 * @param  ofp,p
	 * @return void	
	 */
	
	@Override
	public void payFeesByCash(OfflinePayment ofp, Payment p) {

		Connection conn = null;
		PreparedStatement stmt = null, stmt_s = null;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.PAYMENT_CASH);
			stmt.setString(1, p.getReferencedId());
			stmt.setString(2, p.getStudentId());
			stmt.setString(3, p.getMode());
			stmt.setString(4, "PAID");
			stmt.setDouble(5, p.getAmount());

			stmt_s = conn.prepareStatement(SQLConstants.PAYMENT_CASH_OFFLINE);
			stmt_s.setString(1, ofp.getReferencedId());
			stmt_s.setInt(2, ofp.getCash());
			stmt_s.setInt(3, ofp.getChequeNumber());
			stmt_s.setString(4, ofp.getBankName());

			stmt.executeUpdate();
			stmt_s.execute();
			System.out.println("\nFEE PAID BY CASH\n");

			stmt.close();
			;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}