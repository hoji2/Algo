import java.util.Scanner;

public class BOJ_2573_빙산 {

	static Scanner sc=new Scanner(System.in);
	static int row, col;
	static int [][]map;
	static int [][]minus;
	static boolean [][]visit;
	
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		
		map=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		int day=1;
		
		while(true) {
			// 빙산 녹이기
			water();
			// 빙산 구간 확인
			visit=new boolean[row][col];
			int tmp=seperate();
			
			// 빙산이 2이상으로 나눠진 경우 break
			if(tmp!=1) {
				break;
			}else {
				day++;
			}
		}
		
		// 모두 잠겼는지 여부 파악
		if(lastcheck())
			System.out.println(0);
		else
			System.out.println(day);
		
	}
	
	public static void water() {
		
		minus=new int[row][col];
		
		for (int i = 1; i <row-1; i++) {
			for (int j = 1; j <col-1; j++) {
				if(map[i][j]!=0)
					minus[i][j]=check(i,j);
			}
		}
		
		for (int i = 1; i <row-1; i++) {
			for (int j = 1; j <col-1; j++) {
				map[i][j]-=minus[i][j];
				
				if(map[i][j]<0)
					map[i][j]=0;
			}
		}
	}
	
	public static int check(int i, int j) {
		int res=0;
		
		if(map[i-1][j]==0)
			res++;
		if(map[i][j-1]==0)
			res++;
		if(map[i][j+1]==0)
			res++;
		if(map[i+1][j]==0)
			res++;
		
		return res;
	}
	
	public static int seperate() {
		
		int res=0;
		
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				if(map[i][j]!=0 && !visit[i][j]) {
					res++;
					dfs(i,j);
				}
					
			}
		}
		return res;
	}
	
	public static void dfs(int x, int y) {
		
		if(map[x][y]==0 || visit[x][y])
			return;
		
		visit[x][y]=true;
		
		dfs(x-1,y);
		dfs(x,y-1);
		dfs(x,y+1);
		dfs(x+1,y);
			
	}
	
	public static boolean lastcheck() {
		
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				if(map[i][j]!=0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
