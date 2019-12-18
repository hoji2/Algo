import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기{

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static char[][]map;
	static boolean[][]visit;
	static Queue<Point> info=new LinkedList<Point>();
	// 상 좌 우 하
	static int[][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
	static ArrayList<Integer> mid=new ArrayList<Integer>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		visit=new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='1' && !visit[i][j]) {
					// 초기 방문처리 중요!! 놓친부분...
					info.add(new Point(i, j));
					visit[i][j]=true;
					mid.add(bfs());
				}
			}
		}
		
		mid.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		System.out.println(mid.size());
		for (int i = 0; i < mid.size(); i++) {
			System.out.println(mid.get(i));
		}
	}
	
	public static int bfs() {
		int tx,ty, res=0;
		
		while(!info.isEmpty()) {
			
			Point p=info.poll();
			res++;

			for (int i = 0; i < dir.length; i++) {
				tx=p.x+dir[i][0];
				ty=p.y+dir[i][1];
			
				if(tx>=0 && tx<N && ty>=0 && ty<N && map[tx][ty]=='1' && !visit[tx][ty]) {
					info.add(new Point(tx, ty));
					visit[tx][ty]=true;
				}
			}
		}
		
		return res;
	}
}

class Point{
	int x,y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
