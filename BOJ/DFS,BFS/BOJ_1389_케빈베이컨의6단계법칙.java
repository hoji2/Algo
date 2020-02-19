import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1389_케빈베이컨의6단계법칙 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map;
	static int n;
	static boolean []visit;
	static PriorityQueue<kevin> mid;
	public static void main(String[] args) {
	
		n=sc.nextInt();
		int k=sc.nextInt();
		map=new int[n+1][n+1];
			
		for (int i = 0; i < k; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map[a][b]=1;
			map[b][a]=1;
		}
		
		mid=new PriorityQueue<kevin>(new Comparator<kevin>() {

			@Override
			public int compare(kevin o1, kevin o2) {
				if(o1.v==o2.v)
					return o1.idx-o2.idx;
							
				return o1.v-o2.v;
			}
		});
		
		for (int i = 0; i <n; i++) {
			visit=new boolean[n+1];
			bfs(i+1);
		}
		System.out.println(mid.poll().idx);
	}
	
	public static void bfs(int st) {
		
		Queue<Integer> tmp=new LinkedList<Integer>();
		tmp.add(st);
		visit[st]=true;
		int res=0;
		int idx=1;
		
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			
			for (int l = 0; l < loop; l++) {
				int p1=tmp.poll();
				for (int i = 1; i <=n; i++) {
					if(!visit[i] && map[p1][i]==1) {
						visit[i]=true;
						res+=idx;
						tmp.add(i);
					}
				}
			}
			idx++;
		}
		
		mid.add(new kevin(st, res));
	}
}

class kevin{
	int idx, v;
	public kevin(int idx, int v) {
		this.idx=idx;
		this.v=v;
	}
}

