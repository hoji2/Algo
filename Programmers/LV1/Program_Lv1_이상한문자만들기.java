
public class Program_Lv1_이상한문자만들기 {

 public String solution(String s) {
	 // 반환될 배열의 limit 크기 파라미터 -> -1 -> 0보다 작은 정수를 주면 모든 구분값을 나눠서 배열로 변환
      String[]p=s.split(" ",-1);
      
      StringBuilder sb=new StringBuilder();
   
      for(int j=0; j<p.length; j++){
    	  
          char[]tmp=p[j].toCharArray();
          
          for(int i=0; i<tmp.length; i++){
          char q=tmp[i];

          if(i%2==0 && (int)q>=97 && (int)q<=122)
              q-=32;
          else if(i%2==1 && (int)q<=90 && (int)q>=65)
              q+=32;
         
          sb.append(q);
          }
          
          if(j!=p.length-1)
            sb.append(' ');
      }
      return sb.toString();
  }
}
