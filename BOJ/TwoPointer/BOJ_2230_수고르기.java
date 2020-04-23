import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2230_수고르기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int size=sc.nextInt();
		int find=sc.nextInt();
		
		int[]map=new int[size];
		for (int i = 0; i < size; i++) {
			map[i]=sc.nextInt();
		}
		
		int len=Integer.MAX_VALUE;
		int cur=0, left=0,right=0;
		
		Arrays.sort(map);
		
		if(find==0)
			System.out.println(0);
		else {
			while(true) {
				
				cur=map[right]-map[left];
				
				if(cur>=find) {
					left++;
				}else if(right==size-1)
					break;
				else
					right++;
				
				if(cur>=find)
					len=Math.min(len, cur);
			}
			
			System.out.println(len);
		}
	}
}
