import java.util.Scanner;

public class BOJ_10448_유레카이론 {

	static Scanner sc=new Scanner(System.in);
	static int[]dp=new int[1001];
	static int[]sel;
	static int find;
	static boolean go, fin;
	public static void main(String[] args) {
	
		init();
		
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			find=sc.nextInt();
			sel=new int[3];
			go=true;
			fin=false;
			solve(0);
			if(fin)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	
	public static void solve(int cnt) {
		
		if(fin)
			return;
		
		if(cnt==3) {
			int tmp=0;
			for(int i : sel)
				tmp+=dp[i];
			
			if(tmp==find)
				fin=true;
			
			return;
			
		}
		
		for (int i = 1; i <=1000; i++) {
			if(dp[i]>find) {
				return;
			}else {
				sel[cnt++]=i;
				solve(cnt);
				sel[--cnt]=0;
			}
		}
		
	}
	
	public static void init() {
		for (int i = 1; i <=1000; i++) {
			dp[i]=i*(i+1)/2;
		}
	}
}
