import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int res=0;
		
		// 5의 배수개를 샌다
		//ex) 125는 5*5*5 즉 0 3개를 만들수 있따, 120 -> 24*5 : 1개
		for (int i = n; i >=1; i--) {
			if(i%5==0) {
				int j=i;
				while(j%5==0) {
					res++;
					j/=5;
				}
			}
		}
		System.out.println(res);
	}
}
