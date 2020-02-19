import java.util.Arrays;
import java.util.Scanner;

public class BOJ_7568_덩치 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		
		int[][]arr=new int[n][2];
		
		for (int i = 0; i < n; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		int[]res=new int[n];
		Arrays.fill(res, 1);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==j) continue;
				if(arr[j][0]>arr[i][0] && arr[j][1]>arr[i][1])
					res[i]++;
			}
		}
		
		for(int i : res)
			System.out.print(i+" ");
		
	}
}
