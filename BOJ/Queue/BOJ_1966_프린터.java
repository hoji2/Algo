import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class BOJ_1966_프린터 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		int tc=sc.nextInt();
		
		for (int t1 = 0; t1 < tc; t1++) {
			int[]map=new int[sc.nextInt()];
			int idx=sc.nextInt();
			
			for (int j = 0; j < map.length; j++) {
				map[j]=sc.nextInt();
				
			}
			
			// 프린터될 value들을 저장하는 우선순위큐
			PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			
			Queue<info> move=new LinkedList<info>();
			
			for (int i = 0; i < map.length; i++) {
				pq.add(map[i]);
				move.add(new info(map[i], i));
			}
			
			
			int comp=pq.poll();
			int time=1;
			while(true) {
				
				info p=move.poll();
				
				if(p.val==comp) {
					if(p.order==idx) {
						break;
					}
					// 현재 comp가 나오면서 time을 증가하고 다음 comp값을 pq에서 뽑기
					else {
						time++;
						comp=pq.poll();
					}
				}else {
					move.add(p);
				}
			}
			System.out.println(time);
			
		}
		
	}
	
}

class info{
	int val,order;
	
	public info(int val, int order) {
		this.val=val;
		this.order=order;
	}
}