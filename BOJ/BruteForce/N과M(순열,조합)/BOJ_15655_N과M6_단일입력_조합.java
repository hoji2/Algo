import java.util.Scanner;

public class BOJ_15655_N과M6_중복없는증가수열 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	static int[]arr,dp;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n];
		dp=new int[n];
		visit=new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		quick(0,arr.length-1);
		solve(0,0);
	}
	
	public static void solve(int st, int cnt) {
		
		if(cnt==m) {
			print(cnt);
			return;
		}
		
		for (int i = st; i < n; i++) {
			if(!visit[i]){
				visit[i]=true;
				dp[cnt++]=arr[i];
				solve(i,cnt);
				dp[--cnt]=0;
				visit[i]=false;
			}
		}
	}
	
	public static void print(int cnt) {
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
	}
	
	public static void quick(int low, int high) {
		int i=low;
		int j=high;
		int pivot=arr[(i+j)/2];
		int tmp;
		
		while(i<=j) {
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			
			if(i<=j) {
				tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				i++;
				j--;
			}
		}
		
		if(low<j)
			quick(low,j);
		if(high>i)
			quick(i,high);
	}
}
