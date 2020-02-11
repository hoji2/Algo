
public class Program_Lv1_약수의합 {

class Solution {
	  public int solution(int n) {
	      
	      int loop=(int)Math.sqrt(n);
	      int ans=0;
	      
	      if(n==0)
	          return 0;
	      
	      for(int i=1; i<=loop; i++)
	          if(n%i==0){
	              ans+=i+(n/i);
	          }
	      // 제곱수처리
	      if(loop*loop==n)
	          ans-=loop;
	      
	      return ans;
	  }
	}
}
