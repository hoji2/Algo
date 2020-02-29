package groom;

import java.util.Scanner;

public class 완전수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int st=sc.nextInt();
		int end=sc.nextInt();
		
		for (int i = st; i <=end; i++) {
			if(i==1) continue;
			int tmp=0;
			for (int j = 2; j < Math.sqrt(i); j++) {
				if(i%j==0) {
					tmp+=j;
					tmp+=i/j;
				}
			}
			if(tmp+1==i)
				System.out.print(i+" ");
			
		}
	}
}
