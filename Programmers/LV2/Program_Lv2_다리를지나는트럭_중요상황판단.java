import java.util.LinkedList;
import java.util.Queue;

public class Program_Lv2_다리를지나는트럭_중요상황판단 {
	
	//https://jayrightthere.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4JAVA-%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EA%B1%B4%EB%84%88%EB%8A%94-%ED%8A%B8%EB%9F%AD

	public static void main(String[] args) {

		int bridge_length=2;
		int weight=10;
		int []map= {7,4,5,6};
		
		Queue<point> wait=new LinkedList<point>();
		Queue<point> tmp=new LinkedList<point>();
		
		for(int i : map)
			wait.add(new point(i, 0));
		
		int time=0;
		tmp.add(wait.poll());
		int current_weight=tmp.peek().weight;
		
		// 다리를 움직이는 기차가 존재하는 경우 -> 혹여나 한 기차가 도착해서 빠져나간다고 해도 다음에 wait에서 오를 수 있는지 확인
		// 모든 기차가 통과전에 다리가 비어있는 경우는 없다.
		
		while(!tmp.isEmpty()) {
			// 시간 흐름
			time++;
			
			// 한칸씩 이동
			for(point p : tmp)
				p.len++;
			
			// 현재 큐에 맨 앞에있는(가장 일찍출발한) 포인트가 도착지점일경우
			if(tmp.peek().len==bridge_length)
				current_weight-=tmp.poll().weight;
			
			// 현재 current_weight를 기준으로 더 오를 수 있는지 확인
			if(!wait.isEmpty() && wait.peek().weight+current_weight<=weight) {
				point p=wait.poll();
				current_weight+=p.weight;
				tmp.add(p);
			}
			
		}
		//마지막 종료 후 +1
		System.out.println(time+1);
	}
}

class point{
	int weight, len;
	public point(int weight, int len) {
		this.weight=weight;
		this.len=len;
	}
}