import java.util.Scanner;

public class BOJ_1120_문자열 {

	// https://m.blog.naver.com/PostView.nhn?blogId=tlstjd436&logNo=221570508993&proxyReferer=https%3A%2F%2Fwww.google.com%2F
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String a=sc.next();
		String b=sc.next();
		int cnt=b.length()-a.length();
		int res=Integer.MAX_VALUE;
		
		int idx=0;
		
		while(true) {
			if(idx+a.length()>b.length())
				break;
			
			int tmp=0;
			for (int i = 0; i < a.length(); i++) {
				if(a.charAt(i)!=b.charAt(i+idx))
					tmp++;
			}
			
			res=Math.min(res, tmp);
			idx++;
			
		}
		
		System.out.println(res);
	}
}
