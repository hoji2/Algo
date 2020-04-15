import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1219_길찾기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][]map;
	static boolean[]visit;
	static boolean find;
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			
			map=new int[100][2];
			visit=new boolean[100];
			find=false;
			
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int idx=stoi(st.nextToken());
				int v=stoi(st.nextToken());
				if(map[idx][0]!=0)
					map[idx][1]=v;
				else
					map[idx][0]=v;
			}
			
			solve(0);
			if(find)
				System.out.println("#"+tc+" "+1);
			else
				System.out.println("#"+tc+" "+0);
		}
	}
	
	public static void solve(int cur) {
		if(cur==99) {
			find=true;
			return;
		}
		
		visit[cur]=true;
		for (int i = 0; i < 2; i++) {
			if(map[cur][i]!=0 && !visit[map[cur][i]])
				solve(map[cur][i]);
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
