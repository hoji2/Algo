import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_13913_숨바꼭질4 {

	static Scanner sc=new Scanner(System.in);
	static int n,k;
	public static void main(String[] args) {
		
		n=sc.nextInt();
		k=sc.nextInt();
		//BFS 경로 출력
		//parents 배열 사용
		solve();
	}
	
	public static void solve() {
		int time=0;
		boolean[]visit=new boolean[100001];
		int[]parents=new int[100001];
		Arrays.fill(parents, -1);
		
		Queue<Integer>map=new LinkedList<Integer>();
		map.add(n);
		visit[n]=true;
		// ㄱ : print부분에서 참조
		parents[n]=n;
		
		while(!map.isEmpty()) {
			int loop=map.size();
			
			for (int i = 0; i < loop; i++) {
				int cur=map.poll();
				if(cur==k) {
					System.out.println(time);
					print(parents);
					return;
				}
				
				int[]next= {cur-1,cur+1,cur*2};
				for (int j = 0; j < next.length; j++) {
					if(next[j]>=0 && next[j]<=100000 && !visit[next[j]]) {
						visit[next[j]]=true;
						// 다음 방문할 next인덱스에는 이전방문기록인 cur기록
						parents[next[j]]=cur;
						map.add(next[j]);
					}
				}
			}
			time++;
		}
	}
	
	public static void print(int[]parents) {
		// 스택사용
		Stack<Integer>tmp=new Stack<Integer>();
		// 매일 마지막 정점 k
		int cur=k;
		
		// 출발점은 ㄱ 과같이 parents[cur]=cur이다.
		// 이에 이를 해당하지 않을 경우는 cur를 스택에넣고 새로운 cur로 갱신작업 반복
		while(parents[cur]!=cur) {
			tmp.add(cur);
			cur=parents[cur];
		}
		
		System.out.print(n+" ");
		while(!tmp.isEmpty())
			System.out.print(tmp.pop()+" ");
	}
}
