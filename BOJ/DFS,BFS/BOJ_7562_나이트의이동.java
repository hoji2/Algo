import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562_나이트의이동 {

	static Scanner sc=new Scanner(System.in);
	static int[][]dir= {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	static int n;
	
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			n=sc.nextInt();
			point start=new point(sc.nextInt(), sc.nextInt());
			point end=new point(sc.nextInt(), sc.nextInt());
			System.out.println(bfs(start,end));
		}
	}
	
	public static int bfs(point start, point end) {
		
		int cnt=0;
		
		boolean[][]visit=new boolean[n][n];
		Queue<point>tmp=new LinkedList<point>();
		
		visit[start.x][start.y]=true;
		tmp.add(start);
		
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			
			for (int i = 0; i < loop; i++) {
				point p=tmp.poll();
				if(p.x==end.x && p.y==end.y)
					return cnt;
				
				for (int j = 0; j < dir.length; j++) {
					int nx=p.x+dir[j][0];
					int ny=p.y+dir[j][1];
					
					if(nx>=0 && ny>=0 && nx<n && ny<n && !visit[nx][ny]) {
						visit[nx][ny]=true;
						tmp.add(new point(nx, ny));
					}
				}
			}
			cnt++;
		}
		
		return -1;
	}
}

class point{
	int x,y;
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}