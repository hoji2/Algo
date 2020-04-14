
public class Program_Lv2_숫자의표현 {

	public int solution(int n) {
	      
	      int res=0;
	      
	      for(int i=1; i<=n; i++){
	          int tmp=0;
	          int idx=i;
	          while(tmp<=n){
	              if(tmp==n){
	                  res++;
	                  break;
	              }
	              tmp+=idx++;
	          }
	      }
	      return res;
	  }
}
