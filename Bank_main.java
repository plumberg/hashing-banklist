package hw_1_hashing;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bank_main {

	public static void main(String[] args) {
		// When I did this assignment, I didn`t pay attention that it should be
		// specifically done with stringTokenizer. So I did it both ways
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Press me ");
		int answ = sc.nextInt();
		
		if (answ == 1) {
			splitMethod();
		} else System.out.println("Exiting...");

	}


	private static void splitMethod() {
		// Using a HashMap store the name of the city state combination as key and the
		// number of times this combination occurs in the file

		// HashMap<USState, Integer> hashBank = new HashMap<USState, Integer>();

		HashMap<String, Integer> hashBank = new HashMap<String, Integer>();
		Bank_Failed aBank = null;
		USState state;
		int i = 1;
		try {
			FileReader reader = new FileReader("banklist.txt");
			BufferedReader bufReader = new BufferedReader(reader);
			String c;

			while ((c = bufReader.readLine()) != null) {
				// System.out.println(c);
				String[] s = c.split(",");
				state = USState.valueOf(s[2]);
				aBank = new Bank_Failed(s[0], s[1], state, s[3], s[4], s[5], s[6]);
				// to print out the txt list without commas, processed from Bank_Failed class
				// System.out.println(aBank.toString());

				// To simplify combination instead of s[1] + " " + state :
				String key = s[1] + " " + state;
				// Check if a HashMap already contains this combination of key:
				if (hashBank.containsKey(key)) {
					hashBank.put(key, hashBank.get(key) + i);
				} else {
					hashBank.put(key, i);
				}
			}

			// Same iterating as we used in LibraryHashed class
			for (Map.Entry<String, Integer> it : hashBank.entrySet()) {
				String keys = it.getKey();
				Integer val = it.getValue();
				System.out.println(keys + "\t" + val);
			}

			// Next, iterate through linkedHashMap
			System.out.println();
			linkedMap(hashBank);

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}

	}

	private static void linkedMap(HashMap<String, Integer> hashBank) {
		LinkedHashMap<String, Integer> linkedBank = new LinkedHashMap<String, Integer>();

		// To put hash map , I can use a java method putAll OR iterate and put each
		// value and key by myself
		linkedBank.putAll(hashBank);
		/*
		 * for(Map.Entry<String, Integer> entry : hashBank.entrySet()) {
		 * linkedBank.put(entry.getKey(),entry.getValue() ); }
		 */

		// I feel like it might be a little bit cheating first to determine a max value
		// in the LinkedHashMap instead of searching through iterating.
		// But it works and easy
		Integer max = Collections.max(linkedBank.values());

		for (Map.Entry<String, Integer> entry : linkedBank.entrySet()) {
			// I think because its comparing an Integers, I need to use a simple '==' sign.
			// However I left a compareTo because I like how it looks
			// if(entry.getValue()==max) {
			if (entry.getValue().compareTo(max) == 0) {
				System.out.println("City with max failures\t " + entry.getKey() + " " + entry.getValue());
			}
		}

		/*
		 * A possible iterating with an iterator, but it does not get a key
		 * Iterator<Integer> it = linkedBank.values().iterator(); while (it.hasNext()) {
		 * Integer val = it.next(); if (val.compareTo(max) == 0) {
		 * System.out.println("The max found " + max); } 
		 * } 
		 * This kind of iterator didn`t work because of two generics arguments ( works only with Integer)
		 * //Iterator<Map.Entry<String, Integer>> iter = linkedBank.entrySet().iterator();
		 */

	}

}
