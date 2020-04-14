import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색 적용을 위해 음수를 양수화
public class BOJ_12738_가장긴증가하는부분수열3 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static final int len=1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int n=Integer.parseInt(br.readLine());
		
		long[]map=new long[n];
		long[]dp=new long[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < map.length; i++) {
			String tmp=st.nextToken();
			int num=0;
			if(tmp.charAt(0)=='-')
				num=len-Integer.parseInt(tmp.substring(1));
			else
				num=len+Integer.parseInt(tmp);
			
			map[i]=num;
		}
		
		dp[0]=map[0];
		int idx=1;
		
		for (int i = 0; i < map.length; i++) {
			if(dp[idx-1]<map[i])
				dp[idx++]=map[i];
			else {
				int tmp=Arrays.binarySearch(dp, 0, idx, map[i]);
				dp[tmp<0? -tmp-1:tmp]=map[i];
			}
		}
		
		System.out.println(idx);
		
	}
}
