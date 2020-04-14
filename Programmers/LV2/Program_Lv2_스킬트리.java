import java.util.HashMap;
import java.util.Map;

public class Program_Lv2_스킬트리 {

	class Solution {
	    public int solution(String s, String[] arr) {
	      
	        int res=0;
	        Map<Character, Integer>order=new HashMap<Character,Integer>();
	        
	        for(int i=0; i<s.length(); i++)
	            order.put(s.charAt(i),i);
	        
	        for(String p : arr){
	            int idx=0;
	            boolean fail=false;
	            
	            for(int i=0; i<p.length(); i++){
	                char tmp=p.charAt(i);
	                if(order.containsKey(tmp)){
	                    if(order.get(tmp)==idx){
	                        idx++;
	                    }else{
	                        fail=true;
	                        break;
	                    }
	                }
	            }
	            
	            if(!fail)
	                res++;       
	        }
	        
	        return res;
	    }
	}
}
