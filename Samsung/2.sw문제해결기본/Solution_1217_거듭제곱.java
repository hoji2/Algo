import java.util.Scanner;

public class Solution_1217_거듭제곱 {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		for (int tc = 1; tc <=10; tc++) {
			sc.nextInt();
			int n=sc.nextInt();
			int cnt=sc.nextInt();
			
			System.out.println("#"+tc+" "+solve(n,cnt));
		}
	}
	
	public static int solve(int n, int cnt) {
		if(cnt==1)
			return n;
		
		return n*solve(n,cnt-1);
	}
}
