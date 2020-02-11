import java.util.*;

public class Program_Lv1_나누어떨어지는숫자배열 {

	// array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
	// return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
	
	 public int[] solution(int[] arr, int divisor) {

	      Arrays.sort(arr);
	      ArrayList<Integer> tmp=new ArrayList<Integer>();

	      for(int i: arr)
	          if(i%divisor==0)
	              tmp.add(i);

	      int []ans;

	      if(tmp.size()==0){
	          ans=new int[1];
	          ans[0]=-1;
	      }

	      else{
	          ans=new int[tmp.size()];
	          for(int i=0; i<ans.length; i++)
	              ans[i]=tmp.get(i);
	      }

	      return ans;
	  }

}
