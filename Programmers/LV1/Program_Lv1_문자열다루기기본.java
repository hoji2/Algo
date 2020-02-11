
public class Program_Lv1_문자열다루기기본 {

	 public boolean solution(String s) {
	      
	      if(s.length()!=4 && s.length()!=6 )
	          return false;
	      
	      char[]p=s.toCharArray();
	      
	      for(char q : p)
	          if((int)q >=65)
	              return false;
	      
	      return true;
	  }
	
}
