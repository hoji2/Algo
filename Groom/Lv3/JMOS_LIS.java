package groom;

import java.util.Arrays;
import java.util.Scanner;

public class JMOS_LIS {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int[]map=new int[n];
		int[]dp=new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i]=sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			// 새로운 끝을 하나씩 늘리기 (0~0 까지,0~1 까지,0~2 까지...) 
			dp[i]=1;
			// 0부터 시작 ~ 끝보다 작을 때 까지
			for (int j = 0; j <=i; j++) {
				// 최종(i)보다 작은 j를 발견한 경우
				if(map[i]>map[j])
					// 최종 dp[i]는 발견한 작은 수 까지 누적되어있는 증가수열의 개수 dp[j] + 자기자신 1 중 비교
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
		}
		
		Arrays.sort(dp);
		System.out.println(n-dp[n-1]);
	}
}
