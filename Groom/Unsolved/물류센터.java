package groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class 물류센터 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=stoi(br.readLine());
		int res=Integer.MAX_VALUE;
		
		ArrayList<ArrayList<point>> map=new ArrayList<ArrayList<point>>();
		for (int i = 0; i <n; i++) {
			map.add(new ArrayList<point>());
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=stoi(st.nextToken());
			int b=stoi(st.nextToken());
			int v=stoi(st.nextToken());
			map.get(a).add(new point(b, v));
			map.get(b).add(new point(a, v));
		}
		
		Comparator<point>comp=new Comparator<point>() {
			
			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		};
		
		for (int i = 0; i <n; i++) {
			// dp 세팅, pq 세팅
			int[]dp=new int[n];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[i]=0;
			
			PriorityQueue<point> pq=new PriorityQueue<point>(comp);
			pq.add(new point(i, 0));
			
			while(!pq.isEmpty()) {
				point p=pq.poll();
				
				ArrayList<point>tmp=map.get(p.num);
				
				for (int j = 0; j < tmp.size(); j++) {
					point t=tmp.get(j);
					int next_num=t.num;
					int add_val=t.val;
					
					int tmp1=dp[next_num];
					int tmp2=dp[p.num]+add_val;
					dp[next_num]=Math.min(tmp1, tmp2);
					
					if(tmp1!=dp[next_num])
						pq.add(new point(next_num, tmp2));
				}
				
				
			}
			
			int mid=0;
			for(int k : dp)
				mid+=k;
			
			res=Math.min(res, mid);
		}
		
		System.out.println(res);
		
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

class point{
	int num, val;
	public point(int num, int val) {
		this.num=num;
		this.val=val;
				
	}
}