import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10953_A더하기B_6 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
	
		//sc.nextInt() 다음에 sc.nextLine()이 오면 개행문자 처리해주어야함
		int tc=sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < tc; i++) {
			// StringTocker 식별자 포함옵션 -> defalut: false
			StringTokenizer st=new StringTokenizer(sc.nextLine(), ",");
			System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
		}
	}
}
