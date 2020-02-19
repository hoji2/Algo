import java.util.Scanner;

//https://gist.github.com/kwonhyeona/2920a9c6d584a38d4e829549b39f2230
public class BOJ_14503_로봇청소기 {

	static Scanner sc=new Scanner(System.in);
	static int row, col,res=1;
	static int[][]map;
	// 북 동 남 서
	// 0 1 2 3
	static int[][]dir= {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		int cx=sc.nextInt();
		int cy=sc.nextInt();
		int w=sc.nextInt();
		
		map=new int[row][col];
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				map[i][j]=sc.nextInt();
		
		solve(cx,cy,w);
		System.out.println(res);
		
	}
	
	// (중요) 재귀호출
	// 각 재귀가 한번 호출되고 return되어야 하는 형태이다 -> 그래야 다음 상황으로 넘어가기 때문에
	/*
	 * dfs(1)
	 * dfs(2)
	 * dfs(3)
	 * dfs(4)
	 * 
	 * 위와 같이 호출하게 되면 한번 호출 될 때 4번이 연속되게 호출된다 + 4번이 모두 종료 후 return되므로 이전상황으로 돌아와 탐색이 잘못되게 된다
	 */
	
	public static void solve(int cx, int cy, int idx) {
		
		//방문처리
		map[cx][cy]=2;
		
		for (int i = 1; i <=4; i++) {
			
			// 좌로 1번돌리기 = 우로 3번돌리기%mod
			idx=(idx+3)%4;
			int nx=cx+dir[idx][0];
			int ny=cy+dir[idx][1];
			
			if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]==0) {
				res++;
				// (중요) nx,ny방문 후 현재위치에서 다른방향으로 탐색하는 호출을 막기 위해 return 
				solve(nx,ny,idx);
				return;
			}
		}
		
		//후진
		int back=(idx+2)%4;
		int nx=cx+dir[back][0];
		int ny=cy+dir[back][1];
		
		if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=1) {
			solve(nx,ny,idx);
		}
	}
}
