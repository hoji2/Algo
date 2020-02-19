package swea;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16959_체스판여행1 {

	static Scanner sc=new Scanner(System.in);
	static int n, res;
	static int[][]knight= {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	static int[][]bishop= {{-1,-1},{-1,1},{1,-1},{1,1}};
	static int[][]look= {{-1,0},{0,-1},{0,1},{1,0}};
	static int[][]map;
	static int[][][][]dp;
	static Queue<point> tmp=new LinkedList<point>();
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		map=new int[n][n];
		// row, col, 시작점t(도착점은 t+1로 계산), horse;
		dp=new int[n][n][n*n][3];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n*n; k++) {
					for (int l = 0; l < 3; l++) {
						dp[i][j][k][l]=-1;
					}
				}
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// map을 0부터로 변환
				map[i][j]=sc.nextInt()-1;
				if(map[i][j]==0) {
					for (int k = 0; k < 3; k++) {
						dp[i][j][0][k]=0;
						tmp.add(new point(i, j, 0, k));
					}
				}
			}
		}
		
		solve();
		System.out.println(res);
	}
	
	public static void solve() {
		res=Integer.MAX_VALUE;
		
		while(!tmp.isEmpty()) {
			point p=tmp.poll();
			
			//시작점 n,n : 도착점 n*n-1;
			//최소값을 찾을 것이기에 return 말고 계속 순회
			if(p.t==n*n-1) {
				res=Math.min(res,dp[p.x][p.y][p.t][p.h]);
			}
			
			//제자리에서 horse만 바꾸는 경우의수 
			for (int i = 0; i < 3; i++) {
				if(p.h==i) continue;
				if(dp[p.x][p.y][p.t][i]==-1) {
					// 말만 i로 교체하고 그 값에는 기존 말 p.h값에 +1
					dp[p.x][p.y][p.t][i]=dp[p.x][p.y][p.t][p.h]+1;
					// 교체한 말을 큐에 넣기
					tmp.add(new point(p.x, p.y, p.t, i));
				}
			}
			
			// 말의 형태에 따라 모든 케이스 계산
			
			// 나이트
			if(p.h==0) {
				for (int i = 0; i < knight.length; i++) {
					int nx=p.x+knight[i][0];
					int ny=p.y+knight[i][1];
					if(nx>=0 && ny>=0 && nx<n && ny<n) {
						// 움직인 좌표 map[nx][ny]가 현재 t에서 다음으로 이동해야할 t+1인 경우
						// 이 조건을 통해 처음 0 -> 1 로움직이는 경우들만 탐색하고 그 다음부터는 1->2 / 2->3 과 같이 진행
						
						// (중요)map[nx][ny]==p.t+1인 경우만 유효한 값
						int next_num=p.t;
						if(map[nx][ny]==p.t+1) {
							next_num=p.t+1;
						}
							// 나이트로 움직인 다음 경로의 dp값을 갱신한다.
						if(dp[nx][ny][next_num][0]==-1) {
							dp[nx][ny][next_num][0]=dp[p.x][p.y][p.t][0]+1;
							// 다음 순회를 위한 큐에 add(t+1을 시작으로 하는 새로운 큐에 담길 정보)
							tmp.add(new point(nx, ny, next_num, 0));
						}
					}
				}
			}
			// 비숍
			else if(p.h==1) {
				for (int i = 0; i < bishop.length; i++) {
					// 총 4가지 방향에 대해 최대로 움직일 수 있는 거리를 while문으로 계산
					int idx=1;
					
					while(true) {
						int nx=p.x+bishop[i][0]*idx;
						int ny=p.y+bishop[i][1]*idx;
						
						if(nx>=0 && ny>=0 && nx<n && ny<n) {
							int next_num=p.t;
							if(map[nx][ny]==p.t+1) {
								next_num=p.t+1;
							}	
								
							if(dp[nx][ny][next_num][1]==-1) {
								dp[nx][ny][next_num][1]=dp[p.x][p.y][p.t][1]+1;
								tmp.add(new point(nx, ny, next_num, 1));
							}
						}
						// 범위 벗어나면 break
						else
							break;
						
						// 범위 안벗어나면 대각선 연장
						idx++;
					}
				}
			}
			// 룩
			else {
				for (int i = 0; i < look.length; i++) {
					int idx=1;
					
					while(true) {
						int nx=p.x+look[i][0]*idx;
						int ny=p.y+look[i][1]*idx;
						
						if(nx>=0 && ny>=0 && nx<n && ny<n) {
							int next_num=p.t;
							if(map[nx][ny]==p.t+1) {
								next_num=p.t+1;
							}	
							
							if(dp[nx][ny][next_num][2]==-1) {
								dp[nx][ny][next_num][2]=dp[p.x][p.y][p.t][2]+1;
								tmp.add(new point(nx, ny, next_num, 2));
							}
						}
						else
							break;
						
						idx++;
					}
				}
			}
		}
	}
}

class point{
	int x,y,t,h;
	
	public point(int x, int y, int t, int h) {
		this.x=x;
		this.y=y;
		this.t=t;
		this.h=h;
	}
}
	
	