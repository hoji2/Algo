import java.util.Scanner;

public class BOJ_1476_날짜계산최적화 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		int e=sc.nextInt();
		int s=sc.nextInt();
		int m=sc.nextInt();

		// 방법 1)
		// https://jaemin8852.tistory.com/247
		// 우리의 년도 k=(15*n+e)+(28*n+s)+(19*n+m)
		// 따라서 k-e, k-s, k-m 가  각각 15, 28, 19와 모두 나누어 떨어지는 수 구하기
		int k=1;
		while(true) {
			if((k-e)%15==0 && (k-s)%28==0 && (k-m)%19==0){
				System.out.println(k);
				break;
			}
			k++;
		}
		// 방법 2)
		// https://codedrive.tistory.com/152
		// https://goscala.tistory.com/206
		long x=((e*6916+s*4845+m*4200)%7980);
		
		if(x==0)
			System.out.println(7980);
		else
			System.out.println(x);
		
	}
}
