import java.util.ArrayList;
import java.util.Arrays;

public class Program_Lv3_N으로표현_못품 {

	// !! 연산기호에 dp 초점 맞추기
	// 연산 개수가 1~8인경우
	
	public static void main(String[] args) {
		int n=2;
		int num=11;
		
		ArrayList<ArrayList<Integer>> tmp=new ArrayList<ArrayList<Integer>>();
		int idx=1;
		int p=n;
		
		for (int i = 0; i <=8; i++) {
			
		}
		
		while(true) {
			if(p>32000)
				break;
			dp[p]=idx;
			p=(int) (p*10+n);
			idx++;
		}
		
		for(int i=1; i<=8; i++) {
			
		}
		
		
		
	}
	
}
