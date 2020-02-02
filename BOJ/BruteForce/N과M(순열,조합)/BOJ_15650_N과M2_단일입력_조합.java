import java.util.Scanner;

public class BOJ_15650_N과M2_단일입력_조합 {

	static Scanner sc=new Scanner(System.in);
	static int n,m;
	static int []arr;
	// 중요! visit 배열을 사용할 필요가 없음 -> 조합에서는
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n+1];
		
		solve(1,0);
	}
	
	// 증가수열에 사용할 st 인덱스와 뽑은개수 cnt
	public static void solve(int st, int cnt) {
		if(cnt==m) {
			print(cnt);
			return;
		}
		
		for (int i = st; i <=n; i++) {
			arr[cnt++]=i;
			// 증가하는 순서대로 뽑은 idx i는 새로운 st로변수
			solve(i+1,cnt);
			arr[cnt--]=0;
		}
	}
	
	
	public static void print(int cnt) {
		// 뽑힌 배열은 인덱스 0부터 시작
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
