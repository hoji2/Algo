import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1226_미로1 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char[][]map;
	static boolean[][]visit;
	static boolean exit;
	static int size=16;
	static int[][]dir= {{0,-1},{-1,0},{0,1},{1,0}};
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			br.readLine();
			int sx=0, sy=0;
			map=new char[size][size];
			visit=new boolean[size][size];
			exit=false;
			
			for (int i = 0; i < size; i++) {
				map[i]=br.readLine().toCharArray();
				for (int j = 0; j < size; j++) {
					if(map[i][j]=='2') {
						sx=i;
						sy=j;
					}
				}
			}
			
			solve(sx,sy);
			
			if(exit)
				System.out.println("#"+tc+" "+1);
			else
				System.out.println("#"+tc+" "+0);
		}
	}
	public static void solve(int x, int y) {

		if(exit || map[x][y]=='3') {
			exit=true;
			return;
		}
		
		visit[x][y]=true;
		
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0 && ny>=0 && nx<size && ny<size && map[nx][ny]!='1' && !visit[nx][ny])
				solve(nx,ny);
		}
		
	}
}
