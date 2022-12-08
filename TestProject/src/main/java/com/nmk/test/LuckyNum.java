package com.nmk.test;

public class LuckyNum {
	public static void main(String[] args) {
		int num = 989;
		int x = 0;
		while (num > 9) {
			x = num % 10;
			num = num/10;
			num = x + num;
		}
		System.out.println(num);

	}

}
