import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n=sc.nextInt();
		int v=sc.nextInt();
		
		Comparator<point> comp=new Comparator<point>() {
			
			@Override
			public int compare(point o1, point o2) {
				return o1.val-o2.val;
			}
		};
		// 인접행렬 시 메모리초과
		ArrayList<ArrayList<point>> map=new ArrayList<ArrayList<point>>();
		int[]dp=new int[n+1];
		Queue<point> pq=new PriorityQueue<point>(comp);
		// 0번 idx ArrayList는 사용 X
		for (int i = 0; i <=n; i++) {
			map.add(new ArrayList<point>());
		}
		
		for (int i = 0; i < v; i++) {
			map.get(sc.nextInt()).add(new point(sc.nextInt(), sc.nextInt()));
		}
		
		int st=sc.nextInt();
		int end=sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			if(i==st)
				dp[i]=0;
			else
				dp[i]=Integer.MAX_VALUE;
		}
		
		pq.add(new point(st, 0));
		
		while(!pq.isEmpty()) {
			point p=pq.poll();
			
			// id1 : 출발 , idx2 : 도착, tmp1 : 기존 최소값(idx2기준), tmp2 : 갱신할  값
			int idx1, idx2, tmp1,tmp2;
			idx1=p.num;
			
			for (int i = 0; i <map.get(p.num).size(); i++) {
				
				idx2=map.get(idx1).get(i).num;
				tmp1=dp[idx2];
				tmp2=dp[idx1]+map.get(idx1).get(i).val;
				dp[idx2]=Math.min(tmp1, tmp2);
				
				if(tmp1!=dp[idx2])
					pq.add(new point(idx2, dp[idx2]));
			}
		}
		
		System.out.println(dp[end]);
		
	}
}

class point{
	int num,val;
	public point(int num, int val) {
		this.num=num;
		this.val=val;
	}
}