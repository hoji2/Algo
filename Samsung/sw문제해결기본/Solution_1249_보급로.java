import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249_보급로 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static char[][]map;
	static boolean[][]visit;
	static int size;
	
	public static void main(String[] args) throws IOException {
	
		int tc=stoi(br.readLine());
		
		for (int t = 1; t <=tc; t++) {
			size=stoi(br.readLine());
			map=new char[size][size];
			visit=new boolean[size][size];
			for (int i = 0; i < size; i++) {
				map[i]=br.readLine().toCharArray();
			}
			
			System.out.println("#"+t+" "+solve());
		}
	}
	
	public static int solve() {
		PriorityQueue<point>pq=new PriorityQueue<point>(new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});
		
		pq.add(new point(0, 0, 0));
		visit[0][0]=true;
		while(!pq.isEmpty()) {
			point p=pq.poll();
			if(p.x==size-1 && p.y==size-1)
				return p.val;
			
			for (int i = 0; i < dir.length; i++) {
				int nx=p.x+dir[i][0];
				int ny=p.y+dir[i][1];
				
				if(nx>=0 && ny>=0 && nx<size && ny<size && !visit[nx][ny]) {
					visit[nx][ny]=true;
					pq.add(new point(nx, ny, p.val+map[nx][ny]-'0'));
				}
			}
		}
		return -1;
	}
	
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

class point{
	int x,y,val;
	public point(int x, int y, int val) {
		this.x=x;
		this.y=y;
		this.val=val;
	}
}
