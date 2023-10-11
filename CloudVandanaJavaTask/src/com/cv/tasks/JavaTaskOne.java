package com.cv.tasks;

import java.util.*;

public class JavaTaskOne {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // creating obj for Scanner class
		
		ArrayList<Integer> al = new ArrayList<Integer>(); // creating array list for storing the integer values
		
		System.out.println("Enter Integer Value :: ");
		
		while(sc.hasNextInt()) { // while integer given by user added arraylist it will give true and scanning until user not stop giving input to value s variable
			int value = sc.nextInt(); // scanning user inputs
			System.out.println("For Adding keep Enter values || Stop Scanning :: Type 'NO'");
			al.add(value); // adding to arraylist
		}
		
		Collections.shuffle(al);
		
		System.out.println("Shuffeled Array is :: "+ al);
	}

}
