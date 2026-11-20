package com.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.entity.Student;
import com.service.StudentServiceImple;
import com.validations.ValidationChecker;

public class Application_MainClass {

	static Scanner sc = new Scanner(System.in);

	static Student student = new Student();

	public static void main(String[] args) {

		System.out.println("  --> Class Employment System <--");

		showMenu();
	}

	public static void showMenu() {

		StudentServiceImple stdImpl = new StudentServiceImple();

		boolean flag = true;

		while (flag) {

			try {

				System.out.println();
				System.out.println("╔════════════════════════════════════════════════════════╗");
				System.out.println("║                                                        ║");
				System.out.println("║              STUDENT MANAGEMENT SYSTEM                 ║");
				System.out.println("║                                                        ║");
				System.out.println("║               ─────── MAIN MENU ───────                ║");
				System.out.println("╠════════════════════════════════════════════════════════╣");
				System.out.println("║                                                        ║");
				System.out.println("║    01 ◆  Register Student                             ║");
				System.out.println("║    02 ◆  Display All Student Details                  ║");
				System.out.println("║    03 ◆  Get Student By ID                            ║");
				System.out.println("║    04 ◆  Update Student By ID                         ║");
				System.out.println("║    05 ◆  Delete Student By ID                         ║");
				System.out.println("║    06 ◆  Search Student By City                       ║");
				System.out.println("║    07 ◆  Search Student By Course                     ║");
				System.out.println("║    08 ◆  Search By Fees Greater Than Amount           ║");
				System.out.println("║    09 ◆  Top 5 Highest Fees                           ║");
				System.out.println("║    10 ◆  Exit Application                             ║");
				System.out.println("║                                                        ║");
				System.out.println("╠════════════════════════════════════════════════════════╣");
				System.out.println("║              >>> SELECT YOUR OPTION <<<                ║");
				System.out.println("╚════════════════════════════════════════════════════════╝");

				System.out.print("\n ➤  Please Enter Your Choice : ");

				int ch = sc.nextInt();

				switch (ch) {

				// ============================================================
				// CASE 1 : REGISTER STUDENTS
				// ============================================================
				
				case 1:

					try {

						System.out.println();
						System.out.println("╔════════════════════════════════════════════════════════╗");
						System.out.println("║                                                        ║");
						System.out.println("║                   REGISTER STUDENT                     ║");
						System.out.println("║                                                        ║");
						System.out.println("╠════════════════════════════════════════════════════════╣");
						System.out.println("║                                                        ║");
						System.out.println("║          Please Enter Student Details                  ║");
						System.out.println("║                                                        ║");
						System.out.println("║    01  ➤    Student Name                              ║");
						System.out.println("║    02  ➤    Student Batch                             ║");
						System.out.println("║    03  ➤    Student Course                            ║");
						System.out.println("║    04  ➤    Student Email                             ║");
						System.out.println("║    05  ➤    Phone Number                              ║");
						System.out.println("║    06  ➤    Student Fees                              ║");
						System.out.println("║    07  ➤    Student City                              ║");
						System.out.println("║                                                        ║");
						System.out.println("╠════════════════════════════════════════════════════════╣");
						System.out.println("║             >>> REGISTRATION FORM <<<                  ║");
						System.out.println("╚════════════════════════════════════════════════════════╝");

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

						System.out.print("  ➤ Enter Your Batch             : ");
						sc.nextLine();
						String batch = sc.nextLine();
						student.setBatch(batch);
						
						System.out.print("  ➤ Enter Your Course            : ");
						String course = sc.nextLine();
						student.setCourse(course);

						System.out.print("  ➤ Enter Your Email             : ");
						String email = ValidationChecker.emailValidation();
						student.setEmail(email);

						System.out.print("  ➤ Enter Your Phone No          : ");
						String phnNo = ValidationChecker.getValidMobileno();
						student.setPhnNo(phnNo);

						System.out.print("  ➤ Enter Your Fees              : ");
						double fees = sc.nextDouble();

						if (fees < 0) {
							System.out.println("\n  ◆ Fees Cannot Be Negative...!");
							break;
						}

						student.setFees(fees);

						System.out.print("  ➤ Enter Your City              : ");
						String city = sc.next();
						student.setCity(city);

						System.out.println();
						stdImpl.registerStudent(student);

						System.out.println();
						System.out.println("╔════════════════════════════════════════════════════════╗");
						System.out.println("║                                                        ║");
						System.out.println("║                REGISTRATION COMPLETED                  ║");
						System.out.println("║                                                        ║");
						System.out.println("╠════════════════════════════════════════════════════════╣");
						System.out.println("║                                                        ║");
						System.out.println("║           Student Registered Successfully!             ║");
						System.out.println("║                                                        ║");
						System.out.println("║           Student Details Saved To Database            ║");
						System.out.println("║                                                        ║");
						System.out.println("║                  ─── Thank You! ───                    ║");
						System.out.println("║                                                        ║");
						System.out.println("╚════════════════════════════════════════════════════════╝");

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid Input... Please Enter Valid Data!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Registration Failed...!");
						System.out.println("  ◆ Error : " + e.getMessage());
						sc.nextLine();
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 2 : DISPLAY ALL STUDENTS
				// ============================================================

				case 2:

					try {

						System.out.println();
						System.out.println("╔════════════════════════════════════════════════════════╗");
						System.out.println("║                                                        ║");
						System.out.println("║               DISPLAY ALL STUDENTS                     ║");
						System.out.println("║                                                        ║");
						System.out.println("╠════════════════════════════════════════════════════════╣");
						System.out.println("║                                                        ║");
						System.out.println("║    Display All Student Details --->                    ║");
						System.out.println("║                                                        ║");
						System.out.println("║    01  ➤    Student Name                              ║");
						System.out.println("║    02  ➤    Student Batch                             ║");
						System.out.println("║    03  ➤    Student Course                            ║");
						System.out.println("║    04  ➤    Student Email                             ║");
						System.out.println("║    05  ➤    Phone Number                              ║");
						System.out.println("║    06  ➤    Student Fees                              ║");
						System.out.println("║    07  ➤    Student City                              ║");
						System.out.println("║                                                        ║");
						System.out.println("╠════════════════════════════════════════════════════════╣");
						System.out.println("║             >>> STUDENT RECORDS <<<                    ║");
						System.out.println("╚════════════════════════════════════════════════════════╝");

						System.out.println();

						stdImpl.displayAllStudent();

						System.out.println();

						System.out.println("╔════════════════════════════════════════════════════════╗");
						System.out.println("║                                                        ║");
						System.out.println("║               DISPLAY DETAILS COMPLETED                ║");
						System.out.println("║                                                        ║");
						System.out.println("╚════════════════════════════════════════════════════════╝");

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Display Student Details...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 3 : GET STUDENT BY ID
				// ============================================================

				case 3:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------");

						System.out.println("GET STUDENT BY ID STARTED --->\n");

						System.out.print("Enter Your Id → ");
						int id = sc.nextInt();

						if (id <= 0) {
							System.out.println("\n  ◆ ID Must Be Greater Than Zero...!");
							break;
						}

						stdImpl.getStudentById(id);

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid ID... Please Enter Numbers Only!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Get Student...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 4 : UPDATE STUDENT BY ID
				// ============================================================

				case 4:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------");

						System.out.println("UPDATE STUDENT BY ID STARTED --->\n");

						System.out.print("Enter Your Id → ");
						int id1 = sc.nextInt();

						if (id1 <= 0) {
							System.out.println("\n  ◆ ID Must Be Greater Than Zero...!");
							break;
						}

						System.out.println();

						stdImpl.updateStudentById(id1);

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid ID... Please Enter Numbers Only!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Update Student...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 5 : DELETE STUDENT BY ID
				// ============================================================

				case 5:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------");

						System.out.println("DELETE STUDENT BY ID STARTED --->\n");

						System.out.print("Enter Your Id → ");
						int id2 = sc.nextInt();

						if (id2 <= 0) {
							System.out.println("\n  ◆ ID Must Be Greater Than Zero...!");
							break;
						}

						System.out.println();

						stdImpl.deleteStudentById(id2);

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid ID... Please Enter Numbers Only!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Delete Student...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 6 : SEARCH STUDENT BY CITY
				// ============================================================

				case 6:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------");

						System.out.println("SEARCH STUDENT BY CITY STARTED --->\n");

						System.out.print("Enter Your City → ");
						String id3 = sc.next();

						System.out.println();

						List<Student> students = stdImpl.searchStudentByCity(id3);

						if (students.isEmpty()) {

							System.out.println("\nStudent Not Available...");

						} else {

							for (Student student : students) {

								System.out.println();
								System.out.println(student);
							}
						}

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid CITY... Please Enter CITY Only!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Search Student...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 7 : SEARCH STUDENT BY COURSE
				// ============================================================

				case 7:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------\n");

						System.out.println("SEARCH STUDENT BY COURSE STARTED --->\n");

						System.out.print("Enter Your Course → ");

						sc.nextLine();

						String id4 = sc.nextLine();

						System.out.println();

						List<Student> studentList = stdImpl.searchStudentByCourse(id4);

						if (studentList.isEmpty()) {

							System.out.println("\nStudent Not Available...");

						} else {

							for (Student student2 : studentList) {

								System.out.println();
								System.out.println(student2);
							}
						}

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid COURSE... Please Enter COURSE Only!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Search Student...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 8 : FEES GREATER THAN AMOUNT
				// ============================================================

				case 8:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------");

						System.out.println("STUDENT WITH FEES GREATER THAN AMOUNT PROCESS STARTED --->\n");

						System.out.print("Enter Your Fees → ");

						double fees1 = sc.nextDouble();

						if (fees1 < 0) {

							System.out.println("\n  ◆ Fees Cannot Be Negative...!");
							break;
						}

						System.out.println();

						List<Student> student3 = stdImpl.studentWithFeesGreaterThan(fees1);

						if (student3.isEmpty()) {

							System.out.println("\nStudent Not Available...");

						} else {

							for (Student student2 : student3) {

								System.out.println();
								System.out.println(student2);
							}
						}

					} catch (InputMismatchException e) {

						System.out.println("\n  ◆ Invalid Fees... Please Enter Numbers Only!");
						sc.nextLine();

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Search Students...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 9 : TOP 5 HIGHEST FEES
				// ============================================================

				case 9:

					try {

						System.out.println(
								"\n-------------------------------------------------------------------------------------------------");

						System.out.println("TOP 5 HIGHEST FEES STUDENT PROCESS STARTED --->\n");

						List<Student> student4 = stdImpl.Top5HighestFeesStudent();

						if (student4.isEmpty()) {

							System.out.println("\nStudent Not Available...");

						} else {

							for (Student student2 : student4) {

								System.out.println();
								System.out.println(student2);
							}
						}

					} catch (Exception e) {

						System.out.println("\n  ◆ Unable To Display Top Students...!");
						System.out.println("  ◆ Error : " + e.getMessage());
					}

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					break;

				// ============================================================
				// CASE 10 : EXIT
				// ============================================================

				case 10:

					System.out.println(
							"\n-------------------------------------------------------------------------------------------------\n");

					System.out.println("EXITED SUCCESSFULLY\n");

					flag = false;

					break;

				// ============================================================
				// DEFAULT
				// ============================================================

				default:

					System.out.println("INVALID CHOICE...PLEASE ENTER VALID OPTION FROM GIVEN MENU\n");
				}

			} catch (InputMismatchException e) {

				/*
				 * This exception handles invalid menu input.
				 *
				 * Example: Enter Your Choice : abc
				 *
				 * Instead of application crashing, it will come back to the menu.
				 */

				System.out.println("\n╔══════════════════════════════════════════════════════╗");
				System.out.println("║                                                      ║");
				System.out.println("║                     INVALID INPUT                    ║");
				System.out.println("║                                                      ║");
				System.out.println("║               Please Enter Numbers Only!             ║");
				System.out.println("║                                                      ║");
				System.out.println("╚══════════════════════════════════════════════════════╝");

				// Remove invalid input from Scanner
				sc.nextLine();

			} catch (Exception e) {

				/*
				 * General exception handling. This prevents unexpected errors from terminating
				 * the application.
				 */

				System.out.println("\n  ◆ Something Went Wrong...!");
				System.out.println("  ◆ Error : " + e.getMessage());

				// Clear scanner if required
				sc.nextLine();
			}
		}
	}
}
