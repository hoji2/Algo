import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_암호생성기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		for (int i = 1; i <=10; i++) {
			
			sc.nextInt();
			Queue<Integer> tmp=new LinkedList<Integer>();
			for (int j = 0; j < 8; j++) {
				tmp.add(sc.nextInt());
			}
			
			int minus=0;
			while(true) {
				int cur=tmp.poll();
				int add=cur-(minus%5+1);
				if(add<=0) {
					tmp.add(0);
					break;
				}
				tmp.add(add);
				minus++;
			}
			
			System.out.print("#"+i+" ");
			while(!tmp.isEmpty())
				System.out.print(tmp.poll()+" ");
			System.out.println();
		}
	}
}
