import java.util.Scanner;

public class BOJ_1057_토너먼트 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		int res=-1;
		int time=1;
		
		while(n!=0) {
			
			int a1=a/2;
			int a2=a%2;
			
			int b1=b/2;
			int b2=b%2;
			
			// 만일 a=7 ,b=8
			// a1=3, a2=1
			// b1=4, b2=0
			// a1+a2 == b1+b2 여야 6-7, 8-9 와 같이 떨어지는 경우가 아닌 7,8과 같이 붙어있는상황
			// 이 상황이 아니면 다음라운드로 진출
			
			if(a1+a2==b1+b2) {
				res=time;
				break;
			}
			
			a=a/2+a%2;
			b=b/2+b%2;
			time++;
			if(n%2==0)
				n/=2;
			else
				n=n/2+1;
		}
		
		System.out.println(res);
		
	}
}
