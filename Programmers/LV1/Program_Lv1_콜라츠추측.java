
public class Program_Lv1_콜라츠추측 {

	// long으로 선언 -> 오버플로우 가능성 있음
	class Solution {
		  public int solution(int num) {
		      
		      int cnt=0;
		      long n=(long)num;
		      
		      boolean success=false;
		      while(cnt<=500){
		          if(n==1){
		              success=true;
		              break;
		          }
		              
		          if(n%2==0)
		              n/=2;
		          else
		              n=n*3+1;

		          cnt++;
		      }
		      if(success)
		          return cnt;
		      else
		          return -1;
		  }
		}
}

