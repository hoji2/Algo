import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1231_중위순회 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char[]text;
	static int[][]map;
	static boolean[]visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			
			int size=stoi(br.readLine());
			text=new char[size+1];
			map=new int[size+1][2];
			visit=new boolean[size+1];
			sb=new StringBuilder();
			sb.append("#"+tc+" ");
			
			for (int i = 0; i < size; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				
				int idx=stoi(st.nextToken());
				char p=st.nextToken().charAt(0);
				text[idx]=p;
				
				int tmp=0;
				while(st.hasMoreTokens())
					map[idx][tmp++]=stoi(st.nextToken());
			}
			
			solve(1);
			System.out.println(sb.toString());
		}
	}
	
	public static void solve(int st) {
		
		if(visit[st])
			return;
		
		int left=map[st][0];
		int right=map[st][1];
		
		if(left!=0) {
			solve(left);
			sb.append(text[st]+"");
			visit[st]=true;
		}
		
		if(right!=0)
			solve(right);
		
		if(!visit[st])
			sb.append(text[st]+"");
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
