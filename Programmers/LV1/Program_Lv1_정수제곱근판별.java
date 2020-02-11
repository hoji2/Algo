
public class Program_Lv1_정수제곱근판별 {
	 public long solution(long n) {
	      
	      long tmp=(int)Math.sqrt(n);
	      
	      if(tmp*tmp==n)
	          return (tmp+1)*(tmp+1);
	      
	      return -1;
	  }
}
