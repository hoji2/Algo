import java.util.Scanner;

public class BOJ_9456_스티커 {
	/*
	 [점수를 무조건 최대로 만드는 방법 X]
	 
	 3
	 99 100 99
	 1 99 1
	 
	 https://zoonvivor.tistory.com/114
	 */
	static Scanner sc=new Scanner(System.in);
	static int[][]map;
	static int[][]dp;
	static int col;
	
	public static void main(String[] args) {

		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			col=sc.nextInt();
			map=new int[2][col];
			dp=new int[2][col];
			
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < col; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			
			dp[0][0]=map[0][0];
			dp[1][0]=map[1][0];
			
			if(col==1)
				System.out.println(Math.max(dp[0][0], dp[1][0]));
			else {
				
				dp[0][1]=dp[1][0]+map[0][1];
				dp[1][1]=dp[0][0]+map[1][1];

				for (int j = 2; j < col; j++) {
					dp[0][j]=Math.max(dp[1][j-2], dp[1][j-1])+map[0][j];
					dp[1][j]=Math.max(dp[0][j-2], dp[0][j-1])+map[1][j];
				}
				
				System.out.println(Math.max(dp[0][col-1], dp[1][col-1]));
			}
		}
	}
}

/*
[비슷 풀이]

import java.util.Arrays;
import java.util.Scanner;

public class test {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			int n=sc.nextInt();
			int[][]map=new int[2][n];
			
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < n; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			
			if(n==1)
				System.out.println(Math.max(map[0][0], map[1][0]));
			else if(n==2)
				System.out.println(Math.max(map[0][0]+map[1][1], map[0][1]+map[1][0]));
			else {
				int [][]dp=new int[2][n];
				dp[0][0]=map[0][0];
				dp[1][0]=map[1][0];
				dp[0][1]=dp[1][0]+map[0][1];
				dp[1][1]=dp[0][0]+map[1][1];
				
				for (int j = 2; j < n; j++) {
					for (int k = 0; k < 2; k++) {
						if(k==0)
							dp[k][j]=Math.max(dp[1][j-1], dp[1][j-2])+map[k][j];
						else
							dp[k][j]=Math.max(dp[0][j-1], dp[0][j-2])+map[k][j];
					}
				}
				
				System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
			}
		}
	}
}

 */
	
