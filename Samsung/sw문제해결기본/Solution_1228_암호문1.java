import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			br.readLine();
			
			LinkedList<String> tmp=new LinkedList<String>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				tmp.add(st.nextToken());
			
			br.readLine();
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				st.nextToken();
				int idx=Integer.parseInt(st.nextToken());
				int cnt=Integer.parseInt(st.nextToken());
				while(cnt>0) {
					tmp.add(idx++, st.nextToken());
					cnt--;
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(tmp.get(i)+" ");
			}
			System.out.println();
		}
	}
}
