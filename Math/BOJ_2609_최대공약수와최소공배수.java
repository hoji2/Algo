import java.util.Scanner;

public class BOJ_2609_최대공약수와최소공배수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int a=sc.nextInt();
		int b=sc.nextInt();
		int tmp=Math.max(a, b);
		int d=1;
		
		while(true) {
			
			boolean isContinue=false;

			// 두 수중 작은수까지 돌려보면 된다.
			for (int i = 2; i <=Math.min(a,b); i++) {
				if(a%i==0 && b%i==0) {
					a/=i;
					b/=i;
					d*=i;
					isContinue=true;
					break;
				}
			}
			
			if(!isContinue)
				break;
		}
		System.out.println(d);
		System.out.println(d*a*b);
	}
}
