import java.util.Scanner;

public class BOJ_3108_로고 {

	//https://yabmoons.tistory.com/179
	static Scanner sc=new Scanner(System.in);
	static final int max=2001;
	static int res=0;
	static char[][]map=new char[max][max];
	static boolean[][]visit=new boolean[max][max];
	static int [][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x1=(sc.nextInt()+500)*2;
			int y1=(sc.nextInt()+500)*2;
			int x2=(sc.nextInt()+500)*2;
			int y2=(sc.nextInt()+500)*2;
			
			draw(x1,y1,x2,y2);
		}
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if(map[i][j]=='1' && !visit[i][j]) {
					res++;
					dfs(i,j);
				}
			}
		}
		// 시작점에서 바로 그릴 수 있는경우
		if(map[1000][1000]=='1')
			res--;
		
		System.out.println(res);
		
		
	}
	
	public static void dfs(int row, int col) {
		if(map[row][col]!='1')
			return;
		
		visit[row][col]=true;
		
		for (int i = 0; i < dir.length; i++) {
			int nx=row+dir[i][0];
			int ny=col+dir[i][1];
			
			if(nx>=0 && ny>=0 && nx<max && ny<max &&!visit[nx][ny])
				dfs(nx,ny);
				
		}
	}
	
	public static void draw(int x1,int y1, int x2, int y2) {
		
		int sx=Math.min(x1, x2);
		int lx=Math.max(x1, x2);
		int sy=Math.min(y1, y2);
		int ly=Math.max(y1, y2);
		
		for (int i = sx; i <=lx; i++) {
			map[i][sy]='1';
			map[i][ly]='1';
		}
		
		for (int i = sy; i <=ly; i++) {
			map[sx][i]='1';
			map[lx][i]='1';
		}
	}
	
}
