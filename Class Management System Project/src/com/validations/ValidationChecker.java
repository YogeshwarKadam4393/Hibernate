package com.validations;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationChecker {

	public static String checkFirstName() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String name = sc.next();

			if (Pattern.matches("[A-Za-z]+", name)) {
				return name;
			} else {
				System.out.println("  ◆ Invalid Name...!");
				System.out.print("\n  ➤ RE-ENTER YOUR FIRST NAME            : ");
			}
		}
	}

	public static String checkMiddleName() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String name = sc.next();

			if (Pattern.matches("[A-Za-z]+", name)) {
				return name;
			} else {
				System.out.println("  ◆ Invalid Name...!");
				System.out.print("\n  ➤ RE-ENTER YOUR MIDDLE NAME           : ");
			}
		}
	}

	public static String checkLastName() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String name = sc.next();

			if (Pattern.matches("[A-Za-z]+", name)) {
				return name;
			} else {
				System.out.println("  ◆ Invalid Name...!");
				System.out.print("\n  ➤ RE-ENTER YOUR LAST NAME             : ");
			}
		}
	}

	// Validates Aadhaar number : format (12 digits, starts with 2–9).
//	public static String aadharValidation() {
//
//		Scanner sc = new Scanner(System.in);
//
//		while (true) {
//			String adharCardNumber = sc.nextLine();
//
//			if (Pattern.matches("[2-9]{1}[0-9]{3}[ ]{1}[0-9]{4}[ ]{1}[0-9]{4}", adharCardNumber)) {
//				return adharCardNumber;
//			} else {
//				System.out.println("  ◆ Invalid AadharCard Number...!");
//				System.out.print("\n  ➤ RE-ENTER YOUR AADHAR NUMBER         : ");
//			}
//		}
//	}

	// Method to validate PAN Card Number
//	public static String checkValidPanNumber() {
//
//		Scanner sc = new Scanner(System.in);
//
//		while (true) {
//
//			String panCardNumber = sc.next();
//
//			String upperCasePanNo = panCardNumber.toUpperCase();
//
//			if (Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}", upperCasePanNo)) {
//				return upperCasePanNo;
//			} else {
//				System.out.println("  ◆ Invalid Pan Number...!");
//				System.out.print("\n  ➤ RE-ENTER YOUR PANCARD NUMBER        : ");
//
//			}
//		}
//
//	}

	public static String getValidMobileno() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String mobileNo = sc.next();

			if (Pattern.matches("[6-9]{1}[0-9]{9}", mobileNo) && mobileNo.length() == 10) {
				return mobileNo;
			} else {
				System.out.println("  ◆ Invalid Mobile Number...!");
				System.out.print("\n  ➤ RE-ENTER YOUR PHONE NUMBER          : ");
			}
		}
	}

	// Validates email format using regex.
	public static String emailValidation() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String email = sc.next();

			// yogesh.kadam | @ | gmail | . | com
			// ↓ ↓ ↓ ↓ ↓
			// username @ domain dot TLD(Top Level Domain)

			if (Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email)) {

				return email;
			} else {
				System.out.println("  ➤ Invalid Email Address...!");
				System.out.print("\n  ➤ RE-ENTER YOUR EMAIL ADDRESS         : ");
			}
		}
	}

}
