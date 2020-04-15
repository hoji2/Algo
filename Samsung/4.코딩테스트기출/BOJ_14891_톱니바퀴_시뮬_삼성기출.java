import java.util.Scanner;

public class BOJ_14891_톱니바퀴_시뮬_삼성기출 {

	static Scanner sc=new Scanner(System.in);
	static char[][]cycle=new char[4][8];
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			cycle[i]=sc.nextLine().toCharArray();
		}
		
		int com=sc.nextInt();
		for (int i = 0; i < com; i++) {
			int a=sc.nextInt()-1;
			int b=sc.nextInt();
			solve(a,b,-1);
		}
		
		int res=0;
		int add=1;
		for (int i = 0; i < 4; i++) {
			if(cycle[i][0]=='1')
				res+=add;
			
			add*=2;
		}
		
		System.out.println(res);
		
	}
	
	// -1 : 둘다 탐색 , 0 : 왼쪽만 탐색, 1: 오른쪽만 탐색
	public static void solve(int num, int w, int method) {
		
		int left=num-1;
		int right=num+1;
		
		// 왼쪽탐색
		if(method>=-1 && method!=1) {
			if(left>=0) {
				if(cycle[left][2]!=cycle[num][6]) {
					// (중요!!) 바퀴를 돌린 후 다음바퀴를 탐색하면 오답
					// move(left,w*-1) -> 틀림
					solve(left,w*-1,0);
				}
			}
		}

		// 오른쪽탐색
		if(method<=1 && method!=0) {
			if(right<=3) {
				if(cycle[num][2]!=cycle[right][6]) {
					// (중요!!) 바퀴를 돌린 후 다음바퀴를 탐색하면 오답
					// move(left,w*-1) -> 틀림
					solve(right,w*-1,1);
				}
			}
		}
		
		// (중요!!!)
		// 재귀를 돌리면서 회전할 바퀴를 찾아놓고
		// 마지막에 한번에 돌린다
		move(num, w);
	}
	
	public static void move(int num, int w) {
		// 시계방향 (왼(i)-> 오)
		if(w==1) {
			char last=cycle[num][7];
			for (int i = 6; i >=0; i--) {
				cycle[num][i+1]=cycle[num][i];
			}
			cycle[num][0]=last;
		}
		// 반시계방향(오(i+1) -> 왼)
		else {
			char last=cycle[num][0];
			for (int i = 0; i <=6; i++) {
				cycle[num][i]=cycle[num][i+1];
			}
			cycle[num][7]=last;
		}
	}
}
