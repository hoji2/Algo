import java.util.*;


public class Program_Lv2_최대값과최소값 {

	 public String solution(String s) {
	      
	      StringTokenizer st=new StringTokenizer(s, " ");
	      ArrayList<Integer> tmp=new ArrayList<Integer>();
	      
	      while(st.hasMoreTokens())
	          tmp.add(Integer.parseInt(st.nextToken()));
	      
	      Collections.sort(tmp);
	      
	      StringBuilder sb=new StringBuilder();
	      sb.append(tmp.get(0));
	      sb.append(" ");
	      sb.append(tmp.get(tmp.size()-1));
	      
	      return sb.toString();
	  }
}
