import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

	// DFS : https://jaimemin.tistory.com/585 
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[]parrent;
	static boolean[]visit;
	static ArrayList<ArrayList<Integer>>tmp=new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n=Integer.parseInt(br.readLine());
		parrent=new int[n+1];
		visit=new boolean[n+1];
		
		for (int i = 0; i <=n; i++) {
			tmp.add(new ArrayList<Integer>());
		}
		
		for (int i = 1; i <=n-1; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			// (중요) 부모가 a인지 b인지 모르니 일단 연결
			tmp.get(a).add(b);
			tmp.get(b).add(a);
		}

//		dfs(1);
		bfs();
		
		for (int i = 2; i <=n ; i++) {
			bw.write(parrent[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int st) {
		
		// (중요!) 방문했다는 것은 부모를 찾았다는 의미 !
		visit[st]=true;
		
		for (int i = 0; i < tmp.get(st).size(); i++) {
			int next=tmp.get(st).get(i);
			if(!visit[next]) {
				parrent[next]=st;
				dfs(next);
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> info=new LinkedList<Integer>();
		
		info.add(1);
		
		while(!info.isEmpty()) {
			int p=info.poll();
			visit[p]=true;
			
			for (int i = 0; i < tmp.get(p).size(); i++) {
				int next=tmp.get(p).get(i);
				if(!visit[next]) {
					parrent[next]=p;
					info.add(next);
				}
			}
		}
	}
	
}
