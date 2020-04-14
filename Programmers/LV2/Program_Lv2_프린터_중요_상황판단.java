import java.util.*;
public class Program_Lv2_프린터_중요_상황판단 {

	public static void main(String[] args) {
		
		int[]map= {2,1,3,2};
		int idx=2;
		
		// 프린터될 value들을 저장하는 우선순위큐
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		Queue<pri> move=new LinkedList<pri>();
		
		for (int i = 0; i < map.length; i++) {
			pq.add(map[i]);
			move.add(new pri(map[i], i));
		}
		
		
		int comp=pq.poll();
		int time=1;
		while(true) {
			
			pri p=move.poll();
			
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

class pri{
	int val,order;
	
	public pri(int val, int order) {
		this.val=val;
		this.order=order;
	}
}