import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 시간초과 이슈 확인하는 방법?
public class BOJ_15651_N과M3_중복수열{

	static Scanner sc=new Scanner(System.in);
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,m;
	static int[]arr;
	
	public static void main(String[] args) throws IOException {
	
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n+1];
		
		solve(0);
		bw.close();
	}
	
	public static void solve(int cnt) throws IOException {
		// 시간초과 이슈
		// 출력이 많은 케이스라 StringBuilder를 사용하면 속도 줄일 수 있음
		if(cnt==m) {
			print(cnt);
			return;
		}
		
		for (int i = 1; i <=n; i++) {
			arr[cnt++]=i;
			solve(cnt);
			arr[cnt--]=0;
		}
	}
	
	public static void print(int cnt) throws IOException {
		
		for (int i = 0; i < cnt; i++) {
			bw.write(arr[i]+" ");
		}
		bw.write("\n");
		bw.flush();
	}
}
