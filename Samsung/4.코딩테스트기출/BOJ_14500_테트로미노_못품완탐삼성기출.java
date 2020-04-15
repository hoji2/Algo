import java.util.Scanner;

public class BOJ_14500_테트로미노_못품완탐삼성기출 {

	static Scanner sc=new Scanner(System.in);
	static int row, col, res=Integer.MIN_VALUE;
	static int[][]map;
	static int[][][]dir={{{0,1},{0,2},{0,3}},{{0,1},{1,0},{1,1}},{{0,1},{0,2},{1,1}},{{1,0},{2,0},{2,1}},{{1,0},{1,1},{1,2}}};
	
	public static void main(String[] args) {
		
		row=sc.nextInt();
		col=sc.nextInt();
		
		map=new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				solve(i,j);
			}
		}
		System.out.println(res);
	}
	
	public static void solve(int x, int y) {
		for (int i = 0; i < dir.length; i++) {
			int tmp=map[x][y];
			boolean go=true;
			// 정방향
			for (int j = 0; j < 3; j++) {
				int nx=x+dir[i][j][0];
				int ny=y+dir[i][j][1];
				if(nx>=0 && ny>=0 && nx<row && ny<col) {
					tmp+=map[nx][ny];
				}else {
					go=false;
					break;
				}
			}
			if(go)
				res=Math.max(res, tmp);
		}
	}
}
