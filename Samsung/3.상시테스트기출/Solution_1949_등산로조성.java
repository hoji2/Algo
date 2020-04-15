import java.util.Scanner;

public class Solution_1949_등산로조성 {

	static Scanner sc=new Scanner(System.in);
	static int size, drop,res;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static int[][]map;
	static boolean[][]visit;
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			size=sc.nextInt();
			drop=sc.nextInt();
			
			map=new int[size][size];
			int start_v=-1;
			res=-1;
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j]=sc.nextInt();
					start_v=Math.max(start_v, map[i][j]);
				}
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					// 최고점을 기준으로 탐색
					if(map[i][j]==start_v) {
						visit=new boolean[size][size];
						visit[i][j]=true;
						solve(i,j,1,false);
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	
	public static void solve(int x, int y, int len, boolean used) {
		
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx>=0 && ny>=0 && nx<size && ny<size && !visit[nx][ny]) {
				// 이동하려는 nx,ny가 현재 x,y 좌표값 보다 작으면 len+1 후 다음 탐색
				if(map[nx][ny]<map[x][y]) {
					visit[nx][ny]=true;
					solve(nx,ny,len+1,used);
					visit[nx][ny]=false;
				}
				else {
					// 만일 땅파기 사용안한 경우
					if(!used) {
						// 1~최대깊이 drop까지
						for (int j = 1; j <=drop; j++) {
							// 땅을파고
							map[nx][ny]-=j;
							// 땅판 후에 움직일 수 있는지 여부 파악
							if(map[nx][ny]<map[x][y]) {
								visit[nx][ny]=true;
								solve(nx,ny,len+1,true);
								visit[nx][ny]=false;
							}
							// 다시 원복
							map[nx][ny]+=j;
						}
					}
				}
			}
		}
		
		res=Math.max(res, len);
		return;
	}
	
}
