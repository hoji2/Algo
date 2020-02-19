package samsung;
import java.util.Scanner;

public class BOJ_14502_연구소_중요_완탐DFS_삼성기출 {

	// https://4ngs.tistory.com/2?category=783711
	static Scanner sc=new Scanner(System.in);
	static int row,col,mid,res=0;
	static int[][]map;
	static boolean[][]visit;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		map=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		// 중요 ! col로 나눈 몫과 나머지
		for (int i = 0; i < row*col-2; i++) {
			if(map[i/col][i%col]!=0) continue;
			for (int j = i+1; j < row*col-1; j++) {
				if(map[j/col][j%col]!=0) continue;
				for (int k = j+1; k < row*col; k++) {
					if(map[k/col][k%col]!=0) continue;
					solve(i,j,k);
				}
			}
		}
		
		System.out.println(res);
		
	}
	
	public static void solve(int n1, int n2, int n3) {
		int x1=n1/col;
		int y1=n1%col;
		int x2=n2/col;
		int y2=n2%col;
		int x3=n3/col;
		int y3=n3%col;
		
		// 벽만들고
		map[x1][y1]=1;
		map[x2][y2]=1;
		map[x3][y3]=1;
		
		// 바이러스의 퍼짐을 boolean변수로 판별
		visit=new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j]==2 && !visit[i][j]) {
					dfs(i,j);
				}
			}
		}
		
		res=Math.max(res, find());
		
		map[x1][y1]=0;
		map[x2][y2]=0;
		map[x3][y3]=0;
		
		
	}
	
	public static void dfs(int x, int y) {
		
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx>=0 && ny>=0 && nx<row && ny<col) {
				if(map[nx][ny]==0 && !visit[nx][ny]) {
					visit[nx][ny]=true;
					dfs(nx,ny);
				}
			}
		}
	}
	
	public static int find() {
		int tmp=0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j]==0 && !visit[i][j])
					tmp++;
			}
		}
		
		return tmp;
	}
}
