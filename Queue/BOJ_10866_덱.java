import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866_덱 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int n=Integer.parseInt(br.readLine());
		LinkedList<Integer> tmp=new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			
			if(s.equals("push_front"))
				tmp.addFirst(Integer.parseInt(st.nextToken()));
			else if(s.equals("push_back"))
				tmp.addLast(Integer.parseInt(st.nextToken()));
			else if(s.equals("pop_front"))
				if(tmp.isEmpty())
					System.out.println(-1);
				else {
					System.out.println(tmp.peekFirst());
					tmp.removeFirst();
				}
			else if(s.equals("pop_back"))
				if(tmp.isEmpty())
					System.out.println(-1);
				else {
					System.out.println(tmp.peekLast());
					tmp.removeLast();
				}
			else if(s.equals("size"))
				System.out.println(tmp.size());
			else if(s.equals("empty"))
				if(tmp.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			else if(s.equals("front"))
				if(tmp.isEmpty())
					System.out.println(-1);
				else
					System.out.println(tmp.peekFirst());
			else if(s.equals("back"))
				if(tmp.isEmpty())
					System.out.println(-1);
				else
					System.out.println(tmp.peekLast());
		}
	}
}
