import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {

	//https://minwoo-kang.github.io/A_2110/
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n,k,res=0;
	static int[]map;
	static ArrayList<Integer> tmp=new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		map=new int[n];
		res=0;
		for (int i = 0; i < n; i++) {
			map[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(map);
		//(중요!!) 최소거리와 최대거리가 된다 -> 공유기간 최소거리 1, 공유기간 최대거리 두집의 가장 긴 거리
		search(1,map[n-1]-map[0]);
		System.out.println(res);
	}
	
	public static void search(int st, int end) {
		if(st>end)
			return;
		
		// 공유기 거리
		int tmp=(st+end)/2;
		
		int start=map[0];
		int cnt=1;
		
		for (int i = 1; i < n; i++) {
			if(map[i]-start>=tmp) {
				cnt++;
				start=map[i];
			}
		}
		
		// 공유기의 거리를 늘려도 되는 경우
		if(cnt>=k) {
			res=Math.max(res, tmp);
			search(tmp+1,end);
		}
		// 공유기의 거리를 binarysearch로 줄여야 한다.
		else
			search(st,tmp-1);
		
	}
}
