package com.cv.tasks;

import java.util.Scanner;

public class JavaTaskTwo {

	public static int romanCharToInt(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'i':
			return 1;
		case 'V':
			return 5;
		case 'v':
			return 5;
		case 'X':
			return 10;
		case 'x':
			return 10;
		case 'L':
			return 50;
		case 'l':
			return 50;
		case 'C':
			return 100;
		case 'c':
			return 100;
		case 'D':
			return 500;
		case 'd':
			return 500;
		case 'M':
			return 1000;
		case 'm':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter roman number :: ");
		String romanString = sc.next().toLowerCase(); // scanning roman number as string and converting into lower case for hadling the lower case roman number

		int prevInt = 0; // 
		int result = 0;
		for (int i = romanString.length() - 1; i >= 0; i--) { // scanning up to if length of string is not euqals to zero

			int currInt = romanCharToInt(romanString.charAt(i)); // it is storing the char inter valua from the method
																	// at the index is matched with the method
			if (currInt < prevInt) { // check whether currchar integer is lower than the previouse one 
				result -= currInt; // if currchar is lower than previous one then result - currchar integer
			} else {
				result += currInt; // if not then add to currchar integer to the result
			}

			prevInt = currInt; // storing for referent the previous values for compairing the next char
		}

		System.out.println("The integer value of the roman " + romanString + " is :: " + result); // result displayed
	}

}
