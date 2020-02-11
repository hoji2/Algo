import java.util.*;

public class Program_Lv1_문자열내마음대로정렬하기 {

	 public String[] solution(String[] strings, int n) {
	      
	      Comparator<String>comp=new Comparator<String>(){
	          public int compare(String o1, String o2){
	              
	              if(o1.charAt(n)==o2.charAt(n))
	                  return o1.compareTo(o2);
	              
	              return o1.charAt(n)-o2.charAt(n);
	          }
	      };
	      
	      Arrays.sort(strings,comp);
	      
	      return strings;
	  }
}
