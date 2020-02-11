
public class Program_Lv1_다트게임 {

	public static void main(String[] args) {
		
      int[]num=new int[3];
      int cur=-1;
      String s="1D2S#10S";
			      
      for(int i=0; i<s.length(); i++){
          char p=s.charAt(i);
          if(p=='S')
              continue;
          else if(p=='D')
              num[cur]=(int) Math.pow(num[cur],2);
          else if(p=='T')
              num[cur]=(int) Math.pow(num[cur],3);
          else if(p=='*'){
              num[cur]*=2;
              if(cur-1>=0)
                num[cur-1]*=2;
          }else if(p=='#')
              num[cur]*=-1;
          else if(p=='1'){
              if(s.charAt(i+1)=='0'){
                  i++;
                  num[++cur]=10;
              }else{
                  num[++cur]=1;
              }
          }else{
              num[++cur]=(int)p-'0';
          }
      }
      int fin=0;
      for(int i  : num)
    	  fin+=i;
      
      System.out.println(fin);
	}
}
