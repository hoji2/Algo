
public class Program_Lv1_제일작은수제거하기 {

	class Solution {
		  public int[] solution(int[] arr) {
		      
		      int[]res;
		      
		      if(arr.length==1){
		          res=new int[1];
		          res[0]=-1;
		          return res;
		      }
		      
		      int idx=0;
		      int min=Integer.MAX_VALUE;
		      res=new int[arr.length-1];
		      
		      for(int i=0; i<arr.length; i++){
		          if(min>=arr[i]){
		              idx=i;
		              min=arr[i];
		          }
		      }
		      
		      int cnt=0;
		      
		      for(int i=0; i<arr.length; i++)
		          if(idx!=i)
		              res[cnt++]=arr[i];
		      
		      
		      return res;
		  }
		}
}
