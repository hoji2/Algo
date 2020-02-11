import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토{

	// Scanner 입력 시 -1 떄문에 int[][]로 선언
	// StringTokenizer 사용 시 -1입력은 가능 -> 로직상 map[i][j]=-1을 판별하는 경우가 없기에 char[][] 사용 가능
	static Scanner sc=new Scanner(System.in);
	static int N,M,day;
	static int[][]map;
	static boolean[][]visit;
	static Queue<Point> info=new LinkedList<Point>();
	// 상 좌 우 하
	static int[][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
	
	public static void main(String[] args) throws IOException {
		
		N=sc.nextInt();
		M=sc.nextInt();
		day=-1;
		
		
		map=new int[M][N];
		
		// 입력 받으면서 만일 그 좌표에 해당하는 값이 1인 경우 Queue에 넣기
		int x,y;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) {
					info.add(new Point(i, j));
				}
			}
		}
		
		bfs();
		if(!valid())
			day=-1;

		System.out.println(day);
	
	}
	
	public static void bfs() {
		
		while(!info.isEmpty()) {
			int loop=info.size();
			day++;
			int bx,by;
			
			for (int i = 0; i < loop; i++) {
				Point tmp=info.poll();
				for (int j = 0; j < dir.length; j++) {
					bx=tmp.x+dir[j][0];
					by=tmp.y+dir[j][1];
					
					//일단 방문처리
					if(bx>=0 && bx<M && by>=0 && by<N) {
						if(map[bx][by]==0) {
							map[bx][by]=1;
							info.add(new Point(bx, by));
						}
					}
				}
			}
		}
	}
	
	//visit배열 사용 x -> 대신 방문한 좌표의 map을 1로 변환
	public static boolean valid() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0)
					return false;
			}
		}
		return true;
	}
	
}

class Point{
	
	int x, y;

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
