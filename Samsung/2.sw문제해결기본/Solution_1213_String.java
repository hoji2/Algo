import java.io.*;
import java.util.*;

public class Solution_1213_String {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		for (int tc = 1; tc <=10; tc++) {
			br.readLine();
			String find=br.readLine();
			String arr=br.readLine();
			
			Queue<Integer> tmp=new LinkedList<Integer>();
			
			char p=find.charAt(0);
			
			for (int i = 0; i < arr.length(); i++) {
				if(arr.charAt(i)==p)
					tmp.add(i);
			}
			
			int step=1;
			while(!tmp.isEmpty()) {
				if(step==find.length())
					break;
				
				int loop=tmp.size();
				for (int i = 0; i < loop; i++) {
					int q=tmp.poll()+1;
					if(q<arr.length() && find.charAt(step)==arr.charAt(q)) {
						tmp.add(q);
					}
				}
				step++;
			}
			
			System.out.println("#"+tc+" "+tmp.size());
			
		}
		
	}
	
}
