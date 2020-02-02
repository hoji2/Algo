import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로{

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n;
	// n*2 이중 연결리스트 보다 int[n][n]이 더 효율적 (인접행렬로 하니 안터짐)
	static int[][]map;
	static Comparator<point> comp;
	static int[][]info;
	static boolean[]visit;
	static boolean noway;
	// 총 2번의 다익스트라 순회한 정보를 더해나갈 res 배열
	// n,v가 커지면 int 터질 수 있음
	static long[]res=new long[2];
	
	public static void main(String[] args) throws IOException {
		/*
		# 다익스트라 순회 정보 저장
		(1, mid1, mid2, n)
		(1, mid2, mid1, n)
		 */
		info=new int[2][4];
		// map 갱신
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		map=new int[n+1][n+1];
		int v=Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < v; i++) {
			st=new StringTokenizer(br.readLine());
			
			int p1=Integer.parseInt(st.nextToken());
			int p2=Integer.parseInt(st.nextToken());
			int p3=Integer.parseInt(st.nextToken());

			map[p1][p2]=p3;
			map[p2][p1]=p3;
		}
		
		// info setting
		st=new StringTokenizer(br.readLine());
		int mid1=Integer.parseInt(st.nextToken());
		int mid2=Integer.parseInt(st.nextToken());

		for (int i = 0; i < 2; i++) {
			info[i][0]=1;
			info[i][3]=n;
		}	
		info[0][1]=mid1;
		info[0][2]=mid2;
		info[1][1]=mid2;
		info[1][2]=mid1;

		comp=new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				return (int)o1.val-(int)o2.val;
			}
		};
		
		// 다익스트라 탐색 6번
		// noway boolean을 통해 연결될 수 없는 경우는 순회정지
		for (int i = 0; i < 2; i++) {
			noway=false;
			for (int j = 0; j <=2; j++) {
				if(!noway)
					solve(i,info[i][j],info[i][j+1]);
			}
		}
	

		// fin이 유효한 값이 아닌 경우 (0 포함 -> 끊켜서 순회할 수없는 경우)
		long fin=Math.min(res[0],res[1]);
		if(fin>=Long.MAX_VALUE || fin<=0)
			System.out.println(-1);
		else
			System.out.println(fin);
	}
	
	public static void solve(int order, int st, int end) {
		
		long[]dp=new long[n+1];
		
		//dp 초기세팅
		for (int i = 1; i <= n; i++) {
			if(i==st)
				dp[i]=0;
			else
				dp[i]=Long.MAX_VALUE;
		}
		
		//pq 세팅
		Queue<point> pq=new PriorityQueue<point>(comp); 
		
		pq.add(new point(st, 0));
		
		while(!pq.isEmpty()) {
			point p=pq.poll();
			
			for (int i = 1; i <=n; i++) {
				
				if(map[p.num][i]!=0) {
					long tmp1=dp[i];
					long tmp2=dp[p.num]+map[p.num][i];
					dp[i]=Math.min(tmp1, tmp2);
					if(tmp1!=dp[i]) {
						pq.add(new point(i, dp[i]));
					}
				}
			}
		}
		
		// st~end 까지 최소값으로 갈 수 없는 경우면 그 경로 루프순회를 그만 탐색
		if(dp[end]>=Long.MAX_VALUE || dp[end]<0) {
			noway=true;
			return;
		}
		
		// 모두 순회 후 res에 저장
		res[order]+=dp[end];
	}
	
}

class point{
	int num;
	long val;
	
	public point(int num, long val) {
		this.num=num;
		this.val=val;
	}
}
