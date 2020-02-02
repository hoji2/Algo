import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_15665_N과M12_중복입력_중복증가수열 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	static LinkedHashSet<String>info=new LinkedHashSet<String>();
	static StringBuilder sb=new StringBuilder();
	static int[]arr,dp;
	
	public static void main(String[] args) {
	
		LinkedList<String> tmp=new LinkedList<String>();
		
		n=sc.nextInt();
		m=sc.nextInt();

		arr=new int[n];
		dp=new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		solve(0,0);
		
		for(String str : info) {
			System.out.print(str);
		}
		
	}
	
	public static void solve(int st, int cnt) {
	
		if(cnt==m) {
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < cnt; i++) {
				sb.append(dp[i]);
				sb.append(" ");
			}
			sb.append("\n");
			info.add(sb.toString());
			return;
		}
		
		for (int i = st; i < n; i++) {
				dp[cnt++]=arr[i];
				solve(i,cnt);
				dp[--cnt]=0;
			}
	}
}
