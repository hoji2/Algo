package groom;

import java.util.Scanner;

public class 최대자리곱_tc하나x {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int num=sc.nextInt();
		
		if(num<10)
			System.out.println(num);
		else {
			//num
			StringBuilder num1=new StringBuilder(num+"");
			StringBuilder num2=new StringBuilder();
			StringBuilder num3=new StringBuilder();
			
			for (int i = 0; i < num1.length(); i++) {
				int q=num1.charAt(i)-'0';
				if(i==1)
					num2.append((q+9)%10);
				else if(i==0)
					num2.append(q);
				else
					num2.append(9);
			}
			
			for (int i = 0; i < num1.length(); i++) {
				int q=num1.charAt(i)-'0';
				if(i==0) {
					if(q!=1)
						num3.append(q-1);
				}
				else
					num3.append(9);
			}
			
			int p1=1;
			int p2=1;
			int p3=1;
			
			for(char p : num1.toString().toCharArray())
				p1*=(p-'0');
			for(char p : num2.toString().toCharArray())
				p2*=(p-'0');
			for(char p : num3.toString().toCharArray())
				p3*=(p-'0');
			
			if(Long.parseLong(num1.toString())<Long.parseLong(num2.toString())) {
				System.out.println(Math.max(p1, p3));
			}else {
				System.out.println(Math.max(p1, Math.max(p2, p3)));
			}
		}
	}
}
