package swea;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12026_boj거리 {

	static Scanner sc=new Scanner(System.in);
	static int n, res;
	static char[]map;
	static char[]dir= {'B','O','J'};
	static int[]dp;
	static Queue<point> tmp=new LinkedList<point>();
	public static void main(String[] args) {
		n=sc.nextInt();
		sc.nextLine();
		map=sc.nextLine().toCharArray();
		// 정점을 한번 방문하는 케이스가 아니다 -> dp 배열 사용하여 최소값을 찾자
		dp=new int[n];
		
		// (중요) bfs or dfs형태를 띤 dp문제 !! -> 여러번 정점을 방문하는 경우이기에
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		tmp.add(new point(0, 0));
		dp[0]=0;
		while(!tmp.isEmpty()) {
			point p=tmp.poll();
			
			int ch=(p.char_idx+1)%3;
			for (int i = p.num_idx+1; i <=n-1; i++) {
				if(map[i]==dir[ch]) {
					// 매번 탐색마다 v값을 가지고 다녀서 참고하는 것은 항상 그 v값이 최소값이 아니라서 시간초과
					// 따라서 해당 p.num_idx까지 올 수 있는 가장 최소값이 저장되어있는 dp배열을 사용
					int next_v=dp[p.num_idx]+(int)Math.pow((i-p.num_idx), 2);
					if(dp[i]>next_v) {
						dp[i]=next_v;
						tmp.add(new point(i,ch));
					}
				}
			}
		}
		
		if(dp[n-1]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[n-1]);
	}
}

class point{
	int num_idx, char_idx;
	public point(int num_idx, int char_idx) {
		this.num_idx=num_idx;
		this.char_idx=char_idx;
	}
}
