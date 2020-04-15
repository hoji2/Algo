import java.util.Scanner;

public class BOJ_14499_주사위굴리기_시뮬삼성 {

	static Scanner sc=new Scanner(System.in);
	static int row, col, sx,sy, k;
	static int[][]info=new int[4][4];
	static int[][]map;
	static int[][]dir= {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	public static void main(String[] args) {
		
		row=sc.nextInt();
		col=sc.nextInt();
		sx=sc.nextInt();
		sy=sc.nextInt();
		int tc=sc.nextInt();
		
		map=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < tc; i++) {
			solve(sc.nextInt());
		}
		
	}
	
	public static void solve(int w) {
		
		int bx=sx;
		int by=sy;
		
		sx+=dir[w][0];
		sy+=dir[w][1];
		
		if(!(sx>=0 && sy>=0 && sx<row && sy<col)) {
			sx=bx;
			sy=by;
			return;
		}
		
		// shift
		int tmp=0;
		if(w==1) {
			tmp=info[1][3];
			info[1][3]=info[1][2];
			info[1][2]=info[1][1];
			info[1][1]=info[1][0];
			info[1][0]=tmp;
			info[3][1]=info[1][3];
		}else if(w==2) {
			tmp=info[1][0];
			info[1][0]=info[1][1];
			info[1][1]=info[1][2];
			info[1][2]=info[1][3];
			info[1][3]=tmp;
			info[3][1]=info[1][3];
		}else if(w==3) {
			tmp=info[0][1];
			info[0][1]=info[1][1];
			info[1][1]=info[2][1];
			info[2][1]=info[3][1];
			info[3][1]=tmp;
			info[1][3]=info[3][1];
		}else{
			tmp=info[3][1];
			info[3][1]=info[2][1];
			info[2][1]=info[1][1];
			info[1][1]=info[0][1];
			info[0][1]=tmp;
			info[1][3]=info[3][1];
		}
		
		// 맵에 복사
		if(map[sx][sy]==0) {
			map[sx][sy]=info[1][3];
		}
		// 주사위에 복사 후 맵 0
		else {
			info[1][3]=map[sx][sy];
			info[3][1]=map[sx][sy];
			map[sx][sy]=0;
		}
		
		System.out.println(info[1][1]);
		
	}
}
