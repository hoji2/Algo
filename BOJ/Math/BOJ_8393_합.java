import java.util.Scanner;

public class BOJ_8393_합 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
	
		int res=0;
		int st=sc.nextInt();
		
		for (int i = st; i >=1; i--) {
			res+=i;
		}
		
		System.out.println(res);
	}
}
