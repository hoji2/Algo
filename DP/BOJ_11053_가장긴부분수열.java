import java.util.Arrays;
import java.util.Scanner;
public class BOJ_11053_가장긴부분수열 {

	// https://code0xff.tistory.com/70
	// https://sudeky.tistory.com/131
	/*
	 Arrays.binarySearch
	 https://code0xff.tistory.com/68
	 */
	static Scanner sc=new Scanner(System.in);
	static int[]dp;
	static int[]map;
	static int idx;
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		dp=new int[n+1];
		map=new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			map[i]=sc.nextInt();
		}
		
		dp[1]=map[1];
		idx=2;
		
		for (int i = 2; i <= n; i++) {
			if(dp[idx-1]<map[i])
				dp[idx++]=map[i];
			else {
				int tmp=Arrays.binarySearch(dp, 1, idx, map[i]);
				dp[tmp < 0 ? -tmp - 1 : tmp]=map[i];
			}
		}
		System.out.println(idx-1);
	}
}
