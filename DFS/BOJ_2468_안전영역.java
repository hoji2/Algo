import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2468_안전영역 {

	/*
	 * N : 높이
	 * 행렬의 최소값 최대값 기록
	 * 최소값=최대값 답 0?
	 */
	
	static Scanner sc=new Scanner(System.in);
	static int N,min,max,res=0;
	static int[][]map;
	// map에 변화를 주면 안되는 상황이므로(for문 때문에) visit배열의 초기화
	static boolean[][]visit;
	static ArrayList<Integer> info=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		N=sc.nextInt();
		map=new int[N][N];
		
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
				if(min>map[i][j])
					min=map[i][j];
				if(map[i][j]>=max)
					max=map[i][j];
			}
		}
		
		if(min==max)
			System.out.println(1);
		else {
			for (int i = min; i <=max-1; i++) {
				info.add(solve(i));
			}

			info.sort(new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1-o2;
				}
			});
			System.out.println(info.get(info.size()-1));
		}
		
	}
	
	public static int solve(int h) {
		
		int tmp=0;
		visit=new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>h && !visit[i][j]) {
					tmp++;
					dfs(i,j,h);
				}
			}
		}
		
		return tmp;
	}
	
	public static void dfs(int x, int y, int h) {

		if(x<0 || y<0 || x>=N || y>=N || map[x][y]<=h || visit[x][y]) {
			return;
		}
		
		visit[x][y]=true;
		
		if(map[x][y]<=h){
			map[x][y]=h;
			return;
		}
		
		dfs(x-1,y,h);
		dfs(x,y-1,h);
		dfs(x,y+1,h);
		dfs(x+1,y,h);
	}
}
