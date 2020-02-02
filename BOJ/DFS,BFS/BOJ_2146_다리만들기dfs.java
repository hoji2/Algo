import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기dfs {

	//https://lmcoa15.tistory.com/55
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][]map;
	static boolean [][]visit;
	static LinkedList<point> tmp=new LinkedList<point>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		visit=new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int idx=0;
			
			while(st.hasMoreTokens()) {
				map[i][idx++]=Integer.parseInt(st.nextToken());
			}
		}
		
		int color=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]!=0 && !visit[i][j]) {
					dfs(i,j,++color);
				}
					
			}
		}
		
		solve();
	}
	
	public static void dfs(int x, int y, int color) {
		if(x<0 || y<0 || x>=n || y>=n || visit[x][y] || map[x][y]==0)
			return;
		
		visit[x][y]=true;
		map[x][y]=color;
		tmp.add(new point(x, y, color));
		
		dfs(x-1,y,color);
		dfs(x+1,y,color);
		dfs(x,y-1,color);
		dfs(x,y+1,color);
	}
	
	public static void solve() {
		int min=Integer.MAX_VALUE;
		
		point[]arr=new point[tmp.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=tmp.get(i);
		}
		
		int mid=0;
		
		for (int i = 0; i < arr.length; i++) {
			point p1=tmp.get(i);
			for (int j = 0; j < arr.length; j++) {
				point p2=arr[j];
				if(p1.color==p2.color)
					continue;
				
				mid=Math.abs(p2.x-p1.x)+Math.abs(p2.y-p1.y)-1;
				min=Math.min(min, mid);
			}
		}
		
		System.out.println(min);
	}
}

class point{
	int x,y,color;
	
	public point(int x, int y, int color) {
		this.x=x;
		this.y=y;
		this.color=color;
	}
}