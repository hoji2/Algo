
public class Program_Lv1_핸드폰번호가리기 {

	class Solution {
		  public String solution(String s) {
		      
		      int front=s.length()-4;
		      StringBuilder sb=new StringBuilder();
		      
		      for(int i=0; i<front; i++)
		        sb.append('*');
		      
		      sb.append(s.substring(front,s.length()));
		          
		      return sb.toString();
		  }
		}		
}
