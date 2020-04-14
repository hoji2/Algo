import java.util.Scanner;

public class Program_Lv2_124나라의숫자_중요 {

	//https://www.mstst33.com/programmers-figure-of-124-country/174/
	class Solution {
		  public String solution(int n) {
		      
		      int[]arr={1,2,4};
		      
		      StringBuilder sb=new StringBuilder();
		      
		      while(n>0){
		          if(n%3==0){
		              sb.append(4);
		              n/=3;
		              n--;
		          }
		        else{
		            sb.append(n%3);
		            n/=3;
		          }
		      }
		      return sb.reverse().toString();
		  }
		}
}
