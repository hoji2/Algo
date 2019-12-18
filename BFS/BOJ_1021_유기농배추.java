import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1021_유기농배추 {

	// 입력 : col부터
	// char[][]의 경우 default로 아무 값도 안들어가있음 
	// cf) int[][]의 경우 default=0
	static Scanner sc=new Scanner(System.in);
	static int row, col, cnt;
	static char[][]map;
	static boolean[][]visit;
	static int[][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
	
	
	public static void main(String[] args) {
		
		int tc=sc.nextInt();
		for (int i = 0; i < tc; i++) {
			col=sc.nextInt();
			row=sc.nextInt();
			cnt=sc.nextInt();
			map=new char[row][col];
			visit=new boolean[row][col];
			
			// for문안에 sc.nextInt() 사용 X
			for (int j = 0; j < cnt; j++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				map[b][a]='1';
			}
			
			int res=0;
			
			for (int k = 0; k < row; k++) {
				for (int j = 0; j < col; j++) {
					if(map[k][j]=='1' && !visit[k][j]) {
						res++;
						visit[k][j]=true;
						bfs(k,j);
					}
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> info=new LinkedList<Point>();
		info.add(new Point(x, y));
		
		while(!info.isEmpty()) {
			Point p=info.poll();
			int nx,ny;
			for (int i = 0; i < dir.length; i++) {
				nx=p.x+dir[i][0];
				ny=p.y+dir[i][1];
				if(nx>=0 && ny>=0 && nx<row && ny<col && !visit[nx][ny] && map[nx][ny]=='1') {
					visit[nx][ny]=true;
					info.add(new Point(nx, ny));
				}
			}
		}
	}
}

class Point{
	int x,y;

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}