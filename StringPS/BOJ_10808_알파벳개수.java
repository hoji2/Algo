import java.util.Scanner;

public class BOJ_10808_알파벳개수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		char[]arr=sc.nextLine().toCharArray();
		
		//a :97, z : 122
		int []dp=new int[26];
		
		for (int i = 0; i < arr.length; i++) {
			dp[arr[i]-97]++;
		}
		
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+" ");
		}
	}
}
