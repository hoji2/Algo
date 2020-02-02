import java.util.Scanner;

public class BOJ_15657_N과M8_중복증가수열 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	static int[]arr,dp;
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n];
		dp=new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		quick(0,arr.length-1);
		solve(0,0);
	}
	
	public static void solve(int st, int cnt) {
		
		if(cnt==m) {
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < cnt; i++) {
				sb.append(dp[i]);
				sb.append(" ");
			}
			sb.append("\n");
			System.out.print(sb);
			return;
		}
		
		for (int i = st; i < n; i++) {
			dp[cnt++]=arr[i];
			solve(i,cnt);
			dp[--cnt]=0;
		}
		
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
