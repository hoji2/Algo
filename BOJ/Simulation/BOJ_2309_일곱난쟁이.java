import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int[]arr=new int[9];
		int[]ex=new int[2];

		int sum=0;
		
		for (int i = 0; i < 9; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		
		boolean finish=false;
		for (int i = 0; i <8 ; i++) {
			if(finish) break;
			for (int j = 1; j < 9; j++) {
				int tmp=sum;
				tmp=tmp-(arr[i]+arr[j]);
				if(tmp==100) {
					ex[0]=arr[i];
					ex[1]=arr[j];
					finish=true;
					break;
				}
			}
		}
		Arrays.sort(arr);
		for(int i : arr) {
			boolean print=true;
			for(int k : ex) {
				if(i==k) {
					print=false;
					break;
				}
			}
			if(print)
				System.out.println(i);
		}
	}
}
