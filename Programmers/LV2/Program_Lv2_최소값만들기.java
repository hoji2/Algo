import java.util.Arrays;

public class Program_Lv2_최소값만들기 {

	public int solution(int []A, int []B)
    {
       
        Arrays.sort(A);
        Arrays.sort(B);
        int res=0;
        // 정렬 후 한쪽에서 max값 * 다른 한쪽에서 min값
        for(int i=0; i<A.length; i++)
            res+=A[A.length-1-i]*B[i];
        
        return res;
        
    }
}
