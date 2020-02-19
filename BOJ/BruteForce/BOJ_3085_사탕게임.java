import java.util.Scanner;

public class BOJ_3085_사탕게임 {

	static Scanner sc=new Scanner(System.in);
	static int n,res=1;
	static char[][]map;
	static int[][]dir= {{0,1},{1,0}};
	static int[][]dir2= {{-1,0},{1,0}};
	static int[][]dir3= {{0,-1},{0,1}};
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		map=new char[n][n];
		
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			map[i]=sc.nextLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res=Math.max(res, solve(i,j));
			}
		}
		System.out.println(res);
	}
	
	public static int solve(int x, int y) {
		
		int a1=0;
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx>=0 && ny>=0 && nx<n && ny<n) {
				char c1=map[x][y];
				map[x][y]=map[nx][ny];
				map[nx][ny]=c1;
				// 사탕 교환이 이루어진 후 바뀐 두좌표에 대해 수행
				a1=Math.max(a1, check(x,y));
				a1=Math.max(a1, check(nx,ny));
				c1=map[nx][ny];
				map[nx][ny]=map[x][y];
				map[x][y]=c1;
			}
		}
		
		return a1;
		
	}
	
	public static int check(int bx, int by) {
		
		
		// 1번 : 가로탐색 , 2번 : 세로탐색
		// res -1초기화 : 각 탐색을 돌면서 자기자신이 2번 더해지는 중복을 미리 제거
		int idx1,idx2;
		int res1=-1, res2=-1;
		
		char bef=map[bx][by];
		
		for (int i = 0; i < dir2.length; i++) {
			idx1=1;
			while(true) {
				int tx=bx+dir2[i][0]*idx1;
				int ty=by+dir2[i][1]*idx1;
				
				if(tx>=0 && ty>=0 && tx<n && ty<n && map[tx][ty]==bef)
					idx1++;
				else
					break;
			}
			res1+=idx1;
		}
		
		for (int i = 0; i < dir3.length; i++) {
			idx2=1;
			while(true) {
				int tx=bx+dir3[i][0]*idx2;
				int ty=by+dir3[i][1]*idx2;
				
				if(tx>=0 && ty>=0 && tx<n && ty<n && map[tx][ty]==bef)
					idx2++;
				else
					break;
			}
			res2+=idx2;
		}
		
		// 가로 or 세로중 큰값 리턴
		
		return Math.max(res1, res2);
	}
}
