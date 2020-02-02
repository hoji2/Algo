import java.util.Scanner;

public class BOJ_15649_N과M1_중복없는수열 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	static int[]arr;
	static boolean[]visit;

	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		m=sc.nextInt();
		// arr, visit 배열크기 동일하게(0번 idx 사용 x)
		arr=new int[n+1];
		// 자기자신의 중복 뽑는것을 방지하기 위한 visit배열(순열 기준)
		visit=new boolean[n+1];
		
		// idx 처리 필요없음, 뽑은 개수로 시작
		solve(0);
	}
	
	public static void solve(int cnt) {
		if(cnt==m) {
			print(cnt);
			return;
		}
		
		// 여기서는 1~n까지의 수를 사용하므로 따로 원본배열 설정 X
		// 문제에 따라 원본 배열의 idx값으로 수열 구현
		for (int i = 1; i <=n; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[cnt++]=i;
				solve(cnt);
				visit[i]=false;
				arr[cnt--]=0;
			}
		}
			
	}
	
	public static void print(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
	
}
