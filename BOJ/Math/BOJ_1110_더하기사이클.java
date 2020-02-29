import java.util.Scanner;

public class BOJ_1110_더하기사이클 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int find=n;
		int cycle=1;
		
		while(true) {
			if(n/10==0)
				n=11*n;
			else {
				int tmp=n/10+n%10;
				n=(n%10)*10+tmp%10;
			}
			
			if(n==find)
				break;
			
			cycle++;
		}
		System.out.println(cycle);
	}
}
