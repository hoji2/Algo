import java.util.Arrays;

public class Program_Lv1_예산 {

	class Solution {
		  public int solution(int[] d, int budget) {
		      
		     Arrays.sort(d);
		     int cnt=0;
		     
		      for(int i=0; i<d.length; i++){
		          budget-=d[i];
		          if(budget<0)
		              break;
		          cnt++;
		      }
		     return cnt;
		  }
		}
}
