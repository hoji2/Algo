import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_9480 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			
			int size=Integer.parseInt(br.readLine());
			String[]arr=new String[size];
			String[]dp=new String[size];
			int res=0;
			
			for (int i = 0; i < size; i++) {
				arr[i]=br.readLine();
			}
			
			for (int i = 0; i < (1<<size); i++) {
				int cnt=0;
				for (int j = 0; j < size; j++) {
					if((i & (1<<j))==(1<<j)) {
						dp[cnt++]=arr[j];
					}
				}
				
				if(solve(dp,cnt))
					res++;
			}
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static boolean solve(String[]dp, int cnt) {
		
		if(cnt==0)
			return false;
		
		boolean []alpa=new boolean[26];
		int add=0;
		
		for (int i = 0; i < cnt; i++) {
			for(char p : dp[i].toCharArray()) {
				if(!alpa[p-97]) {
					alpa[p-97]=true;
					add++;
				}
			}
		}
		if(add==26)
			return true;
		else
			return false;
	}
}
