import java.util.Scanner;

public class BOJ_1748_수이어쓰기1 {

	static Scanner sc=new Scanner(System.in);
			
	public static void main(String[] args) {
	
		//1억까지 자리수를 모두 더하게되면 시간초과
		int n=sc.nextInt();
		long tmp=0;
		
		int[]dp=new int[11];
		int idx=1;
		
		for (int i = 1; i <=9; i++) {
			dp[i]=9*idx*i;
			idx*=10;
		}
		
		//현재 n의 자리수 구하기
		int cnt=0;
		int t=1;
		while(true) {
			if(n/t==0)
				break;
			cnt++;
			t*=10;
		}
		
		// 현재 자리수(cnt)이전 까지 더해지는 모든 자리수를 dp를 이용해서 구함
		for (int i = 1; i <=cnt-1; i++) {
			tmp+=dp[i];
		}
		
		int st=(int)Math.pow(10, cnt-1);
		// st~n까지 같은 자리수 cnt로 되있으므로 n까지 cnt더하기 작업
		for(int i=st; i<=n; i++) {
			tmp+=cnt;
		}
		
		System.out.println(tmp);
		
	}
}
