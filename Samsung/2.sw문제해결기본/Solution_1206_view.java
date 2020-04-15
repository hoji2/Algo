import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_view {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[]map;
	public static void main(String[] args) throws IOException {
		
		for (int tc = 1; tc <=10; tc++) {
			
			int size=stoi(br.readLine());
			map=new int[size];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int idx=0;
			int res=0;
			while(st.hasMoreTokens())
				map[idx++]=stoi(st.nextToken());
			
			for (int i = 2; i <=size-3; i++) {
				res+=solve(i);
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static int solve(int idx) {
		
		int mid=0;
		
		int left1=map[idx-1];
		int left2=map[idx-2];
		int right1=map[idx+1];
		int right2=map[idx+2];
		
		int fin_left=Math.max(left1, left2);
		int fin_right=Math.max(right1, right2);
		int cur=map[idx];
		
		if(fin_left<cur && fin_right<cur) {
			mid+=cur-Math.max(fin_left, fin_right);
		}
		
		return mid;
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
