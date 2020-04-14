
public class Program_Lv2_탑 {

public int[] solution(int[] h) {
        
        int[]mid=new int[h.length];
        
        for(int i=1; i<h.length; i++){
            int tmp=h[i];
            for(int j=i-1; j>=0; j--){
                if(tmp<h[j]){
                    mid[i]=j+1;
                    break;
                }
            }
        }
        
        return mid;
    }
}
