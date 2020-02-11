
public class Program_Lv1_평균구하기 {
	class Solution {
		  public double solution(int[] arr) {
		     
		     double tmp=0;
		      
		    for(int k : arr)
		        tmp+=k;
		      
		      return (double)tmp/arr.length;
		  }
		}
}
