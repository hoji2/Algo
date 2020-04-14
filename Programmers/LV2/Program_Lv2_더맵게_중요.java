import java.util.*;

public class Program_Lv2_더맵게_중요 {

	// 뽑아놓고 정렬을 여러번 해야하는 상황? -> pq이용하자
	// https://jar100.tistory.com/18

	class Solution {
	    public int solution(int[] map, int K) {
	      
	        PriorityQueue<Integer> tmp=new PriorityQueue<Integer>();
	        
	        for(int i : map)
	            tmp.add(i);
	        
	        int t=0;
	        while(true){
	            // 하나 남았을 때 K보다 큰지 확인이 필요
	        	//https://programmers.co.kr/learn/questions/8457
	            if(tmp.size()==1){
	                if(tmp.peek()>=K)
	                    return t;
	                
	                return -1;
	            }
	            
	            int a1=tmp.poll();
	            int a2=tmp.poll();
	            if(a1>=K)
	                break;
	            
	            tmp.add(a1+2*a2);
	            t++;
	        }
	        
	        return t;
	        
	    }
	}
}
