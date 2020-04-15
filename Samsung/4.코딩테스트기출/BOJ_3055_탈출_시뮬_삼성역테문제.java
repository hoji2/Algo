import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3055_탈출_시뮬_삼성역테문제 {

	static Scanner sc=new Scanner(System.in);
	static int row, col, res=0;
	static char[][]map;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static Queue<point3> water=new LinkedList<point3>();
	static boolean success=false;
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		
		map=new char[row][col];
		Queue<point3> tmp=new LinkedList<point3>();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			map[i]=sc.nextLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if(map[i][j]=='S')
					tmp.add(new point3(i, j));
				else if(map[i][j]=='*')
					water.add(new point3(i, j));
			}
		}
		
		while(!tmp.isEmpty()) {
			rain();
			res++;
			int loop=tmp.size();
			for (int i = 0; i < loop; i++) {
				point3 p=tmp.poll();
				// 두더지가 지나간 자리는 B로 하여 BFS탐색시 이전 B인자리는 큐에 넣지 않는다
				map[p.x][p.y]='B';
				for (int j = 0; j < dir.length; j++) {
					int nx=p.x+dir[j][0];
					int ny=p.y+dir[j][1];
					
					if(nx>=0 && ny>=0 && nx<row && ny<col) {
						if(map[nx][ny]=='.') {
							tmp.add(new point3(nx, ny));
							map[nx][ny]='S';
						}
						else if(map[nx][ny]=='D') {
							success=true;
							break;
						}
					}
				}
				if(success)
					break;
			}
			if(success)
				break;
		}
		if(success)
			System.out.println(res);
		else
			System.out.println("KAKTUS");
	}
	
	public static void rain() {
		int loop=water.size();
		
		for (int i = 0; i < loop; i++) {
			point3 p=water.poll();
			for (int j = 0; j < dir.length; j++) {
				int nx=p.x+dir[j][0];
				int ny=p.y+dir[j][1];
				
				if(nx>=0 && ny>=0 && nx<row && ny<col) {
					if(map[nx][ny]=='.') {
						map[nx][ny]='*';
						water.add(new point3(nx, ny));
					}
				}
			}
			
		}
	}
}

class point3{
	int x,y;
	
	public point3(int x, int y) {
		this.x=x;
		this.y=y;
	}
}