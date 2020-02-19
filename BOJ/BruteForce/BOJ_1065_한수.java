import java.util.Scanner;

public class BOJ_1065_한수 {

	static Scanner sc=new Scanner(System.in);
	static int res=0;
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			if(i/100==0)
				res++;
		}
		
		for(int i=100; i<=n; i++) {
			solve(i);
		}
		
		System.out.println(res);
		
	}
	
	public static void solve(int i) {
		String s=Integer.toString(i);
		
		boolean ok=true;
		int tmp=s.charAt(1)-s.charAt(0);
		for (int j = 1; j < s.length()-1; j++) {
			if(s.charAt(j+1)-s.charAt(j)!=tmp) {
				ok=false;
				break;
			}
		}
		
		if(ok)
			res++;
		
	}
}
