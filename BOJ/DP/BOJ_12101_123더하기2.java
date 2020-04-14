import java.util.Scanner;

public class BOJ_12101_123더하기2 {

	static Scanner sc=new Scanner(System.in);
	static int n,idx,cur_idx;
	static int[]dp,res;
	public static void main(String[] args) {
	
		n=sc.nextInt();
		idx=sc.nextInt();
		cur_idx=0;
		
		dp=new int[12];
		res=new int[12];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for (int i = 4; i <=11; i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		if(dp[n]<idx)
			System.out.println(-1);
		else 
			find(0,0);
	}
	
	public static void find(int cnt, int sum) {
		
		if(sum>n)
			return;
		
		if(sum==n) {
			cur_idx++;
			if(cur_idx==idx) {
				print(cnt);
				return;
			}
		}
		
		// 1,2,3, 순서대로 완탐
		res[cnt++]=1;
		find(cnt,sum+1);
		res[--cnt]=0;

		res[cnt++]=2;
		find(cnt,sum+2);
		res[--cnt]=2;

		res[cnt++]=3;
		find(cnt,sum+3);
		res[--cnt]=3;
		
	}
	
	public static void print(int cnt) {
		for (int i = 0; i < cnt; i++) {
			if(i==cnt-1)
				System.out.print(res[i]);
			else
				System.out.print(res[i]+"+");
		}
	}
}
