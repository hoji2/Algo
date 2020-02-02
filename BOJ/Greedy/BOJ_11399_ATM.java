import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int n=stoi(br.readLine());
		int[]dp=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int idx=0;
		
		while(st.hasMoreTokens())
			dp[idx++]=stoi(st.nextToken());
		
		
		quick(dp,0,dp.length-1);
		
		idx=0;
		
		for (int i = 0; i < dp.length; i++) {
			idx+=(dp.length-i)*dp[i];
		}
		
		System.out.println(idx);
		
		
		
	}
	
	public static void quick(int[]dp, int low, int high) {
		int i=low;
		int j=high;
		int pivot=dp[(i+j)/2];
		//swap
		int tmp;
		
		while(i<=j) {
			
			while(dp[i]<pivot)
				i++;
			
			while(dp[j]>pivot)
				j--;
			
			if(i<=j) {
				tmp=dp[i];
				dp[i]=dp[j];
				dp[j]=tmp;
				i++;
				j--;
			}
		}
		
		if(low<j)
			quick(dp,low,j);
		
		if(high>i)
			quick(dp,i,high);
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
