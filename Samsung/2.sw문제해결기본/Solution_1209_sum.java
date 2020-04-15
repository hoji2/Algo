import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209_sum {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][]map;
	static int res;
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			br.readLine();
			map=new int[100][100];
			res=0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int idx=0;
				while(st.hasMoreTokens())
					map[i][idx++]=stoi(st.nextToken());
			}
			
			for (int i = 0; i < 100; i++) {
				res=Math.max(res, solve(i,true));
				res=Math.max(res, solve(i,false));
			}
			
			int left_to_right=0;
			int right_to_left=0;
			
			int row=0;
			int p=99;
			while(row<=99) {
				left_to_right+=map[row][99-p];
				right_to_left+=map[row][p];
				row++;
				p--;
			}
			
			res=Math.max(res, Math.max(left_to_right, right_to_left));
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static int solve(int st, boolean row) {
		int tmp=0;
		
		if(row) {
			for (int i = 0; i < 100; i++) {
				tmp+=map[st][i];
			}
		}else {
			for (int i = 0; i < 100; i++) {
				tmp+=map[i][st];
			}
		}
		return tmp;
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
