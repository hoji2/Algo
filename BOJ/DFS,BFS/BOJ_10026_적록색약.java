import java.util.Scanner;

public class BOJ_10026_적록색약 {

	static Scanner sc=new Scanner(System.in);
	static int n;
	static char[][]map;
	static boolean[][]visit;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		sc.nextLine();
		
		map=new char[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i]=sc.nextLine().toCharArray();
		}
		
		int tmp1=0, tmp2=0;
		
		visit=new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					tmp1++;
					solve(i,j,0);
				}
			}
		}
		visit=new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					tmp2++;
					solve(i,j,1);
				}
			}
		}
		
		System.out.println(tmp1+" "+tmp2);
	}
	
	public static void solve(int x, int y, int check) {
		
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx>=0 && ny>=0 && nx<n && ny<n && !visit[nx][ny]) {
				if(check==0) {
					if(map[nx][ny]==map[x][y]) {
						visit[nx][ny]=true;
						solve(nx,ny,0);
					}
				}else {
					if(map[x][y]=='B') {
						if(map[nx][ny]=='B') {
							visit[nx][ny]=true;
							solve(nx,ny,1);
						}
					}else {
						if((int)map[nx][ny]>66) {
							visit[nx][ny]=true;
							solve(nx,ny,1);
						}
					}
				}
			}
		}
	}
}
