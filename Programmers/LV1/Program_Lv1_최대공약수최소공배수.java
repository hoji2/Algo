
public class Program_Lv1_최대공약수최소공배수 {
	class Solution {
		  public int[] solution(int a, int b) {
		      
		      int[] res=new int[2];
		      int gcd=0;
		      int lcm=0;
		      int c=a*b;
		      
		      while(b>0){
		          gcd=b;
		          b=a%b;
		          a=gcd;
		      }
		      
		      res[0]=gcd;
		      res[1]=c/gcd;
		      
		      return res;
		  }
		}
}
