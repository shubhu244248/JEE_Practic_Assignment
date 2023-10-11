package com.cv.tasks;

import java.util.*;

public class JavaTaskThree {

	public static boolean checkPangram(String sentence) {
		
		String alphaList = "abcdefghijklmnopqrstuvwxyz"; // reference a string containing all lowercase letters (a to z)

		
		for (char letter : alphaList.toCharArray()) { // iterate through each character in the alphabet list
			
			if (sentence.indexOf(letter) == -1) { // Check if the sentence contains the letter it is happening only once
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a sentence to check if it's a pangram :: ");

		String sen = sc.nextLine().toLowerCase();// Scanning the input sentence from the user and convert it to lowercase

		boolean isPangram = checkPangram(sen); // calling method to check it gives true or false

		if (isPangram) { // if true
			System.out.println("The input is a pangram.");
		} else { // if not true then
			System.out.println("The input is not a pangram.");
		}
	}

}
