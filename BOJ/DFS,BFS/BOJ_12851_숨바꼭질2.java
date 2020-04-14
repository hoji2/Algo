import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://velog.io/@hyeon930/BOJ-12851-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-2-Java
public class BOJ_12851_숨바꼭질2 {

	static boolean[] visited;
	static Queue<Integer> q;
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited = new boolean[100001];
		q = new LinkedList<>();
		
		q.offer(N);
		visited[N] = true;
		
      	// 이미 같이 있는 경우
		if(N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		bfs();
	}

	private static void bfs() {
		int time = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			for(int i = 0 ; i < size ; ++i) {
				int cur = q.poll();
				// 꺼낼 때 방문체크 하므로써 다른 방법으로 같은 시간에 도착한 경우들을 허용한다.
				visited[cur] = true;
				
				int[] next = {cur - 1, cur + 1, cur * 2};
				for(int j = 0 ; j < 3 ; ++j) {
					if(next[j] >= 0 && next[j] <= 100000 && !visited[next[j]]) {
						// 현재 최소시간에 도착한 경우 cnt만 증가 -> 따로 add할 필요 없다.
						// 즉 현재 순회하고 있는 loop내 에서 next[j]==K인 경우가 여러개 나올 수 있다.
						// 만일 visit처리를 해버리면 도착 경우의수를 여러개 파악 못한다.
						
						// ㄱ : 따라서 도착여부의 cnt의 카운트를 통해 도착한 경우만 visit 처리를 하지 않고 수행되고 
						if(next[j] == K) {
							cnt++;
							continue;
						}
						//visited[cur][next[j]] = true;
						
						//ㄴ : 중간지점의 정점은 처음 한번만 큐에 넣고, 중간지점이 여러번이 나오는 ㄱ 에서는 체크를 안한다.
						//ㄷ : 최종 방문처리는 위에 poll할 때 수행한다.
						q.offer(next[j]);
					}
				}
			}
			// cnt가 올라간건 최소시간에 도착했다는 것으로 이후 시간에 도착하는 것은 무의미하다.
			if(cnt != 0)
				break;
		}
		System.out.println(time);
		System.out.println(cnt);
	}
}
