import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질_재풀이 {

	static Scanner sc=new Scanner(System.in);
	static int st,end;
	static boolean[]visit=new boolean[100001];
	static Queue<Integer> tmp=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		
		st=sc.nextInt();
		end=sc.nextInt();
		tmp.add(st);
		System.out.println(solve());
	}
	
	public static int solve() {
		// 초기 입력==도착
		// 출발>도착 인경우 (도착점이 0인거를 고려하여) 
		// : 두 사이의 거리차의 절대값으로 구한다.
		if(st>=end)
			return Math.abs(end-st);
		
		int res=0;
		
		while(!tmp.isEmpty()) {
			
			int loop=tmp.size();
			res++;
			
			for (int i = 0; i < loop; i++) {

				int cur=tmp.poll();
				visit[cur]=true;
				
				int case1=cur-1;
				int case2=cur+1;
				int case3=cur*2;
				
				// 배열에 들어가는 값의 유호범위 체크가 가장 우선
				if(case1>=0 && !visit[case1]) {
					if(case1==end)
						return res;
					
					visit[case1]=true;
					tmp.add(case1);		
				}
				
				if(case2<=100000 && !visit[case2]) {
					if(case2==end)
						return res;
					
					visit[case2]=true;
					tmp.add(case2);
				}
				
				if(case3<=100000 && !visit[case3]) {
					if(case3==end)
						return res;
					
					visit[case3]=true;
					tmp.add(case3);
				}
			}
			
		}
		return -1;
	}
}
