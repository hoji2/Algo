import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1094_막대기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int find=sc.nextInt();
		
		// 64 32 16 8 .... -> binaryString
		String s=Integer.toBinaryString(sc.nextInt());
		int res=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='1') {
				res++;
			}
		}
		System.out.println(res);
		
//		PriorityQueue<Integer> tmp=new PriorityQueue<Integer>();
//		tmp.add(64);
//		
//		if(find==64)
//			System.out.println(1);
//		else {
//			while(!tmp.isEmpty()) {
//				int div=tmp.poll()/2;
//				
//				tmp.add(div);
//				int mid=0;
//				for(int i : tmp)
//					mid+=i;
//				
//				if(mid<find)
//					tmp.add(div);
//				
//				mid=0;
//				for(int i : tmp)
//					mid+=i;
//				
//				if(mid==find) {
//					System.out.println(tmp.size());
//					break;
//				}
//			}
//		}
			
	}
}
