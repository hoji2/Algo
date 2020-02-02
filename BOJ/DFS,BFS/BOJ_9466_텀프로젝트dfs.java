import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트dfs {

	//https://beenlife.tistory.com/18
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n,res;
	static int[]map;
	static boolean[]visit, finish;
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			
			n=Integer.parseInt(br.readLine());
			map=new int[n+1];
			visit=new boolean[n+1];
			finish=new boolean[n+1];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for (int j = 1; j <=n; j++) {
				map[j]=Integer.parseInt(st.nextToken());
			}
			
			res=0;
			for (int j = 1; j <=n; j++) {
				if(!visit[j]) {
					dfs(j);
				}
			}
			
			//res : 몇개의 순환 사이클이 나뉘는지는 모른다. 다만 여러 싸이클중 하나에 속해있는 정점의 개수들
			System.out.println(n-res);
		}
	}
	
	public static void dfs(int st) {
		
		visit[st]=true;
		
		int next=map[st];
		
		if(!visit[next])
			dfs(next);
		else {
			// 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
            // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재

			// 첫번쨰 tc 기준
			//1) 4->7->6->4 루프까지 돌았음 : DFS(4)의 재귀가 계속 돌고있음			 
			if(!finish[next]){
				//2) 현재(st=6)기준 다음(next=4)의 DFS가 끝나지 않았음 -> 1)상황이다
				//3) 따라서 다음(next=4)을 기준으로 싸이클이 무조건 존재한다
				//4) 일단 현재(st=6)의 정점을 카운트한다 -> 이는 제일 사이클의 마지막점(4->7->6)
				res++;
				//5) 현재 카운트 tmp=1(정점6)
				
				//6) 그렇다면 사이클 시작인 다음(next=4)을 시작으로 사이클 끝인 현재(st=6)까지 루프를 돌아야함
				//7) 반복문 조건 : 사이클의 시작 4, 다음 방문값은 map[4] , 다음 방문값이 사이클의 끝인 6과 같지 않아야함 
				//8) 처음 4 방문 -> 4!=6 -> res++; -> map[4]=7 -> 7!=6 -> res++ -> map[7]=6 -> 6==6 -> 종료
				//9) 최종적으로 tmp=3(기존 : 정점6, new : 정점 4, 정점 7)
				for (int i = next; i!=st; i=map[i]) {
					res++;
				}
			}
		}
		// DFS가 종료됬음을 선언
		finish[st]=true;
	}
}
