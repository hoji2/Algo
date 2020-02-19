import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2161_카드1 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		Queue<Integer> tmp=new LinkedList<Integer>();
		int n=sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			tmp.add(i);
		}
		
		while(tmp.size()!=1) {
			System.out.print(tmp.poll()+" ");
			tmp.add(tmp.poll());
		}
		System.out.println(tmp.poll());
	}
}
