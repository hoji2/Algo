import java.util.Scanner;

public class BOJ_10872_팩토리얼 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		System.out.println(solve(sc.nextInt()));
	}
	
	public static int solve(int n) {
		if(n<=1)
			return 1;
			 
		return n*solve(n-1);
	}
}
