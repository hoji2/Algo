package swea;

import java.util.Scanner;

public class Solution_D3_8556 {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <=tc; i++) {
			String s=sc.nextLine();
			System.out.println("#"+i+" "+solve(s));
		}
	}
	
	public static String solve(String s) {
		long son=0;
		long mom=1;
		int size=0;
		int cnt=0;
		
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
		
		if(sb.charAt(size)=='h') {
			son=0;
			size+=5;
		}
		else {
			son=90;
			size+=4;
		}
		
		while(size<sb.length()) {
			cnt++;
			mom=(long) Math.pow(2, cnt);
			
			if(sb.charAt(size)=='h') {
				size+=5;
				son=son*2-90;
			}else {
				size+=4;
				son=son*2+90;
			}
		}
		
		if(son%mom==0)
			return son/mom+"";
		
		return divide(son,mom); 
	}
	
	public static String divide(long son, long mom) {
		
		while(true) {
			if(son==0 || son%2!=0)
				break;
			else
				son/=2;
			
			mom/=2;
		}
		
		return son+"/"+mom;
	}
}
