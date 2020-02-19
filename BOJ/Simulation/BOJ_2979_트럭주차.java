import java.util.Scanner;

public class BOJ_2979_트럭주차 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int[]time=new int[101];
		
		int one=sc.nextInt();
		int two=2*sc.nextInt();
		int thr=3*sc.nextInt();
		
		int res=0;
		
		for (int i = 0; i < 3; i++) {
			int st=sc.nextInt();
			int end=sc.nextInt();
			
			for (int j = st; j <=end-1; j++) {
				time[j]++;
			}
		}
		
		for (int i = 1; i <=100; i++) {
			if(time[i]!=0) {
				if(time[i]==1)
					res+=one;
				else if(time[i]==2)
					res+=two;
				else
					res+=thr;
			}
		}
		System.out.println(res);
		
	}
}
