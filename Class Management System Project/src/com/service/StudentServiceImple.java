package com.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;
import com.validations.ValidationChecker;

public class StudentServiceImple implements StudentService {

	static SessionFactory sf = HibernateUtil.getSessionfactory();

	static Scanner sc = new Scanner(System.in);

	// ============================================================
	// REGISTER STUDENT
	// ============================================================

	@Override
	public void registerStudent(Student registerStudent) {

		try {

			Session session = sf.openSession();

			Transaction tx = session.beginTransaction();

			session.save(registerStudent);

			tx.commit();

			session.close();

		} catch (Exception e) {

			System.out.println("\n◆ Student Registration Failed...!");
			System.out.println("◆ Error : " + e.getMessage());
		}
	}

	// ============================================================
	// DISPLAY ALL STUDENTS
	// ============================================================

	@Override
	public List<Student> displayAllStudent() {

		try {

			Session session = sf.openSession();

			Query displayAllStudentDetails = session.createQuery("from Student");

			List<Student> allStudents = displayAllStudentDetails.getResultList();

			for (Student student : allStudents) {

				System.out.println();
				System.out.println(student);
			}

			session.close();

			return allStudents;

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Display Students...!");
			System.out.println("◆ Error : " + e.getMessage());

			return null;
		}
	}

	// ============================================================
	// GET STUDENT BY ID
	// ============================================================

	@Override
	public Student getStudentById(int id) {

		try {

			Session session = sf.openSession();

			Student getStudentById = session.get(Student.class, id);

			if (getStudentById == null) {

				System.out.println("\nStudent Is Not Available...");

			} else {

				System.out.println();
				System.out.println(getStudentById);
			}

			session.close();

			return getStudentById;

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Get Student...!");
			System.out.println("◆ Error : " + e.getMessage());

			return null;
		}
	}

	// ============================================================
	// UPDATE STUDENT BY ID
	// ============================================================

	@Override
	public void updateStudentById(int id) {

		try {

			boolean flag = true;

			Session session = sf.openSession();

			Student student = session.get(Student.class, id);

			if (student == null) {

				System.out.println("\nStudent Does Not Exist...");

			} else {

				while (flag) {

					System.out.println("\n========= UPDATE STUDENT DETAILS =========\n");

					System.out.println("1. UPDATE NAME");
					System.out.println("2. UPDATE Phone NUMBER");
					System.out.println("3. UPDATE COURSE");
					System.out.println("4. UPDATE CITY");
					System.out.println("5. UPDATE BATCH");
					System.out.println("6. UPDATE FEES");
					System.out.println("7. UPDATE EMAIL");
					System.out.println("8. EXIT");

					System.out.print("\n  ➤  ENTER YOUR CHOICE             : ");

					int ch = sc.nextInt();

					switch (ch) {

					case 1:

						System.out.println();

						System.out.print("  ➤ Enter Your First Name        : ");
						String firstName = ValidationChecker.checkFirstName();
						student.setFirstName(firstName);

						System.out.print("  ➤ Enter Your Middle Name       : ");
						String middleName = ValidationChecker.checkMiddleName();
						student.setMiddleName(middleName);

						System.out.print("  ➤ Enter Your Last Name         : ");
						String lastName = ValidationChecker.checkLastName();
						student.setLastName(lastName);

						String updatedName = firstName + " " + middleName + " " + lastName;

						System.out.println();
						Transaction tx1 = session.beginTransaction();

						Query query1 = session.createQuery("UPDATE Student set name = :name where id = :inputId");

						query1.setParameter("name", updatedName);
						query1.setParameter("inputId", id);

						query1.executeUpdate();

						tx1.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 2:

						System.out.print("\nEnter Your Updated Phone Number : ");
						long updatedPhoneNo = sc.nextLong();

						System.out.println();

						Transaction tx2 = session.beginTransaction();

						Query query2 = session.createQuery("UPDATE Student set phnNo = :phoneNo where id = :inputId");

						query2.setParameter("phoneNo", updatedPhoneNo);
						query2.setParameter("inputId", id);

						query2.executeUpdate();

						tx2.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 3:

						System.out.print("\nEnter Your Updated Course : ");
						sc.nextLine();
						String updatedCourse = sc.nextLine();

						System.out.println();

						Transaction tx3 = session.beginTransaction();

						Query query3 = session.createQuery("UPDATE Student set course = :course where id = :inputId");

						query3.setParameter("course", updatedCourse);
						query3.setParameter("inputId", id);

						query3.executeUpdate();

						tx3.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 4:

						System.out.print("\nEnter Your Updated City : ");
						String updatedCity = sc.next();

						System.out.println();

						Transaction tx4 = session.beginTransaction();

						Query query4 = session.createQuery("UPDATE Student set city = :city where id = :inputId");

						query4.setParameter("city", updatedCity);
						query4.setParameter("inputId", id);

						query4.executeUpdate();

						tx4.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 5:

						System.out.print("Enter Your Updated Batch : ");
						sc.nextLine();
						String updatedBatch = sc.nextLine();

						System.out.println();

						Transaction tx5 = session.beginTransaction();

						Query query5 = session.createQuery("UPDATE Student set batch = :batch where id = :inputId");

						query5.setParameter("batch", updatedBatch);
						query5.setParameter("inputId", id);

						query5.executeUpdate();

						tx5.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 6:

						System.out.print("\nEnter Your Updated Fees : ");
						double updatedFees = sc.nextDouble();

						System.out.println();

						Transaction tx6 = session.beginTransaction();

						Query query6 = session.createQuery("UPDATE Student set fees = :fees where id = :inputId");

						query6.setParameter("fees", updatedFees);
						query6.setParameter("inputId", id);

						query6.executeUpdate();

						tx6.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 7:

						System.out.print("\nEnter Your Updated Email : ");
						String updatedEmail = sc.next();

						System.out.println();

						Transaction tx7 = session.beginTransaction();

						Query query7 = session.createQuery("UPDATE Student set email = :email where id = :inputId");

						query7.setParameter("email", updatedEmail);
						query7.setParameter("inputId", id);

						query7.executeUpdate();

						tx7.commit();

						System.out.println("\nStudent Updated Successfully...!!");

						break;

					case 8:

						System.out.print("\nEXITED SUCCESSFULLY...!!");

						flag = false;

						break;

					default:

						System.out.println("\nInvalid Choice");

						break;
					}
				}
			}

			session.close();

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Update Student...!");

			System.out.println("◆ Error : " + e.getMessage());
		}
	}

	// ============================================================
	// DELETE STUDENT BY ID
	// ============================================================

	@Override
	public void deleteStudentById(int id) {

		try {

			Session session = sf.openSession();

			Transaction tx = session.beginTransaction();

			Student deleteStudentById = session.get(Student.class, id);

			if (deleteStudentById != null) {

				session.delete(deleteStudentById);

				tx.commit();

				System.out.println("\nSTUDENT DELETED SUCCESSFULLY");

			} else {

				System.out.println("\nStudent Does Not Exist...");
			}

			session.close();

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Delete Student...!");

			System.out.println("◆ Error : " + e.getMessage());
		}
	}

	// ============================================================
	// SEARCH STUDENT BY CITY
	// ============================================================

	@Override
	public List<Student> searchStudentByCity(String city) {

		try {

			Session session = sf.openSession();

			Query query1 = session.createQuery("from Student where city = :inputCity");

			query1.setParameter("inputCity", city);

			List<Student> searchStudentByCity = query1.getResultList();

			session.close();

			return searchStudentByCity;

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Search Student By City...!");

			System.out.println("◆ Error : " + e.getMessage());

			return null;
		}
	}

	// ============================================================
	// SEARCH STUDENT BY COURSE
	// ============================================================

	@Override
	public List<Student> searchStudentByCourse(String course) {

		try {

			Session session = sf.openSession();

			Query query1 = session.createQuery("from Student where course = :course");

			query1.setParameter("course", course);

			List<Student> searchStudentByCourse = query1.getResultList();

			session.close();

			return searchStudentByCourse;

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Search Student By Course...!");

			System.out.println("◆ Error : " + e.getMessage());

			return null;
		}
	}

	// ============================================================
	// STUDENTS WITH FEES GREATER THAN
	// ============================================================

	@Override
	public List<Student> studentWithFeesGreaterThan(double fees) {

		try {

			Session session = sf.openSession();

			Query query2 = session.createQuery("from Student where fees > :inputFees");

			query2.setParameter("inputFees", fees);

			List<Student> students = query2.getResultList();

			session.close();

			return students;

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Search Students By Fees...!");

			System.out.println("◆ Error : " + e.getMessage());

			return null;
		}
	}

	// ============================================================
	// TOP 5 HIGHEST FEES STUDENTS
	// ============================================================

	@Override
	public List<Student> Top5HighestFeesStudent() {

		try {

			Session session = sf.openSession();

			Query query3 = session.createQuery("from Student order by fees desc");

			query3.setMaxResults(5);

			List<Student> top5Fees = query3.getResultList();

			session.close();

			return top5Fees;

		} catch (Exception e) {

			System.out.println("\n◆ Unable To Get Top 5 Students...!");

			System.out.println("◆ Error : " + e.getMessage());

			return null;
		}
	}
}
