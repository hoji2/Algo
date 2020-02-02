import java.util.Scanner;

public class BOJ_11720_숫자의합 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		sc.nextInt();
		sc.nextLine();
		char[]arr=sc.nextLine().toCharArray();
		
		int res=0;
		
		for (int i = 0; i < arr.length; i++) {
			res+=arr[i]-'0';
		}
		System.out.println(res);
	}
}
