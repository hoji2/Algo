import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://code0xff.tistory.com/70
public class BOJ_12015_가장긴증가하는부분수열2_nlogn {

	// 입력 1000000 -> n제곱으로 풀수 없음
	// binarySerach로 nlogn
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int n=Integer.parseInt(br.readLine());
		int[]map=new int[n];
		int[]dp=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for (int i = 0; i < map.length; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}

		dp[0]=map[0];
		int idx=1;
		
		for (int i = 0; i < map.length; i++) {

			if(dp[idx-1]<map[i])
				dp[idx++]=map[i];
			else {
				int tmp=Arrays.binarySearch(dp, 0, idx, map[i]);
				
				dp[tmp<0 ? -tmp-1:tmp]=map[i];
			}
		}
		System.out.println(idx);
	}
}
