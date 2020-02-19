import java.util.Scanner;

public class BOJ_15684_사다리조작 {

	static Scanner sc=new Scanner(System.in);
	static int row,col;
	static int[][]map;
	static int[]sel;
	static int res=-1;
	static boolean finish=false;
	static boolean go=false;
	
	public static void main(String[] args) {
	
		col=sc.nextInt();
		int m=sc.nextInt();
		row=sc.nextInt();
		sel=new int[3];
		
		map=new int[row+2][col+1];
		for (int i = 0; i < m; i++) {
			int r=sc.nextInt();
			int c=sc.nextInt();
			
			// right : 1 , left : 2
			map[r][c]=1;
			map[r][c+1]=2;
		}
		
		for (int i = 0; i <= 3; i++) {
			if(!finish) {
				solve(0,i);
			}
		}
		
		System.out.println(res);
		
	}
	
	public static void solve(int cnt, int max) {
		if(finish || cnt>3)
			return;
		
		if(cnt==max) {
			if(valid()) {
				finish=true;
				res=cnt;
			}
			return;
		}
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <=col; j++) {
				if(map[i][j]==0 && j+1<=col && map[i][j+1]==0 &&!finish) {
					sel[cnt++]=i*col+j%col;
					map[i][j]=1;
					map[i][j+1]=2;
					solve(cnt,max);
					sel[--cnt]=0;
					map[i][j]=0;
					map[i][j+1]=0;
				}
			}
		}
	}
	
	public static boolean valid() {
		for (int i = 1; i <= col; i++) {
			if(start(1,i)!=i)
				return false;
		}
		return true;
	}
	
	
	public static int start(int r, int c) {
		if(r==row+1) {
			return c;
		}
		
		if(map[r][c]==1)
			return start(r+1,c+1);
		else if(map[r][c]==2) {
			return start(r+1, c-1);
		}else {
			return start(r+1,c);
		}
		
	}
}

