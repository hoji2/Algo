import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D191217_BOJ_1697_숨바꼭질 {

	/*
	 
	 조건 1) 출발지=도착지
	 조건 2) 움직이는 좌표가 음수가 된느 경우(0 이상 100000 이하)
	 조건 3) visit배열을 통해 이미 방문한 좌표는 재방문X
	 조건 4) 뒤로 가는 것도 고려(100000,0)
	 
	 
	 */
	static Scanner sc=new Scanner(System.in);
	static int fix,res=0;
	static boolean[]visit=new boolean[100001];
	static int[]candi=new int[3];
	
	static Queue<Integer> tmp=new LinkedList<Integer>();
	
	public static void main(String[] args) {

		tmp.add(sc.nextInt());
		fix=sc.nextInt();
		
		bfs();
		System.out.println(res);
	}
	
	public static void bfs() {
		
		while(!tmp.isEmpty()) {
			
			// 출발지와 도착지가 같은 경우
			if(tmp.peek()==fix)
				return;
			
			int loop=tmp.size();
			res++;
			
			for (int i = 0; i < loop; i++) {
				
				int current=tmp.poll();
				candi[0]=current-1;
				candi[1]=current+1;
				candi[2]=current*2;
				
				for (int j = 0; j < candi.length; j++) {
					// 뒤로 가는 것도 생각(100000, 0)
					
					if(candi[j]<0 || candi[j]>100000) {
						continue;
					}
					// 이전에 탐색하지 않은 케이스만 고려
					if(!visit[candi[j]]) {
						if(candi[j]==fix) {
							return;
						}else {
							visit[candi[j]]=true;
							tmp.add(candi[j]);
						}
					}
				}
			}
		}
	}
}
