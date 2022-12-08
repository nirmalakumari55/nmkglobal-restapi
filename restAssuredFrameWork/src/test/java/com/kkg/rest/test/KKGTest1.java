package com.kkg.rest.test;

public class KKGTest1 {
	
	
	public static void main (String[] kk) {
		String s1 = "Who is the BAD guy in the home?";
		String s2 = "He is none other than ....";
		
		KKGTest1 kk1 = new KKGTest1();
		kk1.printData(s1, s2);
		
		
		kk1.printData("Mahesh Bellala", " is the great");
		
	}
	
	public void printData(String a, String b) {
		
		System.out.println(a);
		System.out.println(b);
		
	}

}
