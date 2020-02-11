import java.util.*;

class Program_Lv1_k번째수 {
	
	public static void main(String[] args) {
		
		int []arr= {1,5,2,6,3,7,4};
		int [][]commands= {{2,5,3},{4,4,1},{1,7,3}};
		
		System.out.println(solution(arr, commands));
	}
	
    public static int[] solution(int[] array, int[][] commands) {

    	// 2차원 배열의 row 만큼 answer 배열 선언
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            // 각 행마다 command 라인을 가져온다
        	int []tmp=commands[i];
            
        	// 배열의 idx 0 부터로 변환
            int st=tmp[0]-1;
            int end=tmp[1]-1;
            int idx=tmp[2]-1;
            
            // sub 배열 선언
            int[]sel=new int[end-st+1];
            
            // 원본 배열 array에서 st~end까지의 값을 sub배열에 넣기
            int p=0;
            for(int j=st; j<=end; j++)
                sel[p++]=array[j];
            
            // sub배열 정렬 후 해당 idx의 값을 answer에 넣어주기
            Arrays.sort(sel);
            answer[i]=sel[idx];
        }
        
        for(int i : answer)
            System.out.println(i);
        
        return answer;
    }
}