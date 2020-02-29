import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1216_회문2 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char[][]map;
	static int cnt;
	static int size=100;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			
			br.readLine();
			map=new char[size][size];
			cnt=0;
			for (int i = 0; i < size; i++) {
				String s=br.readLine();
				for (int j = 0; j < size; j++) {
					cnt=Math.max(cnt, solve(s.substring(j,s.length())));
				}
				map[i]=s.toCharArray();
			}
			
			// 세로
			for (int i = 0; i < size; i++) {
				StringBuilder s=new StringBuilder();
				for (int j = 0; j < size; j++) {
					s.append(map[j][i]+"");
				}
				
				for (int j = 0; j < size; j++) {
					cnt=Math.max(cnt, solve(s.toString().substring(j,s.length())));
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	
	public static int solve(String s) {

		int tmp=1;
		int ori_len=s.length();
		int idx=1;
		while(idx!=ori_len+1) {
			StringBuilder text=new StringBuilder(s.substring(0,idx));
			if(text.toString().equals(text.reverse().toString())) {
				tmp=Math.max(tmp, text.length());
			}
			idx++;
		}
		return tmp;
		
	}
	
}
