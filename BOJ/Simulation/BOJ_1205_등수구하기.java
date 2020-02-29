import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1205_등수구하기 {

	//https://yahohococo.tistory.com/33
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int cur=sc.nextInt();
		int insert=sc.nextInt();
		int n=sc.nextInt();
		
		// cur이 아닌 전체 배열에 들어갈수 있는 idx=1부터 n까지의 n+1배열 선언
		int[]arr=new int[n+1];
		
		// 숫자 0입력 경우도 있으므로 빈 자리를 -1로 fill
		Arrays.fill(arr,-1);
		
		for (int i = 1; i <=cur; i++) {
			arr[i]=sc.nextInt();
		}
		
		int idx=1;
		
		while(idx<=n) {
			// 현재 순회하고 있는 idx의 값이 -1이거나 insert보다 작아지는 경우 들어갈 자리이므로 break
			if(arr[idx]<insert || arr[idx]==-1)
				break;
			
			idx++;
		}
		
		// 예외처리 n=0이면 현재 리스트에 아무것도 없고 insert값이 1순위가 된다
		if(n==0) {
			System.out.println(1);
		}
		// 1~n까지의 배열 중에서 idx가 n+1로 튕기어 들어갈 자리가 없으면 -1 -> 예외) 앞에 값이 같은 숫자가 있어도 자리가 없어서 들어갈 수 없는경우
		else if(idx==n+1) {
			System.out.println(-1);
		}
		// 그렇다면 idx에 현재값을 넣고 앞으로 순회하면서 insert와 같은 값이 있으면 idx를 감소
		else {
			arr[idx]=insert;
			while(idx>0) {
				if(arr[idx]==insert) {
					idx--;
				}else if(arr[idx]>insert)
					break;
				
			}
			// 그러면 insert보다 큰 값까지의 순위가 나오므로 최종적인 insert의 순위는 idx+1
			System.out.println(idx+1);
		}
	}
}
