import java.util.Scanner;

public class BOJ_2503_숫자야구 {

	static Scanner sc=new Scanner(System.in);
	static int[][]dp;
	static int n, res=0;
	
	public static void main(String[] args) {
	

		n=sc.nextInt();
		dp=new int[n][3];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 123; i <=987; i++) {
			// 중요 ! (0포함한 수 + 중복숫자)
			String s= Integer.toString(i);
			if(!s.contains("0") && s.charAt(0)!=s.charAt(1) && s.charAt(0)!=s.charAt(2) && s.charAt(1)!=s.charAt(2))
				if(solve(i)) {
					res++;
				}
		}
		
		System.out.println(res);
		
	}
	public static boolean solve(int i) {
		
		char[]ori=Integer.toString(i).toCharArray();
		
		for (int j = 0; j < n; j++) {
			int[]tmp=dp[j];
			char[]num=Integer.toString(tmp[0]).toCharArray();
			// strike tmp[1]
			// ball tmp[2];
			int check_strike=0;
			int check_ball=0;
			
			for (int k = 0; k < num.length; k++) {
				if(ori[k]==num[k])
					check_strike++;
			}
			
			for (int k = 0; k < num.length; k++) {
				for (int p = 0; p < num.length; p++) {
					if(k==p) continue;
					if(ori[k]==num[p])
						check_ball++;
				}
			}
			
			if(check_strike!=tmp[1] || check_ball!=tmp[2])
				return false;
		}
		return true;
	}
}
