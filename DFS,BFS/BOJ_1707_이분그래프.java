import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1707_이분그래프 {

	static Scanner sc=new Scanner(System.in);
	static ArrayList<ArrayList<Integer>> tmp;
	static int n;
	static int[]color;
	static boolean fin;
	
	// https://gmlwjd9405.github.io/2018/08/23/algorithm-bipartite-graph.html
	// 활용 : https://brunch.co.kr/@kd4/148
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			n=sc.nextInt();
			int v=sc.nextInt();
			
			tmp=new ArrayList<ArrayList<Integer>>();
			
			// 0번 idx ArrayList는 사용 X
			for (int j = 0; j <=n; j++) {
				tmp.add(new ArrayList<Integer>());
			}
			
			// 각 정점을 방문할 때 마다 색칠할 것 3가지 case 필요 -> boolean 대신 int 배열이 필요: A그룹(1), B그룹(-1), 아직 방문안한 그룹(0)
			color=new int[n+1];
			// 초기 이분그래프이다
			fin=true;
			
			for (int j = 0; j < v; j++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				tmp.get(a).add(b);
				tmp.get(b).add(a);
			}
			
			for (int j = 1; j <=n; j++) {
				// 이분그래프가 아니면 더이상 탐색할 필요가 x
				if(!fin)
					break;
				
				// 방문하지 않은 정점부터 시작
				if(color[j]==0) {
//					dfs(j,1);
					bfs(j,1);
				}
			}
			
			System.out.println(fin? "YES" : "NO");
		}
	}
	
	public static void dfs(int st, int c) {
		// 방문처리
		color[st]=c;
		
		// st번째 list의 사이즈만큼 순회할꺼임 : 리스트의 idx=0번부터 중요
		for (int i = 0; i < tmp.get(st).size(); i++) {
			int p=tmp.get(st).get(i);
			
			// 하나씩 꺼낸 p라는 정점에 색깔 판별
			// case1) 아직 방문안했었니?
			if(color[p]==0)
				// 색깔을 반대로 주입
				dfs(p,-c);
			// 방문한적이 있어 -> 현재 st의 색깔과 같으면 지그재그가 아님 -> 종료
			else if(color[p]==c) {
				fin=false;
				return;
			}
		}
	}
	
	public static void bfs(int st, int c) {
		
		Queue<Integer> info=new LinkedList<Integer>();
		info.add(st);
		color[st]=c;
		
		while(!info.isEmpty() && fin) {
//			int loop=info.size();
			int v=info.poll();
			
			for (int i = 0; i <tmp.get(v).size(); i++) {
				int p=tmp.get(v).get(i);
				
				if(color[p]==0) {
					info.add(p);
					color[p]=-color[v];
				}
				// 현재 v정점의 색깔과 같은 색깔이면 이분그래프 조건 위배
				else if(color[p]==color[v]) {
					fin=false;
					return;
				}
			}
			
		}
	}

	
	
}
