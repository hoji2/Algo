import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1238_파티 {

	static Scanner sc=new Scanner(System.in);
	static int n,p;
	static ArrayList<ArrayList<point>> map;
	static int[]res;
	static Comparator<point> comp;
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		int v=sc.nextInt();
		p=sc.nextInt();
		res=new int[n+1];
		
		comp=new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		};
		
		map=new ArrayList<ArrayList<point>>();
		
		for (int i = 0; i <=n; i++) {
			map.add(new ArrayList<point>());
		}
		
		for (int i = 0; i < v; i++) {
			map.get(sc.nextInt()).add(new point(sc.nextInt(), sc.nextInt()));
		}
		
		for (int i = 1; i <=n; i++) {
			solve1(i);
		}
		Arrays.sort(res);
		System.out.println(res[n]);
	}
	
	public static void solve1(int i) {
		
		Queue<point> pq=new PriorityQueue<point>(comp);
		int[]dp=new int[n+1];
		
		for (int j = 1; j <=n; j++) {
			if(j==i)
				dp[j]=0;
			else
				dp[j]=Integer.MAX_VALUE;
		}
		
		pq.add(new point(i, 0));
		
		while(!pq.isEmpty()) {
			point p=pq.poll();
			
			int idx1,idx2,tmp1,tmp2;
			
			idx1=p.num;
			
			for (int j = 0; j < map.get(idx1).size(); j++) {
				idx2=map.get(idx1).get(j).num;
				tmp1=dp[idx2];
				tmp2=dp[idx1]+map.get(idx1).get(j).val;
				dp[idx2]=Math.min(tmp1, tmp2);
				
				if(tmp1!=dp[idx2])
					pq.add(new point(idx2, dp[idx2]));
			}
		}
		
		if(i!=p) {
			res[i]+=dp[p];
		}else {
			for (int j = 1; j <=n; j++) {
				res[j]+=dp[j];
			}
		}
	}
}

class point{
	int num, val;
	
	public point(int num, int val) {
		this.num=num;
		this.val=val;
	}
}