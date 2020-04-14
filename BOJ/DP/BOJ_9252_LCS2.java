import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://octorbirth.tistory.com/96
public class BOJ_9252_LCS2 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		String s1=br.readLine();
		String s2=br.readLine();
		
		int size=Math.max(s1.length(), s2.length());
		
		int[][]dp=new int[s2.length()+1][s1.length()+1];
		String[]res=new String[size+1];
		
		for (int i = 1; i <= s2.length(); i++) {
			for (int j = 1; j <= s1.length(); j++) {
				if(s2.charAt(i-1)==s1.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				
			}
		}
		
		StringBuilder sb=new StringBuilder();
		int dx=s2.length();
		int dy=s1.length();
		
		while(!(dx==0 || dy==0)) {
			if(s2.charAt(dx-1)==s1.charAt(dy-1)) {
				sb.append(s2.charAt(dx-1));
				dx--;
				dy--;
			}
			else if(dp[dx][dy]==dp[dx-1][dy])
				dx--;
			else if(dp[dx][dy-1]==dp[dx][dy-1])
				dy--;
		}
		System.out.println(dp[s2.length()][s1.length()]);
		System.out.println(sb.reverse().toString());
	}
}
