
public class Program_Lv1_2016년 {

	public String solution(int a, int b) {
	      
	      String[]day={"FRI","SAT","SUN","MON","TUE","WED","THU"};
	      int []mon={0,31,29,31,30,31,30,31,31,30,31,30,31};
	      
	      int tmp=0;
	      for(int i=1; i<=a-1; i++)
	          tmp+=mon[i];
	      
	      tmp+=b-1;
	     
	      String answer = day[tmp%7];
	      return answer;
	  }
}
