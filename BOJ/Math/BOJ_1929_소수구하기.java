import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1929_소수구하기 {
	//https://eblee-repo.tistory.com/27
	static Scanner sc=new Scanner(System.in);
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] dp;
	
	public static void main(String[] args) throws IOException {
	
		int st=sc.nextInt();
		int end=sc.nextInt();
		
		dp=new boolean[end+1];
		Arrays.fill(dp, true);
		dp[1]=false;
		draw(end);
		
		for (int i = st; i <=end; i++) {
			if(dp[i])
				bw.write(i+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void draw(int end) {
		
		for (int i = 2; i <=end; i++) {
			if(dp[i]) {
				for (int j = i+i; j <=end; j+=i) {
					dp[j]=false;
				}
			}
		}
	}
}
