package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954_움직이는미로탈출 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Queue<point> tmp=new LinkedList<point>();
	static char[][]map=new char[8][8];
	static boolean[][][]visit=new boolean[8][8][9];
	static boolean live;
	
	static int[][]dir= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void main(String[] args) throws IOException {
		
		for (int i = 0; i < 8; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		solve();
		if(live)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
	
	// 살아 남는거에 초점
	public static void solve() {
		tmp.add(new point(7, 0, 0));
		visit[7][0][0]=true;
		while(!tmp.isEmpty()) {
			point p=tmp.poll();
			if(p.x==0 && p.y==7) {
				live=true;
				return;
			}
			for (int i = 0; i < dir.length; i++) {
				int nx=p.x+dir[i][0];
				int ny=p.y+dir[i][1];
				// 다음 next를 위한 time, 최소 8초안에 도착하게 된다.
				int nt=Math.min(p.time+1,8);
				
				if(nx>=0 && ny>=0 && nx<8 && ny<8) {
					//움직이려는 자리가 벽인경우
					if(nx-p.time>=0 && map[nx-p.time][ny]=='#') continue;
					
					// 일단 위로 움직일수는 있어... 근데 움직인 뒤 바로 위칸에 벽이있으면 다음 턴에 소멸된다
					//움직이려는 자리 바로 위에 벽인경우 굳이 큐에 넣을 필요가 없다
					if(nx-p.time-1>=0 && map[nx-p.time-1][ny]=='#') continue;
					
					if(!visit[nx][ny][nt]) {
						visit[nx][ny][nt]=true;
						tmp.add(new point(nx, ny, nt));
					}
				}
			}
		}
	}
}

class point{
	int x, y, time;
	
	public point(int x, int y, int time) {
		this.x=x;
		this.y=y;
		this.time=time;
	}
}
