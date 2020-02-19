package swea;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16973_직사각형탈출 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map,dp;
	static int n, r, a,b,fx,fy;
	static boolean[][]visit;
	static int[][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
	static boolean success=false;
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		r=sc.nextInt();
		map=new int[n+1][r+1];
		visit=new boolean[n+1][r+1];
		
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=r; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		a=sc.nextInt();
		b=sc.nextInt();
		int sx=sc.nextInt();
		int sy=sc.nextInt();
		fx=sc.nextInt();
		fy=sc.nextInt();
		
		int res=0;
		
		//prefix 초기화 (1,1)~(i,j)기준의합 중요!
		dp=new int[n+1][r+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=r; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];
			}
		}
		
		Queue<point>tmp=new LinkedList<point>();
		tmp.add(new point(sx, sy));
		visit[sx][sy]=true;
		
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			for (int i = 0; i < loop; i++) {
				point p=tmp.poll();
				if(p.x==fx && p.y==fy) {
					success=true;
					break;
				}
				for (int j = 0; j < dir.length; j++) {
					int nx=p.x+dir[j][0];
					int ny=p.y+dir[j][1];
					// st지점 nx,ny가 1보다 커야되고 직사각형 범위를 더한 nx+a-1,ny+b-1 가 유효한 범휘 n,r 이하인 경우
					if(nx>=1 && ny>=1 && nx+a-1<=n && ny+b-1<=r && !visit[nx][ny]) {
						if(valid(nx,ny,nx+a-1,ny+b-1)==0) {
							visit[nx][ny]=true;
							tmp.add(new point(nx, ny));
						}
					}
				}
			}
			if(success)
				break;
			res++;
			
		}
		
		if(success)
			System.out.println(res);
		else
			System.out.println(-1);
	}
	
	// prefix 이용!!
	public static int valid(int nx, int ny, int ex, int ey) {
		return dp[ex][ey]-dp[nx-1][ey]-dp[ex][ny-1]+dp[nx-1][ny-1];
	}
}

class point{
	int x,y;
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
