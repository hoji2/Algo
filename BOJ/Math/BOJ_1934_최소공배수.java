import java.util.Scanner;

public class BOJ_1934_최소공배수 {

	// 최대공약수 : 유클리드호제법
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args){
		
		int t = sc.nextInt();
		
		for(int i = 0 ; i<t; i++) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           int gcd = 0;
           int lcm=0;
           int c = a*b;

           while(b>0) {
        	   gcd = b;
        	   b = a%b;
        	   a = gcd;
           }
           lcm=c/gcd;
           System.out.println(lcm);
       }
	}
}
