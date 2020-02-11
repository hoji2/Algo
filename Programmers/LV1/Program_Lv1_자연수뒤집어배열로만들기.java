
public class Program_Lv1_자연수뒤집어배열로만들기 {

  public int[] solution(long n) {
      char[]tmp=Long.toString(n).toCharArray();
      int []ans=new int[tmp.length];
      
      for(int i=tmp.length-1; i>=0; i--)
          ans[(tmp.length-1)-i]=tmp[i]-'0';
      
      return ans;
  }
  
}
