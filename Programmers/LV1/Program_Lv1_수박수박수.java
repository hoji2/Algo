
public class Program_Lv1_수박수박수 {
	  public String solution(int n) {
	      
	      boolean add=false;
	      if(n%2==1)
	          add=true;
	      
	      n/=2;
	      
	      StringBuilder sb=new StringBuilder();
	      for(int i=1; i<=n; i++)
	          sb.append("수박");
	      
	      if(add)
	          sb.append("수");
	      
	      return sb.toString();
	  }
}
