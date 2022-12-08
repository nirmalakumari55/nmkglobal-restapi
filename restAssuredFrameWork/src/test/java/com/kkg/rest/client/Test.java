package com.kkg.rest.client;

public class Test {

	//float, double
	public static void main(String a[]) {
		
		// Nirmal "Kumari" Bellala
		
		String name = "Nirmala \"Kumari\" Bellala";
		
		System.out.println(name);
		System.out.println (name.substring(2,3));
		System.out.println (name.substring(5));
		System.out.println (name.indexOf("Kui"));
		
		System.out.println (name.contains("Kui"));
		
		Test t1 = new Test();
		t1.sum(2, 3);
	}
	
	
	private int sum(int a, int b) {
		return a+b;
	}
}
