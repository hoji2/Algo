import java.io.*;
import java.util.*;

public class Solution_1234_비밀번호 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			st.nextToken();
			char[]arr=st.nextToken().toCharArray();
			Stack<Character>tmp=new Stack<Character>();
			for (int i = 0; i < arr.length; i++) {
				if(tmp.isEmpty())
					tmp.add(arr[i]);
				else {
					char bef=tmp.peek();
					if(bef==arr[i])
						tmp.pop();
					else
						tmp.add(arr[i]);
				}
			}
			System.out.print("#"+tc+" ");
			StringBuilder sb=new StringBuilder();
			while(!tmp.isEmpty())
				sb.append(tmp.pop()+"");
			System.out.println(sb.reverse().toString());
		}
	}
}
