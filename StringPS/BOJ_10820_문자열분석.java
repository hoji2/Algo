import java.util.Scanner;
// EOF
// https://mygumi.tistory.com/236
public class BOJ_10820_문자열분석 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(sc.hasNextLine()) {
			String s=sc.nextLine();
			
			char[]arr=s.toCharArray();
			int[]dp=new int[4];
			
			// A : 65, Z : 90, a : 97, z: 122 , " " :32
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]==32)
					dp[3]++;
				else if(65<=arr[i] && arr[i]<=90)
					dp[1]++;
				else if(97<=arr[i] && arr[i]<=122)
					dp[0]++;
				else
					dp[2]++;
			}
			
			for (int i = 0; i < dp.length; i++) {
				System.out.print(dp[i]+" ");
			}System.out.println();
		}
	}
}
