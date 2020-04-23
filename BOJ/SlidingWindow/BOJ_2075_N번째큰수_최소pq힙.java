import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번째큰수_최소pq힙 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int size=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		
		for (int i = 0; i < size; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				int num=Integer.parseInt(st.nextToken());
				if(pq.size()<size)
					pq.add(num);
				else if(num>pq.peek()) {
					pq.poll();
					pq.add(num);
				}
			}
		}
		
		System.out.println(pq.poll());
		
	}
	
}
