import java.util.Scanner;

public class BOJ_1747_소수팰린더룸 {

	static Scanner sc=new Scanner(System.in);
	// (중요)1000000번째 소수는 1000000보다 큰 값이므로 배열의 사이즈를 더 늘려야한다
	static boolean[]prime=new boolean[1004001];
	
	public static void main(String[] args) {
	
		init();
		int n=sc.nextInt();
		
		for (int i = n; i <=1004000; i++) {
			if(!prime[i]) {
				String s1=Integer.toString(i);
				StringBuilder s2=new StringBuilder(s1).reverse();
				if(s1.equals(s2.toString())) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	public static void init() {
		
		prime[1]=true;
		
		for (int i = 2; i <=1004000; i++) {
			if(!prime[i]) {
				for (int j = i+i; j <=1004000; j+=i) {
					prime[j]=true;
				}
			}
		}
	}
}
