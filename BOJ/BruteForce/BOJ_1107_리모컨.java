import java.util.Scanner;
//https://appree.tistory.com/7
public class BOJ_1107_리모컨 {

	static Scanner sc=new Scanner(System.in);
	static int find, res=0;
	static boolean[]broken=new boolean[10];
	
	public static void main(String[] args) {
		
		find=sc.nextInt();
		int k=sc.nextInt();
		
		for (int i = 0; i < k; i++) {
			broken[sc.nextInt()]=true;
		}
		
		// Case 1 :  +,-로만 움직일 수 있는 최악의 경우의수 구하기(현재 채널 100기준)
		res=Math.abs(find-100);
		
		// Case 2 : 가능한 모든 채널로 이동한 후 최대한 가까운 위치로 넘어가는 과정
		// (중요) 채널은 무한대다...
		// 0<=find<=500000 에서 예를들어 500000 까지 가는 경우 중 500001로 이동 후 -로 가능 경우도 생각할 수 있음 
		// 따라서 리모컨으로 움직일 수 있는 채널의 limit은 1000000 까지 범위가 유효한 범위이다(그 이상은 무의미한 범위)
		
		for (int i = 0; i <=1000000; i++) {
			
			// i번째까지 only 리모컨 버튼으로 갈 수 있는지 확인
			int cnt=move(i);
			// only리모컨 버튼으로 갈 수 없는 경우 다른 i를 찾아보자(for문으로 돌아감)
			if(cnt!=-1) {
				// 해당번호 까지 리모컨으로 이동한 횟수=현재 순회하고 있는 i의 길이 -> 변수 cnt
				int tmp=Math.abs(find-i);
				res=Math.min(res, cnt+tmp);
			}
		}
		
		System.out.println(res);
	}
	
	public static int move(int target) {
		int len=0;
		// 0번 채널은 mod연산으로 확인할 수 X
		if(target==0)
			return broken[0] ? -1: 1;
		
		// 맨 뒤에숫자(target%10)부터 하나씩 확인
		// mod 연산으로는 0보다 큰 채널까지만 확인할 수 있다.
		while(target>0) {
			//고장나면 움직일 수 X
			if(broken[target%10])
				return -1;
			
			len++;
			target/=10;
		}
		return len;
	}
}
