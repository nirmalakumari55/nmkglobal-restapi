package com.kkg.rest.test;

public class Test {

	public static void main(String[] aa) {
		
		Employee e1 = new Employee();
		e1.setId(123);
		e1.setName("kkg");
		e1.setPhoneNumber("12345678");
		e1.setEmail("kkg@gmail.com");
		
		Address adr = new Address();
		adr.setAddrLine1("1599 Marabu Way");
		adr.setCity("Fremont");
		e1.setAddress(adr);
		
		
		
		System.out.println ("id " + e1.getId());
		System.out.println("name =" + e1.getName());
		System.out.println("getPhoneNumber =" + e1.getPhoneNumber());
		System.out.println("getEmail =" + e1.getEmail());
		
		System.out.println("getAddress =" + e1.getAddress());
		System.out.println("getAddrLine1 =" + e1.getAddress().getAddrLine1());
		System.out.println("getAddrLine2 =" + e1.getAddress().getAddrLine2());
		System.out.println("getCity =" + e1.getAddress().getCity());
		System.out.println("getZipCode =" + e1.getAddress().getZipCode());
		System.out.println("getState =" + e1.getAddress().getState());
		
		/*
		Address adr = e1.getAddress();
		adr.getAddrLine1();
		adr.getAddrLine2();
		adr.getCity();
		adr.getState();
		adr.getZipCode();
		
		
		e1.getAddress().getAddrLine1();
		e1.getAddress().getAddrLine2();
		e1.getAddress().getCity();
		e1.getAddress().getState();
		e1.getAddress().getZipCode();
		*/
		
	}

}
