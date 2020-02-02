import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {

	static Scanner sc=new Scanner(System.in);
	static int row,col;
	static int [][]map;
	static int [][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static Queue<point> tmp=new LinkedList<point>();
	
	public static void main(String[] args) {
	
		// row, col만 잘 받으면 이후부터는 이상 무
		col=sc.nextInt();
		row=sc.nextInt();
		
		map=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1)
					tmp.add(new point(i, j));
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int day=-1;
				
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			day++;
			for (int i = 0; i < loop; i++) {
				point p=tmp.poll();
				for (int j = 0; j < dir.length; j++) {
					int nx=p.x+dir[j][0];
					int ny=p.y+dir[j][1];
					
					if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]==0) {
						map[nx][ny]=1;
						tmp.add(new point(nx, ny));
					}
				}
			}
		}
				
		
		if(fail())
			return -1;
		else
			return day;
	}
	
	public static boolean fail() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j]==0)
					return true;
			}
		}
		return false;
	}
}

class point{
	int x,y;
	
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}