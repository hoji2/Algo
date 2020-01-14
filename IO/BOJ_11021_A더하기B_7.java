import java.util.Scanner;

public class BOJ_11021_A더하기B_7 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			System.out.println("Case #"+i+": "+(sc.nextInt()+sc.nextInt()));
		}
	}
}
