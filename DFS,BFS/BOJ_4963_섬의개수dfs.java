import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수dfs {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int col,row;
	static int[][]map;
	
	
	public static void main(String[] args) throws IOException {
	
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			col=Integer.parseInt(st.nextToken());
			row=Integer.parseInt(st.nextToken());
			
			if(col==0 && row==0)
				break;
			
			map=new int[row][col];
//			visit=new boolean[col][row];
			
			for (int i = 0; i < row; i++) {
				st=new StringTokenizer(br.readLine());
				int idx=0;
				while(st.hasMoreTokens()) {
					map[i][idx++]=Integer.parseInt(st.nextToken());
				}
			}
			
			int res=0;
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(map[i][j]==1) {
						res++;
						dfs(i,j);
					}
					
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void dfs(int x, int y) {
		if(x<0 || y<0 || x>=row || y>=col || map[x][y]==0)
			return;
		
		map[x][y]=0;
		
		dfs(x-1,y-1);
		dfs(x-1,y);
		dfs(x-1,y+1);
		dfs(x,y-1);
		dfs(x,y+1);
		dfs(x+1,y-1);
		dfs(x+1,y);
		dfs(x+1,y+1);
		
	}
}
