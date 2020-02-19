import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1021_회전하는큐 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int k=sc.nextInt();
		int time=0;
		
		LinkedList<Integer> tmp=new LinkedList<Integer>();
		Queue<Integer> candi=new LinkedList<Integer>();
		
		for (int i = 0; i < k; i++) {
			candi.add(sc.nextInt());
		}
		
		for (int i = 1; i <=n; i++) {
			tmp.add(i);
		}
		
		int idx=0;
		
		while(!candi.isEmpty()) {
			int p=candi.poll();

			if(tmp.peek()==p)
				tmp.poll();
			else {
				int left=0;
				int right=0;
				
				for(int i : tmp) {
					if(i==p)
						break;
					right++;
				}
				// 왼쪽 오른쪽 방향 정의
				// 둘 중 가까운 방향으로 행동
				left=tmp.size()-right;
				if(left>right) {
					time+=right;
					while(right!=0) {
						tmp.add(tmp.poll());
						right--;
					}
				}else {
					time+=left;
					while(left!=0) {
						int q=tmp.getLast();
						tmp.removeLast();
						tmp.addFirst(q);
						left--;
					}
				}
				tmp.poll();
			}
		}
		System.out.println(time);
	}
}
