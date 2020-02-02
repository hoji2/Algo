import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색{
	
	// 도착여부 파악(탈출조건)
	// 배열 idx (1,1)
	// map은 char형을 사용
	// visit 2차원 배열
	// dir 배열 필요
	// Queue<point class>를 활용하여 BFS탐색
	// static 변수 테스트케이스에 따른 초기화 중요!

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	// 상 좌 우 하
	static int[][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
	static int row, col, res;
	static char[][] map;
	static boolean[][] visit;
	static boolean isStop;
	static Queue<point> tmp;
	
	public static void main(String[] args) throws IOException {
		
		//br.read()로 표현하는 경우 오류 多
		//br.read() char형 변환
		//br.read() vs br.readline() 개행주의
		//br.read()로 읽을 경우 두자리수 못읽음 ex)25 -> 2로 읽음
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		
		map=new char[row+1][col+1];
		visit=new boolean[row+1][col+1];
		
		// toCharArray 사용 시 size 재조정
		// ex) array크기 7 toCharArray 6 -> array크기 6
		for (int i = 1; i <= row; i++) {
			String s=br.readLine();
			for (int j = 1; j <= s.length(); j++) {
				map[i][j]=s.charAt(j-1);
			}
		}
		
		bfs();
		System.out.println(res);
	}
	
	public static void bfs() {
		
		tmp=new LinkedList<point>();
		// 초기 (1,1) 시작조건
		tmp.add(new point(1, 1));
		visit[1][1]=true;
		res=1;
		
		while(!tmp.isEmpty()) {
			// 어떤 포인트 기준으로 상하좌우 max4번까지를 하나의 cycle로 설정
			int loop=tmp.size();
			
			for (int i = 0; i < loop; i++) {
				point mid=tmp.poll();
				check(mid);
				// 상하좌우 사이클 내에서 예를들어 상 조건에서 탈출조건을 만족하는 경우 하,좌,우 볼 필요없이 break
				if(isStop)
					return;
			}
			
			res++;
		}
	}
	
	public static void check(point mid) {
		
		int x;
		int y;
		
		for (int i = 0; i < dir.length; i++) {
			// 유효범위 안에 있고
			x=mid.x+dir[i][0];
			y=mid.y+dir[i][1];
			if(x>=1 && y>=1 && x<=row && y<=col && !visit[x][y] && map[x][y]=='1') {
				// break조건 : (row,col) 도착
				if(x==row && y==col) {
					res++;
					isStop=true;
					return;
				}
				
				visit[x][y]=true;
				tmp.add(new point(x, y));
			}
		}
	}
}

class point{
	int x,y;
	
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
