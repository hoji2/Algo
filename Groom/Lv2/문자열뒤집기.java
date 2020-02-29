package groom;

import java.util.Scanner;

public class 문자열뒤집기 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(new StringBuilder(sc.nextLine()).reverse().toString());
	}
}
