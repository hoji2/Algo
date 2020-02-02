import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_15663_N과M1_중복입력_중복없는수열 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	//hashset 안되는 이유
	static LinkedHashSet<String>info=new LinkedHashSet<String>();
	static StringBuilder sb=new StringBuilder();
	static int[]arr,dp;
	static boolean[]visit;
	
	public static void main(String[] args) {
	
		LinkedList<String> tmp=new LinkedList<String>();
		
		n=sc.nextInt();
		m=sc.nextInt();

		arr=new int[n];
		dp=new int[n];
		visit=new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		solve(0);
		
		// set에 idx 접근 방법
		// 1) 또는 상향 반복문 사용
		
		for(String str : info) {
			System.out.print(str);
		}
		
		// 2) Iterartor 사용
		/*
		Iterator<String> it=info.iterator();
		while(it.hasNext())
			System.out.print(it.next());
		 */
	}
	
	public static void solve(int cnt) {
	
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
		
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i]=true;
				dp[cnt++]=arr[i];
				solve(cnt);
				dp[--cnt]=0;
				visit[i]=false;
			}
		}
	}
}
