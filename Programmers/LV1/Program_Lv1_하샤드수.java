
public class Program_Lv1_하샤드수 {
	class Solution {
		  public boolean solution(int x) {
		      String s=Integer.toString(x);
		      
		      int tmp=0;
		      for(int i=0; i<s.length(); i++)
		          tmp+=s.charAt(i)-'0';
		      
		      if(x%tmp==0)
		          return true;
		      
		      return false;
		  }
		}
}
