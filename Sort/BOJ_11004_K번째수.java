import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_K번째수 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int idx=Integer.parseInt(st.nextToken());
		
		long[]arr=new long[n];
		
		st=new StringTokenizer(br.readLine());
		int i=0;
		
		while(st.hasMoreTokens())
			arr[i++]=Long.parseLong(st.nextToken());
		
		quick(arr,0,arr.length-1);
		System.out.println(arr[idx-1]);
	}
	
	public static void quick(long[]arr, int low, int high) {
		
		int i=low;
		int j=high;
		long pivot=arr[(i+j)/2];
		long tmp;
		
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
			quick(arr,low,j);
		if(high>i)
			quick(arr,i,high);
	}
}
