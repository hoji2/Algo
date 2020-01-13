import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1753_최단경로 {

	static Scanner sc= new Scanner(System.in);
	static int[]dp;
	//visit 배열 사용 안하는 이유  -> 가중치가 다른 여러 간선이 있으므로?
	static Queue<point> pq;
	// 메모리 초과 원인 -> 인접행렬을 인접리스트로 변환하자
	static ArrayList<ArrayList<point>> map;
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int v=sc.nextInt();
		int st=sc.nextInt();
		
		map=new ArrayList<ArrayList<point>>();
		
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<point>());
		}
		
		dp=new int[n+1];
		
		Comparator<point> comp=new Comparator<point>() {
			
			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		};
		
		pq=new PriorityQueue<point>(comp);
		
		for (int i = 0; i < v; i++) {
			map.get(sc.nextInt()).add(new point(sc.nextInt(), sc.nextInt()));
		}
		
		for (int i = 1; i <= n; i++) {
			if(i==st)
				dp[st]=0;
			else
				dp[i]=Integer.MAX_VALUE;
		}
		
		pq.add(new point(st, 0));
		
		while(!pq.isEmpty()) {
			point p=pq.poll();
			
			for (int i = 0; i <map.get(p.num).size(); i++) {
				// idx1 : 출발점 , idx2 : 도착점
				// tmp1 : 도착점에 존재하는 최신 최소값(idx2기준) , tmp2 : idx1을 거쳐 가중치를 더해진 새로운 경로(idx1 기준)
				
				int idx1=p.num;
				int idx2=map.get(idx1).get(i).num;
				
				int tmp1=dp[idx2];
				int tmp2=dp[idx1]+map.get(idx1).get(i).val;
				
				dp[idx2]=Math.min(tmp1,tmp2);
				
				//시간 초과
				if(tmp1!=dp[idx2])
					pq.add(new point(idx2, dp[idx2]));
				}
			}
		
		for (int i = 1; i <=n; i++) {
			if(dp[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dp[i]);
		}
		
		
	}
}

class point{
	int num,val;
	
	public point(int num, int val) {
		this.num=num;
		this.val=val;
	}
}
