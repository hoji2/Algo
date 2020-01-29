import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름dfs {

	//https://looview.tistory.com/67
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<ArrayList<point>> map=new ArrayList<ArrayList<point>>();
	static int n,res=0,fin;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n=Integer.parseInt(br.readLine());
		
		for (int i = 0; i <=n; i++) {
			map.add(new ArrayList<point>());
		}
		
		for (int i = 1; i <=n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			
			while(st.countTokens()!=1) {
				int d=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				// 입력에서 양방향으로 주어짐
				map.get(v).add(new point(d, c));
			}
		}
		

		visit=new boolean[n+1];
		dfs(1,0);

		int first=res;
		
		res=0;
		Arrays.fill(visit, false);
		dfs(fin,0);
		
		System.out.println(Math.max(first, res));
	}
	
	public static void dfs(int v, int current_dist) {
		
		visit[v]=true;
		
		if (current_dist > res) {
	        res = current_dist;
	        fin = v;
	    }
		
		for (int i = 0; i < map.get(v).size(); i++) {
			int next=map.get(v).get(i).num;
			int next_cost=map.get(v).get(i).d+current_dist;
			
			if(!visit[next]) {
				dfs(next,next_cost);
			}
		}
	}
	
	/*
	 [DFS 틀린코드]
	 
	 public static void dfs(int v, int current_dist) {
		
		visit[v]=true;
		
		for (int i = 0; i < map.get(v).size(); i++) {
			int next=map.get(v).get(i).num;
			int next_cost=map.get(v).get(i).d+current_dist;
			
			if(!visit[next]) {
				res=next_cost;
				fin=next;
				dfs(next,next_cost);
			}
		}
	}
	 */
}

class point{
	int num, d;
	public point(int num, int d) {
		this.num=num;
		this.d=d;
	}
}
