import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10809_알파벳찾기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		char[]arr=sc.nextLine().toCharArray();
		int[]dp=new int[26];
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < arr.length; i++) {
			if(dp[arr[i]-97]!=-1)
				continue;
			dp[arr[i]-97]=i;
		}
		
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+" ");
		}
	}
}
