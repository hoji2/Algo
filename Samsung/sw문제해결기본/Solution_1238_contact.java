import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_contact {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][]map;
	static boolean[]visit;
	
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			st.nextToken();
			int start=stoi(st.nextToken());
			
			map=new int[101][101];
			visit=new boolean[101];
			
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				map[stoi(st.nextToken())][stoi(st.nextToken())]=1;
			
			System.out.println("#"+tc+" "+solve(start));
		}
	}
	
	public static int solve(int st) {
		Queue<Integer>tmp=new LinkedList<Integer>();
		tmp.add(st);
		visit[st]=true;
		int bef,res=0;
		while(!tmp.isEmpty()){
			int loop=tmp.size();
			bef=0;
			for (int i = 0; i < loop; i++) {
				int next=tmp.poll();
				for (int j = 1; j <=100; j++) {
					if(map[next][j]==1 && !visit[j]) {
						// 중요!!(방문처리는 넣을 때 해줘야함)
						visit[j]=true;
						tmp.add(j);
						bef=Math.max(bef, j);
					}
				}
			}
			if(tmp.isEmpty())
				break;
			
			res=bef;
		}
		return res;
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
