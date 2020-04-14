
public class Program_Lv3_2xn타일링_재귀호출많을시for문으로 {

	class Solution {
	    
	  public int solution(int n) {
	      
	      int[] dp=new int[n+1];
	      int max=1000000007;
	      if(n==1)
	          return 1;
	      else if(n==2)
	          return 2;
	      else{
	          // dp 재귀호출이 많으면 for문으로 처리하자
	          dp[1]=1;
	          dp[2]=2;
	          for(int i=3; i<=n; i++)
	              dp[i]=(dp[i-1]+dp[i-2])%max;
	          
	          return dp[n];
	      }
	  }
	}
	
}
