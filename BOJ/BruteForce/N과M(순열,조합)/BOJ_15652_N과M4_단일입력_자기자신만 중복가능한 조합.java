import java.util.Scanner;

public class BOJ_15652_N과M4_15652_중복증가수열 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	static int []arr;
	
	public static void main(String[] args) {

		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n+1];
		
		solve(1,0);
	}
	
	public static void solve(int st, int cnt) {
		if(cnt==m) {
			print(cnt);
			return;
		}
		
		for (int i = st; i <=n; i++) {
			arr[cnt++]=i;
			solve(i,cnt);
			arr[cnt--]=0;
		}
	}
	
	public static void print(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
