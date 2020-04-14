
public class Program_Lv2_피보나치수 {

	// fibo 입력이 큰 경우 재귀방식 시 메모리초과
	// for문 형태로 구현
	// https://sas-study.tistory.com/250
	public static void main(String[] args) {
		
		int n=100;
		
		// 현재구하려는 수 c, 바로이전 수 b, 2단계 이전 수 a
		int a=0;
		int b=1;
		int c=0;
		
		for (int i = 2; i <=n; i++) {
			c=(a+b)%1234567;
			// a와 b를 한단 계 앞으로 땡기는 작업
			// a <-b / b <-c
			a=b%1234567;
			b=c%1234567;
		}
		
		System.out.println(c);
	}
	
}
