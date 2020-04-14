import java.util.Arrays;
import java.util.Comparator;

//https://lkhlkh23.tistory.com/102
public class Program_Lv2_가장큰수_중요 {

	class Solution {
		  
	    public String solution(int[] num) {
	        
	        String[]s=new String[num.length];
	        for(int i=0; i<num.length; i++)
	            s[i]=Integer.toString(num[i]);
	        
	        // {6, 10,2} -> 610 vs 106 -> 6, 10
	        Arrays.sort(s, new Comparator<String>(){
	           
	            public int compare(String o1, String o2){
	                return (o2+o1).compareTo(o1+o2);
	            }
	        });
	        
	        StringBuilder sb=new StringBuilder();
	        // 0이 맨 앞에있을 경우(sb에 들어간 게 있으면 0이아닌 숫자가 들어가 있으므로 add)
	        for(String p : s){
	            if(p.equals("0")){
	                if(sb.length()==0)
	                    continue;
	                else
	                    sb.append(p);
	            }else
	                sb.append(p);
	        }
	        
	        // 만일 모든 입력이 0이라서 sb에 들어간 게 없으면 답은 0
	        if(sb.length()==0)
	            sb.append("0");
	        
	        return sb.toString();
	    }
	}
}
