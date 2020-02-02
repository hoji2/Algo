import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int k,num,start=0,cnt;
	static int[]map;
	
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		k=stoi(st.nextToken());
		num=stoi(st.nextToken());
		
		map=new int[k];
		
		for (int i = 0; i < k; i++) {
			map[i]=stoi(br.readLine());
			// i번째 동전이 가장 큰 금액으로 나눌 수 있는 동전이며 시작점이다
			if(num/map[i]!=0)
				start=i;
		}
		
		solve();
		System.out.println(cnt);
	}
	
	public static void solve() {
		if(num==0)
			return;
		
		// 동전의 개수 tmp
		int tmp=num/map[start];
		cnt+=tmp;
		// 거스름돈 계산
		num-=tmp*map[start];
		
		// 그 다음으로 큰 동전으로 넘어가서
		start--;
		
		// 가장 큰 금액으로 나눌 수 있는 동전을 찾아 재귀호출
		// 0번째 동전까지 순회하면서 동전으로 나눈 후 return
		while(start>=0) {
			if(num/map[start]!=0)
				solve();
			start--;
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
