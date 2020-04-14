
public class Program_Lv2_주식가격 {

	class Solution {
	    public int[] solution(int[] p) {
	        
	        int[]res=new int[p.length];
	        
	        for(int i=0; i<p.length; i++){
	            int cur=p[i];
	            int tmp=1;
	            for(int j=i+1; j<p.length-1; j++){
	                if(cur>p[j])
	                    break;
	                tmp++;
	            }
	            res[i]=tmp;
	        }
	        // 마지막은 감소한 경우가 없다
	        res[p.length-1]=0;
	        
	        return res;
	    }
	}
}
