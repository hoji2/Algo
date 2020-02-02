import java.util.Scanner;
//https://stack07142.tistory.com/60
public class BOJ_2011_암호코드 {

	static Scanner sc=new Scanner(System.in);
	static long[]dp;
	
	public static void main(String[] args) {

		String s=sc.nextLine();
		dp=new long[s.length()];
		int mod=1000000;
		
		// 1자리
		if(s.length()==1) {
			// 0 -> 0
			if(Integer.parseInt(s)==0)
				System.out.println(0);
			// 1~9 -> 1
			else
				System.out.println(1);
		}
		// 2자리 이상
		else {
			int bef=s.charAt(0)-'0';
			int cur=s.charAt(1)-'0';
			
			// 11~19 && 26 -> dp[0]=1, dp[1]=2
			if(10*bef+cur>10 && 10*bef+cur<=26 && 10*bef+cur!=20) {
				dp[0]=1;
				dp[1]=2;
			}
			// 0X or 30,40,50...90
			else if(bef==0 || (bef>2 && cur==0))
				dp[1]=0;
			// 그외 예 31 / 36 -> 3-1 / 3- 6 case 1가지
			else {
				dp[0]=1;
				dp[1]=1;
			}
				
			// 3번째 자리부터 탐색
			for (int i = 2; i <s.length(); i++) {
				
				bef=s.charAt(i-1)-'0';
				cur=s.charAt(i)-'0';
				
				// 현재가 0인 경우 (예를 들어 3번째 idx기준)
				if(cur==0) {
					// 150 || 100 같은 예외
					if(bef>2 || bef==0) {
						dp[s.length()-1]=0;
						break;
					// 110, 120	
					}else {
						dp[i]=dp[i-2]%mod;
					}
					
				}else {
					if(10<bef*10+cur && bef*10+cur<=26) {
						//여기 핵심
						dp[i]=(dp[i-1]+dp[i-2])%mod;
					}
					// 그외 예 31 / 36 -> 3-1 / 3- 6 case 1가지
					else {
						dp[i]=dp[i-1]%mod;
					}
				}
			}
		System.out.println(dp[s.length()-1]%mod);
		}
	}
}
