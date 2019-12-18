import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {

	static Scanner sc=new Scanner(System.in);
	static int N,M;
	static char[][]map;
	static boolean[]visit;
	
	public static void main(String[] args) {
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		map=new char[N+1][N+1];
		visit=new boolean[N+1];
		int res=0;
		
		for (int i = 0; i < M; i++) {
			
			int x=sc.nextInt();
			int y=sc.nextInt();
			map[x][y]='1';
			map[y][x]='1';
		}
		
		// 연결요소를 찾아 추가해주기(2차원 map을 다 순회할 필요 X)
		// 독립적인 정점도 하나의 연결요소로 표현(중요)
		for (int i = 1; i <=N; i++) {
			if(!visit[i]) {
				res++;
				dfs(i);
			}
		}
		
		System.out.println(res);
	}
	
	public static void dfs(int x) {
		for (int i = 1; i <=N; i++) {
			if(map[x][i]=='1' && !visit[i]) {
				visit[i]=true;
				dfs(i);
			}
		}
		return;
	}
}
