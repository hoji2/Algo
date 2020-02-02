import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n,res;
	static int [][]map;
	static boolean []visit;
	
	public static void main(String[] args) throws IOException {
	
		n=stoi(br.readLine());
		map=new int[n][n];
		visit=new boolean[n];
		res=Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int idx=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				map[i][idx++]=stoi(st.nextToken());
		}
		
		// 출발 지점이 정해져있지 않으므로 모든 정점을 시작으로 순회한다
		for (int i = 0; i < n; i++) {
			solve(i,i,0,0);
		}
		
		System.out.println(res);
	}
	
	public static void solve(int start, int end, int cost, int cnt) {
		
		
		for (int i = 0; i < n; i++) {
			// 초기시작 시 다른정점을 모두 순회하기 전에 자기 자신으로 들어오는 경우 제외 map[start][i]!=0
			// 방문하지 않은 정점 방문
			if(map[start][i]!=0 && !visit[i]) {
				// 만약 도착지점에 방문하지 않은경우 cost 및 카운트를 갱신하여 다음 탐색
				if(i!=end) {
					visit[i]=true;
					solve(i,end,cost+map[start][i],cnt+1);
					visit[i]=false;
				}
				// 도착지점에 방문했을 때 도착지점 제외 총 n-1번 방문한 경우 모든 정점을 순회하고 자기자신으로 돌아오는 경우이다
				// res값의 min값 갱신
				else {
					if(cnt==n-1) {
						res=Math.min(res, cost+map[start][i]);
						return;
					}
				}
			}
		}
		
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
