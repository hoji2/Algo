import java.util.*;

public class Program_Lv2_위장 {

	//https://developerdk.tistory.com/12
	class Solution {
	    public int solution(String[][] clothes) {
	        HashMap<String, Integer> hm = new HashMap<String, Integer>();
	 
	        for (int i = 0; i < clothes.length; i++) {
	            if (hm.containsKey(clothes[i][1]))
	                hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
	            else
	                hm.put(clothes[i][1], 1);
	        }
	 
	        int answer = 1;
	        for (int value : hm.values()) {
	            answer*=(value+1);
	        }
	        answer-=1;
	 
	        return answer;
	    }
	}
}
