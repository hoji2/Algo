import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13275_가장긴팰린더룸부분문자열 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[]dp;
	public static void main(String[] args) throws IOException {
	
		String s=br.readLine();
		int size=s.length();
		StringBuilder sb=new StringBuilder();
		
		//짝수 길이의 회문도 판별하기 위해 문자열 사이에 "#" add
		for (int i = 0; i < size; i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");

		// 탐색 idx 기준 회문의 반지름을 저장할 배열
		dp=new int[sb.length()];
		solve(sb.toString());
		
		int res=0;
		for (int i = 0; i < sb.length(); i++) {
			res=Math.max(res, dp[i]);
		}
		
		System.out.println(res);
		
	}
	
	private static void solve(String str) {
		
		// 최신 반지름 길이 r, 그떄의 중심좌표 p
		// for문 순회시 인덱스 i 기준 이전에 구한 반지름과, 좌표 p를 기준으로 반지름을 더해나갈 지 여부 파악 -> 시간 단축
		int r=0,p=0;
		
		for (int i = 0; i < str.length(); i++) {
			//i≤r이라면, i는 p를 중심으로 한 회문에 속한다. 따라서 그 회문에서 i의 대칭점을 i′라 하자. 즉, i′=2p−i. 그리고 A[i]의 초기값은 min(r−i,A[i′])이다.
			if(i<=r)
				dp[i]=Math.min(dp[2*p-i], r-i);
			else
				dp[i]=0;
			
			// 현재 i 기준 i-(dp[i]+1) idx와 i-(dp[i]+1) 의 idx에 문자를 비교해야함
			// 위 2개의 좌표에 대한 예외처리 후 값이 같으면 dp[i](반지름의 길이) 증가
			while(i-dp[i]-1>=0 && i+dp[i]+1 <str.length() && str.charAt(i-dp[i]-1)==str.charAt(i+dp[i]+1))
				dp[i]++;
			
			// 다음 루프로 넘기기 전 회문이 완성된 상태에서 r이 i+dp[i]보다 작으면 회문의 r을 회문의 끝인 i+dp[i]로 변환
			
			if(r<i+dp[i]) {
				r=i+dp[i];
				p=i;
			}
		}
	}
}
