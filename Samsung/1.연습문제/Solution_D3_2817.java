import java.util.Scanner;

public class Solution_2817_부분수열의합 {

	static Scanner sc=new Scanner(System.in);
	static int find;
	static int[]arr,sel;
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n=sc.nextInt();
			find=sc.nextInt();
			arr=new int[n];
			sel=new int[n];
			int res=0;
			
			for (int i = 0; i < n; i++) {
				arr[i]=sc.nextInt();
			}
			
			for (int i = 1; i < (1<<n); i++) {
				int cnt=0;
				for (int j = 0; j < n; j++) {
					if((i & (1<<j))==(1<<j)) {
						sel[cnt++]=arr[j];
					}
				}
				if(solve(cnt))
					res++;
			}
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static boolean solve(int cnt) {
		int tmp=0;
		
		for (int i = 0; i < cnt; i++) {
			tmp+=sel[i];
		}
		
		if(tmp==find)
			return true;
		
		return false;
	}
}
