import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1230_암호문3 {

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
				char p=st.nextToken().charAt(0);
				if(p=='I') {
					int idx=Integer.parseInt(st.nextToken());
					int cnt=Integer.parseInt(st.nextToken());
					while(cnt>0) {
						tmp.add(idx++, st.nextToken());
						cnt--;
					}
				}else if(p=='D') {
					int idx=Integer.parseInt(st.nextToken());
					int cnt=Integer.parseInt(st.nextToken());
					for (int i = 0; i < cnt; i++) {
						tmp.remove(idx);
					}
				}else {
					int cnt=Integer.parseInt(st.nextToken());
					for (int i = 0; i < cnt; i++) {
						tmp.addLast(st.nextToken());
					}
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
