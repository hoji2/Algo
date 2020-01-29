import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		Stack<Integer> tmp=new Stack<Integer>();
		int n=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			String s=st.nextToken();
			
			if(s.equals("push"))
				tmp.add(Integer.parseInt(st.nextToken()));
			else if(s.equals("top"))
				if(tmp.size()==0)
					System.out.println(-1);
				else
					System.out.println(tmp.peek());
			else if(s.equals("size"))
				System.out.println(tmp.size());
			else if(s.equals("empty"))
				if(tmp.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			else if(s.equals("pop"))
				if(tmp.size()==0)
					System.out.println(-1);
				else
					System.out.println(tmp.pop());
		}
	}
}
