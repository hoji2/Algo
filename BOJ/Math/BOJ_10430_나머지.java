import java.util.Scanner;

public class BOJ_10430_나머지 {

	// 원리를 알자
	// https://velog.io/@jakeseo_me/Algorithm-Study-4-Mathematics
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		System.out.println((a+b)%c);
		System.out.println((a%c+b%c)%c);
		System.out.println((a*b)%c);
		System.out.println(((a%c)*(b%c))%c);
	}
}
