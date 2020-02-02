import java.util.Scanner;

public class BOJ_2251_물통 {

	// https://mygumi.tistory.com/228
	
	static Scanner sc=new Scanner(System.in);
	//a,b의 물통 정보를 담을 배열(DFS 순회를 위한 배열)
	static boolean [][]visit=new boolean[201][201];
	//c의 물통 정보를 담을 배열(최총 출력을 위한 배열)
	static boolean[] check=new boolean[201];
	// 초기 물통의 용량
	static int ia,ib,ic;
	
	
	public static void main(String[] args) {
	
		ia=sc.nextInt();
		ib=sc.nextInt();
		ic=sc.nextInt();
		
		solve(0,0,ic);
		for (int i = 0; i < 201; i++) {
			if(check[i])
				System.out.print(i+" ");
		}
	}
	
	
	public static void solve(int ca, int cb, int cc) {
		
		if(visit[ca][cb])
			return;
		
		if(ca==0)
			check[cc]=true;
		
		visit[ca][cb]=true;
		
		// a,b,c 이동의 경우는 총 6가지(모든 물을 한번에 옴긴다는 가정으로 케이스를 나눌 수 있음)
		
		// case 1) a->b, b->a, c->a, c->b (넘치는 경우를 고려하는 경우)
		
		// 1-1) a->b
		// 최대 용량 ib기준 넘치는 경우
		// b에는 ib만큼 꽉 차고, a는 ca+cb-ib의 물이 남는다.
		if(ca+cb>ib)
			solve(ca+cb-ib, ib, cc);
		// ib에 넘치지 않으면 a용량은 0이 되고 b는 ca+cb
		else
			solve(0, ca+cb, cc);
		
		// 1-2) b->a
		if(cb+ca>ia)
			solve(ia, ca+cb-ia, cc);
		else
			solve(ca+cb,0,cc);
		
		// 1-3) c->a
		if(cc+ca>ia)
			solve(ia, cb, cc+ca-ia);
		else
			solve(ca+cc,cb,0);
		
		// 1-4) c->b
		if(cc+cb>ib)
			solve(ca, ib, cc+cb-ib);
		else
			solve(ca,cc+cb,0);
		
		// case 2) a->c, b->c // 넘칠 일이 없다
		
		// 2-1) a->c
		solve(0,cb,ca+cc);
		// 2-2) b->c
		solve(ca,0,cb+cc);
		
	}
}
