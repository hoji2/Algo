import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_ladder1 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][]map;
	static boolean[][]visit;
	static int res=0;
	
	public static void main(String[] args) throws IOException {
		
		for (int tc = 1; tc <=10; tc++) {
			br.readLine();
			map=new int[100][100];
			visit=new boolean[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int idx=0;
				while(st.hasMoreTokens())
					map[i][idx++]=stoi(st.nextToken());
			}
			
			int sy=0;
			for (int j = 0; j < 100; j++) {
				if(map[99][j]==2) {
					solve(99,j);
					break;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void solve(int row, int col) {
		
		if(row==0) {
			res=col;
			return;
		}
		
		visit[row][col]=true;
		
		int left=col-1;
		int right=col+1;
		
		if(left>=0) {
			if(map[row][left]==1 && !visit[row][left]) {
				visit[row][left]=true;
				solve(row,left);
				return;
			}
		}
		
		if(right<=99) {
			if(map[row][right]==1 && !visit[row][right]) {
				visit[row][right]=true;
				solve(row,right);
				return;
			}
		}
		
		solve(row-1, col);
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
