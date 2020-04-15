import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_flatten {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			int dump=stoi(br.readLine());
			int[]map=new int[100];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int idx=0;
			while(st.hasMoreTokens())
				map[idx++]=stoi(st.nextToken());
			
			while(dump!=0) {
				Arrays.sort(map);
				if(map[0]==map[99])
					break;
				
				map[0]++;
				map[99]--;
				dump--;
			}
			Arrays.sort(map);
			System.out.println("#"+tc+" "+(map[99]-map[0]));
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
