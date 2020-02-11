import java.util.Arrays;

public class Program_Lv1_정수내림차순으로배치하기 {

	class Solution {
		  public long solution(long n) {
		      
		      char[]tmp=Long.toString(n).toCharArray();
		      Arrays.sort(tmp);
		      StringBuilder sb=new StringBuilder();
		      for(int i=tmp.length-1; i>=0; i--)
		          sb.append(tmp[i]);
		      
		          
		      return Long.parseLong(sb.toString());
		  }
		}
}
