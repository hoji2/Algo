
public class Program_Lv1_소수찾기 {
	
	class Solution {
		  
	    static boolean[]dp;
	    
	    public int solution(int n) {
	      
	        dp=new boolean[n+1];
	        prime(n);
	        
	        int res=0;
	        
	        for(int i=2; i<=n; i++)
	            if(!dp[i])
	                res++;
	      
	        return res;
	        
	  	}
	    
	  	public void prime(int n){
	   
	        for(int i=2; i<=n; i++){
	            if(!dp[i])
	                for(int j=i+i; j<=n; j+=i)
	                    dp[j]=true;
	        }
	    } 
	}
}
