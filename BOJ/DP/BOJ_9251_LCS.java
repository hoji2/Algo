import java.util.Scanner;

//https://twinw.tistory.com/126
// [2][n] 최적화 : https://gd-story.tistory.com/42
public class BOJ_9251_LCS {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		
		// s2를 기준으로 s1와 비교함
		int[][]dp=new int[s2.length()+1][s1.length()+1];
		
		for (int i = 1; i <= s2.length(); i++) {
			for (int j = 1; j <=s1.length(); j++) {
				if(s2.charAt(i-1)==s1.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[s2.length()][s1.length()]);
		
	}
}
