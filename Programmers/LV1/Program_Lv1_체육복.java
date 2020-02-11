import java.util.*;

class Program_Lv1_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        
    	// idx n까지 사용
        int[]tot=new int[n+1];
        
        // 일단 다 있다고 초기화
        Arrays.fill(tot,1);
        
        // 잃어버린 애들은 0
        for(int j : lost)
            tot[j]=0;
        
        // 여유분 있는애들은 증가
        for(int i : reserve)
            tot[i]++;   
        
        // 필요없는 tot[0]=0
        tot[0]=0;
        
        // 전제조건 크게 2가지
        // 1) 순회할때마다 tot[j]==0인지 유무 파악 -> 이 조건을 뺴먹으면 초기 lost였던 사람이 2개를 받을 수 있다.
        // 2) 각 임계점 j>=1 , j<=n-1 조건 필요 -> 배열 범위 벗어날 수 있음
        for(int j : lost){
            if(tot[j]==0 && j>=1 && tot[j-1]>1){
                tot[j-1]--;
                tot[j]=1;
            }else if(tot[j]==0 && j<=n-1 && tot[j+1]>1){
                tot[j+1]--;
                tot[j]=1;
            }   
        }
        
        int answer = 0;
        
        for(int i : tot)
            if(i>=1)
                answer++;
        
        return answer;
    }
}