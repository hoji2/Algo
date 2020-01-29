import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BOJ_1158_요세푸스문제 {

	// 시간복잡도 : O(n^2) N=5000, n^2은 2500만
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		LinkedList<Integer> tmp=new LinkedList<Integer>();
		ListIterator<Integer> it=tmp.listIterator();
		
		for (int i = 1; i <= n; i++) {
			it.add(i);
		}
		
		
		StringBuffer sb=new StringBuffer();
		sb.append("<");
		
		while(!tmp.isEmpty()) {
			for (int i = 0; i <k; i++) {
				if(it.hasNext())
					it.next();
				else
					// 0이 아닌 1로 초기화 !! (해당 idx의 뒤커서 기준!!)
					it=tmp.listIterator(1);
			}
			
			sb.append(it.previous()+", ");
			it.remove();
		}
		sb.replace(sb.length()-2, sb.length()-1, ">");
		System.out.println(sb);
	}
}
