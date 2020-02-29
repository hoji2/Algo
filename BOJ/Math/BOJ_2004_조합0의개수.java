import java.util.Scanner;

public class BOJ_2004_조합0의개수 {

	//https://kim6394.tistory.com/185
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		long n=sc.nextLong();
		long k=sc.nextLong();
		
		int five=0, two=0;
		
		//25!의 5와 2의 개수 구하기
		five=solve(n,5);
		two=solve(n,2);

		//13!와 12!의 5,2의개수를 뺴주기
		five-=solve(n-k,5);
		five-=solve(k,5);

		two-=solve(n-k,2);
		two-=solve(k,2);

		// 둘중 최소값을 만족하는 수
		System.out.println(Math.min(five, two));
	}
	
	public static int solve(long end, int tmp) {
		
		int mid=0;
		// tmp인 5 or 2 부터 end보다 작은수까지 개수 카운트 -> for문 간격은 곱형태로 나아감
		// 예를들어 end가 5, 25, 125와 같이 나아갈 때
		// end가 5일때 5의 배수를 하나 카운트하고
		// end가 25로넘어가면서 5의배수이면서 25의 배수인 경우 5가 하나 더 있으므로 25/25를 통해 한번더 카운터한다
		// 즉 end가 24일 때에는 4개이지만 end가 25인 경우 5(25/5) + 1(25/25)
		
		for (long i = tmp; i <=end; i*=tmp) {
			mid+=end/i;
		}
		return mid;
	}
}
