import java.util.Scanner;

public class BOJ_1476_날짜계산 {

	static Scanner sc=new Scanner(System.in);
	static int e,s,m;
	static int[][] dp=new int[7981][3];
	
	public static void main(String[] args) {

		// 초기화 작업(mod연산)
		int v=1;
		while(v<7981) {
			
			dp[v][0]=v%15+1;
			dp[v][1]=v%28+1;
			dp[v][2]=v%19+1;
			
			v++;
		}
		
		e=sc.nextInt();
		s=sc.nextInt();
		m=sc.nextInt();
		
		if(e==1 && s==1 && m==1)
			System.out.println(1);
		else {
			for (int i = 1; i <= 7980; i++) {
				int []tmp=dp[i];
				
				if(tmp[0]==e && tmp[1]==s && tmp[2]==m) {
					// 중요!
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}
