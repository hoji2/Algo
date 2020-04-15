import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_9317 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			br.readLine();
			char[]c1=br.readLine().toCharArray();
			char[]c2=br.readLine().toCharArray();
			
			int res=0;
			
			for (int i = 0; i < c2.length; i++) {
				if(c1[i]==c2[i])
					res++;
			}
			
			System.out.println("#"+t+" "+res);
			
		}
	}
}
