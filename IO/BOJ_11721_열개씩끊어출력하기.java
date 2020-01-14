import java.util.Scanner;

public class BOJ_11721_열개씩끊어출력하기 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		/*
		- SubString(st, end) : charAt(st)~charAt(end-1)까지 출력
		 
			- String : charAt기준 charAt(0)~charAt(S.length()-1)
			- 10개씩 끊는다면 loop를 구해야 한다
			- loop=s.length()/10
			- 마지막 루프에서는 10개가 다 안된다면 s.length()까지 substring
		 */
		
		
		String s=sc.nextLine();
		int loop=s.length()/10;

		for (int i = 0; i <= loop; i++) {
			if(i==loop)
				System.out.println(s.substring(i*10, s.length()));
			else
				System.out.println(s.substring(i*10,(i+1)*10));
		}
	}
}
