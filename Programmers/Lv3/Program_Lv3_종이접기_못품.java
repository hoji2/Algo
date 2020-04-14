import java.util.Arrays;

public class Program_Lv3_종이접기_못품 {

	static String[]dp;
	public static void main(String[] args) {
		
		int n=4;
		
		dp=new String[n+2];
		Arrays.fill(dp,"-1");
		dp[1]="0";
		dp[2]="001";
		
		
		String res=dfs(n+1);
		System.out.println(res);
	}
	
	public static String dfs(int n) {
		
		if(!dp[n-1].equals("-1"))
			return dp[n-1];
		
		StringBuilder sb=new StringBuilder();
		for (int i = dp[n-1].length()-1; i >=0; i--) {
			if(dp[n-1].charAt(i)=='1')
				sb.append('0');
			else
				sb.append('1');
		}
		
		return dp[n]=dfs(n-1)+"0"+sb.toString();
	}
}
