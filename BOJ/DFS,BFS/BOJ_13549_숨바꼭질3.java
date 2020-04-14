import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {

	static Scanner sc=new Scanner(System.in);
	static int n,k;
	public static void main(String[] args) {
	
		n=sc.nextInt();
		k=sc.nextInt();
		
		//다익스트라 
		System.out.println(Dijkstra());
		//0-1 BFS
		//deck(가중치가 0,1과 같이 단순한 경우) -> 굳이 Comparator를 사용하여 복잡한 구현이 필요 x 
		//https://4ngeunlee.tistory.com/209
		System.out.println(Deck());
	}
	
	public static int Deck() {
		int[]visit=new int[100001];
		Arrays.fill(visit, -1);
		Deque<Integer>map=new LinkedList<Integer>();
		map.offer(n);
		visit[n]=0;
		
		while(!map.isEmpty()) {
			int cur=map.poll();
			// 순간이동은 0초가 수행되므로 우선순위가 높아 addFirst
			if (cur * 2 <= 100000 && visit[cur * 2] < 0) {
				map.addFirst(cur * 2);
				visit[cur * 2] = visit[cur];
			}
			// 그 이외에는 addLast
			if (cur - 1 >= 0 && visit[cur - 1] < 0) {
				map.addLast(cur - 1);
				visit[cur - 1] = visit[cur] + 1;
			}
			if (cur + 1 <= 100000 && visit[cur + 1] < 0) {
				map.addLast(cur + 1);
				visit[cur + 1] = visit[cur] + 1;
			}
		}
		
		return visit[k];
		
		
	}
	
	public static int Dijkstra() {
		
		int[]visit=new int[100001];
		Arrays.fill(visit,Integer.MAX_VALUE);
		
		PriorityQueue<point>map=new PriorityQueue<point>(new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		
		map.add(new point(n, 0));
		visit[n]=0;
		
		while(!map.isEmpty()) {
			point cur=map.poll();
			if(cur.num==k)
				return cur.cost;
			
			int[]next= {cur.num*2,cur.num-1,cur.num+1};
			
			for (int j = 0; j < next.length; j++) {
				if(next[j]>=0 && next[j]<=100000) {
					
					int tmp1=visit[next[j]];
					// 순간이동의 경우 시간소모가 없으므로 cur.cost값으로 수행
					if(j==0) {
						visit[next[j]]=Math.min(tmp1, cur.cost);
						if(tmp1!=visit[next[j]])
							map.add(new point(next[j], cur.cost));
					}
					// 이외에는 cur.cost+1, 1초가 더해져 수행
					else {
						visit[next[j]]=Math.min(tmp1, cur.cost+1);
						if(tmp1!=visit[next[j]])
							map.add(new point(next[j], cur.cost+1));
					}
				}
			}
		}
		return -1;
		
	}
}
class point{
	int num,cost;
	public point(int num, int cost) {
		this.num=num;
		this.cost=cost;
	}
}
