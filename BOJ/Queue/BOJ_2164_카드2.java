import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_카드2 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int res=0;
		
		Queue<Integer> tmp=new LinkedList<Integer>();
		
		for (int i = 1; i <=n; i++) {
			tmp.add(i);
		}
		
		if(n==1)
			System.out.println(1);
		else {
			while(!tmp.isEmpty()) {
				int p=tmp.poll();
				if(tmp.size()==1) {
					res=tmp.poll();
					break;		
				}
				tmp.add(tmp.poll());
			}
			System.out.println(res);
		}
	}
}
