package groom;

import java.util.Arrays;
import java.util.Scanner;

public class 배열합치기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[]dp=new int[sc.nextInt()+sc.nextInt()];
		for (int i = 0; i < dp.length; i++) {
			dp[i]=sc.nextInt();
		}
		
		Arrays.sort(dp);
		for(int i : dp)
			System.out.print(i+" ");
	}
}
