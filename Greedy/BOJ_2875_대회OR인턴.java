import java.util.Scanner;

public class BOJ_2875_대회OR인턴 {

	//https://pledge.tistory.com/entry/%EB%B0%B1%EC%A4%802875-%EB%8C%80%ED%9A%8C-or-%EC%9D%B8%ED%84%B4
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		
		int total=n+m-k;
		int res=0;
		
		// 여자는 0명이나 1명 남은경우 -> 반대 : 여>1 인경우 조합 가능
		// 남자는 0명남은경우 -> 반대 : 남>0 인경우 조합 가능
		// 여+남 2명남은 경우 -> 반대 : 여+남>2 인경우 조합 가능
		// 위 세경우 중 하나라도 만족하면 더이상 조합을 만들 수 없다
		while(n>1 && m>0 && total>2) {
			n-=2;
			m-=1;
			total-=3;
			res++;
		}
		
		System.out.println(res);

	}
}
