import java.util.Scanner;
// http://blog.daum.net/rhaoslikesan/378
// https://junho0956.tistory.com/100?category=825555
public class BOJ_2089_마이너스2진수 {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	
		long n=sc.nextLong();
		
		// 조건 빠트리지 않게 주의!!
		if(n==0)
			System.out.println(0);
		else
			solve(n);
	}
	
	public static void solve(long n) {
		
		if(n==0)
			return;
		
		if(n<0) {
			solve((-1*n+1)/2);
			System.out.print(-1*n%2);
		}else {
			solve(-1*n/2);
			System.out.print(n%2);
		}
	}
}
