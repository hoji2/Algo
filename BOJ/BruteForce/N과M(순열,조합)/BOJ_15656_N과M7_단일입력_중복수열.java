import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 시간초과 이슈 파악하는 방법?
// 출력초과
public class BOJ_15656_N과M7_중복수열{

	static Scanner sc=new Scanner(System.in);
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,m;
	static int[]arr,res;
	
	public static void main(String[] args) throws IOException {
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n];
		res=new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		quick(0,arr.length-1);
		solve(0);
		
	}
	
	public static void solve(int cnt) throws IOException {
		if(cnt==m) {
			StringBuilder sb=new StringBuilder();
			// sb.append 덧셈연산 X
			for (int i = 0; i < cnt; i++) {
				sb.append(res[i]);
				sb.append(" ");
			}
			sb.append("\n");
			System.out.print(sb);
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			res[cnt++]=arr[i];
			solve(cnt);
			res[--cnt]=0;
		}
	}
	
	public static void quick(int low, int high) {
		int i=low;
		int j=high;
		int pivot=arr[(i+j)/2];
		int tmp;
		
		while(i<=j) {
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			
			if(i<=j) {
				tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				i++;
				j--;
			}
		}
		
		if(low<j)
			quick(low,j);
		if(high>i)
			quick(i,high);
			
	}
}
