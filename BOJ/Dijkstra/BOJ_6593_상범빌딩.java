import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	// 상 좌 우 하 위 아래
	static int [][]dir= {{-1,0,0},{0,-1,0},{0,1,0},{1,0,0},{0,0,1},{0,0,-1}};
	static Comparator<point>comp;
	
	public static void main(String[] args) throws IOException {
		
		comp=new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		};
	
		while(true) {
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int z=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			if(x==0 && y==0 && z==0) {
				break;
			}
			
			// S, E 좌표값 담아놓을 배열
			int[][] info= {{0,0,0},{0,0,0}};
			char [][][]map=new char[z][x][y];
			int [][][]dp=new int[z][x][y];
			boolean [][][]visit=new boolean[z][x][y];
			Queue<point> pq=new PriorityQueue<point>(comp);
			

			// 입력 배열 setting
			char[] cp=new char[y];
			for (int i = 0; i < z; i++) {
				for (int j = 0; j < x; j++) {
					cp=br.readLine().toCharArray();
					for (int k = 0; k < y; k++) {
						if(cp[k]=='S') {
							info[0][0]=i;
							info[0][1]=j;
							info[0][2]=k;
						}else if(cp[k]=='E') {
							info[1][0]=i;
							info[1][1]=j;
							info[1][2]=k;
						}
						map[i][j][k]=cp[k];
					}
				}
				if(i!=z-1)
					br.readLine();
			}
			
			// DP 배열 setting
			for (int i = 0; i < z; i++) {
				for (int j = 0; j < x; j++) {
					Arrays.fill(dp[i][j], Integer.MAX_VALUE);
				}
			}
			
			dp[info[0][0]][info[0][1]][info[0][2]]=0;
			pq.add(new point(info[0][0], info[0][1], info[0][2], 0));
			
			while(!pq.isEmpty()) {
				point p=pq.poll();
				visit[p.z][p.x][p.y]=true;
				if(p.z==info[1][0] && p.x==info[1][1] && p.y==info[1][2]) {
					break;
				}
				
				for (int i = 0; i < dir.length; i++) {
					int dz=p.z+dir[i][0];
					int dx=p.x+dir[i][1];
					int dy=p.y+dir[i][2];
					
					if(dz>=0 && dx>=0 && dy>=0 && dz<z && dx<x && dy<y && !visit[dz][dx][dy] && map[dz][dx][dy]!='#') {
						int tmp1=dp[dz][dx][dy];
						int tmp2=dp[p.z][p.x][p.y]+1;
						dp[dz][dx][dy]=Math.min(tmp1, tmp2);
						if(tmp1!=dp[dz][dx][dy])
							pq.add(new point(dz, dx, dy, dp[dz][dx][dy]));
							
					}
					
				}
			}
			
			int fin=dp[info[1][0]][info[1][1]][info[1][2]];
			if(fin<=0 || fin>=Integer.MAX_VALUE)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in "+fin+" minute(s).");
			br.readLine();
		}
			
	}
}

class point{
	int x,y,z,val;
	public point(int z, int x, int y, int val) {
		this.z=z;
		this.x=x;
		this.y=y;
		this.val=val;
	}
}
