import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int k,n;
	static long res;
	static int[]map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		k=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		map=new int[k];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		
		search(1,map[k-1]);
		System.out.println(res);
	}
	
	public static void search(long st, long end) {
		
		//이분탐색 탐색 종료조건!!
		if(st>end)
			return;
		
		long tmp=(st+end)/2;
		//(중요) cnt 오버플로우 조심 길이 2^31-1 랜선 2개를 단위 1로 자를 경우 2*(2^31-1)
		long cnt=0;
		long q=0;
		for (int i = 0; i < map.length; i++) {
			q=map[i]-tmp;
			if(q>0) cnt+=q;
		}
		
		if(n>cnt)
			search(st,tmp-1);
		// n개보다 많이 잘라도 된다 -> 딱 n개로 맞추어 자를 필요가 없다
		else {
			res=Math.max(res, tmp);
			search(tmp+1,end);
		}
	}
}
