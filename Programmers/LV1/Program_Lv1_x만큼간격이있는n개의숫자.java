
public class Program_Lv1_x만큼간격이있는n개의숫자 {
	class Solution {
		  public long[] solution(int x, int n) {
		      long[] ans= new long[n];
		      
		      long tmp=0;
		      for(int i=0; i<n; i++){
		          tmp+=(long)x;
		          ans[i]=tmp;
		      }
		          
		      return ans;
		  }
		}
}
