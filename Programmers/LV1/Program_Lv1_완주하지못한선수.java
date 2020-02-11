import java.util.*;

//https://dreamhollic.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B45-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98-JAVA
class Program_Lv1_완주하지못한선수 {
	
//    public String solution(String[] participant, String[] completion) {
//        
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        
//        int i;
//        for(i=0; i<completion.length; i++){
//            if(!participant[i].equals(completion[i])){
//                return participant[i];
//            }
//        }
//        
//        return participant[i];
//    }
    
public String solution(String[] participant, String[] completion) {
        
       HashMap<String, Integer> map=new HashMap<String, Integer>();
       
       for(String s : participant) {
    	   if(map.containsKey(s)) {
    		   map.put(s, map.get(s)+1);
    	   }else
    		   map.put(s, 1);
       }
       
       int t=0;
       
       for(String c : completion) {
    	   t=map.get(c)-1;
    	   map.put(c, t);
       }
       
       for(String c : map.keySet()) {
    	   if(map.get(c)==1)
    		   return c;
       }
        
      
       return "";
       
    }
    
}