
public class Program_Lv1_가운데글자가져오기 {

	// subString 풀이
	// return word.substring((word.length()-1) / 2, word.length()/2 + 1);   
	 public String solution(String s) {
	      
	      int size=s.length();
	      String answer="";
	      if(size%2==1)
	          answer=s.charAt(size/2)+"";
	      else{
	          answer=s.charAt(size/2-1)+""+s.charAt(size/2)+"";
	      }
	      return answer;
	  }
}
