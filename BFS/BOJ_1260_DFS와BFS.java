import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_DFS와BFS {

	static Scanner sc=new Scanner(System.in);
	static char[][]map;
	/*
	 1. 정점 V의 방문 유무를 판별할 boolean 배열
	 2. DFS, BFS 모두 visit배열 사용
	 */
	static boolean[]isVisit;
	static int N, V;
	
	public static void main(String[] args){
		
		N=sc.nextInt();
		V=sc.nextInt();
		
		int st=sc.nextInt();
		
		//좌표 idx=1부터
		map=new char[N+1][N+1];
		isVisit=new boolean[N+1];
		
		for (int i = 0; i < V; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			map[x][y]='Y';
			map[y][x]='Y';
		}
		
		dfs(st);
		Arrays.fill(isVisit, false);
		bfs(st);
	}
	public static void dfs(int st) {
		
		System.out.print(st+" ");
		isVisit[st]=true;
		
		for (int i = 1; i <= N; i++) {
			// 방문한적이 없고 간선이 연결되어 있는 경우(Y)
			if(!isVisit[i] && map[st][i]=='Y') {
				// 방문처리 후 dfs 재귀호출
				isVisit[i]=true;
				dfs(i);
			}
		}
		
	}
	
	public static void bfs(int st) {
		
		System.out.println();
		
		// 탐색정보를 담아놓을 Queue 선언
		Queue<Integer> tmp=new LinkedList<Integer>();
		tmp.add(st);
		
		//초기 방문한 정점의 방문체크
		isVisit[st]=true;
		
		// Queue에 방문한 정점이 존재하지 않을 때까지 = 모든 정점을 방문해서 더이상 방문할 정점이 없을 때 까지
		while(!tmp.isEmpty()) {
			int v=tmp.poll();
			System.out.print(v+" ");
			
			for (int i = 1; i <= N; i++) {
				if(!isVisit[i] && map[v][i]=='Y') {
					isVisit[i]=true;
					tmp.add(i);
				}
			}
		}
	}
}


