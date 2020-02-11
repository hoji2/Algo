
public class Program_Lv1_시저암호 {
	class Solution {
		  public String solution(String s, int n) {
		      char[] tmp=s.toCharArray();
		      char[] low=new char[26];
		      char[] high=new char[26];
		      
		      int v1=65;
		      int v2=97;
		      for(int i=0; i<=25; i++){
		          high[i]=(char)(v1);
		          low[i]=(char)(v2);
		          v1++;
		          v2++;
		      }
		      
		      for(int i=0; i<tmp.length; i++){
		          if(tmp[i]==' ')
		              continue;
		          int q=0;
		          
		          if(tmp[i]>=65 && tmp[i]<97){
		              q=tmp[i]-65;
		              tmp[i]=high[(q+n)%26];
		          }else{
		              q=tmp[i]-97;
		              tmp[i]=low[(q+n)%26];
		          }
		          
		      }
		      StringBuilder sb=new StringBuilder();
		      for(char t : tmp)
		          sb.append(t);
		      return sb.toString();
		  }
		}
}
