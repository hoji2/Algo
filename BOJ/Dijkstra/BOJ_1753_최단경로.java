import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753_최단경로{

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int v=sc.nextInt();
		int st=sc.nextInt();
		
		int[]res=new int[n+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		
		ArrayList<ArrayList<point>>map=new ArrayList<ArrayList<point>>();
		
		for (int i = 0; i <=n; i++)
			map.add(new ArrayList<point>());
		
		for (int i = 0; i < v; i++)
			map.get(sc.nextInt()).add(new point(sc.nextInt(), sc.nextInt()));
		
		PriorityQueue<point>pq=new PriorityQueue<point>(new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				return o1.val-o2.val;
			}
		});
		
		res[st]=0;
		pq.add(new point(st, 0));
		
		while(!pq.isEmpty()) {
			point p=pq.poll();
			for (int i = 0; i < map.get(p.end).size(); i++) {
				point next=map.get(p.end).get(i);
				
				int tmp1=res[next.end];
				int tmp2=p.val+next.val;
				
				res[next.end]=Math.min(tmp1, tmp2);
				if(tmp1!=res[next.end])
					pq.add(new point(next.end, res[next.end]));
			}
		}
		
		for (int i = 1; i <=n; i++) {
			if(res[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(res[i]);
		}
	}
}

class point{
	int end,val;
	public point(int end, int val) {
		this.end=end;
		this.val=val;
	}
}