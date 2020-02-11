import java.util.Arrays;

public class Program_Lv1_실패율_어렵 {

	class Solution {
	    
	    public int[] solution(int N, int[] stages) {
	        
	        double[]tmp=new double[N+2];
	        double[]res=new double[N+2];
	        
	        for(int i=0; i<stages.length; i++)
	            tmp[stages[i]]++;
	        
	        double cnt=stages.length;
	        
	        for(int i=1; i<=N; i++){
	            if(cnt==0)
	                res[i]=0;
	            else{
	                res[i]=tmp[i]/cnt;
	                cnt-=tmp[i];    
	            }
	        }
	        
	        for(int i=1; i<=N; i++)
	            tmp[i]=res[i];
	        
	        res[0]=-1;
	        tmp[0]=-1;
	        
	        Arrays.sort(tmp);
	       
	        int[]fin=new int[N];
	        int idx=0;
	        for(int i=N+1; i>=1; i--){
	            double p=tmp[i];
	            for(int j=1; j<=N; j++){
	                if(p==res[j]){
	                    fin[idx++]=j;
	                    res[j]=-1;
	                    break;
	                }
	            }
	        }
	        
	        return fin;
	    }
	}
}
