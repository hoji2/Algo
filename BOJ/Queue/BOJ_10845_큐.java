import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		LinkedList<Integer>tmp=new LinkedList<Integer>();

		int n=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			String s=st.nextToken();
			
			if(s.equals("push"))
				tmp.add(Integer.parseInt(st.nextToken()));
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
			else if(s.equals("pop")) {
				if(tmp.isEmpty())
					System.out.println(-1);
				else {
					System.out.println(tmp.peekFirst());
					tmp.removeFirst();
				}
			}else if(s.equals("size"))
				System.out.println(tmp.size());
			else if(s.equals("empty"))
				if(tmp.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
		}
	}
}
