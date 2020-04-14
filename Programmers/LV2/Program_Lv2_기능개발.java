import java.util.ArrayList;

public class Program_Lv2_기능개발 {

	class Solution {
	    public int[] solution(int[] p, int[] s) {
	        
	        int[]time=new int[p.length];
	        for(int i=0; i<time.length; i++){
	            int r=100-p[i];
	            time[i]=r/s[i];
	            if(r%s[i]!=0)
	                time[i]++;
	        }
	        
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        int cnt=1;
	        int limit=time[0];
	        for(int i=1; i<time.length; i++){
	            if(limit>=time[i])
	                cnt++;
	            else{
	                res.add(cnt);
	                cnt=1;
	                limit=time[i];
	            }
	        }
	        // 마지막 cnt add
	        res.add(cnt);
	        int[]fin=new int[res.size()];
	        for(int i=0; i<fin.length; i++)
	            fin[i]=res.get(i);
	            
	        return fin;
	    }
	}
}
