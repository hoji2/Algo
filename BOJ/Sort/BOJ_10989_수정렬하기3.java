import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10989_수정렬하기3 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int n=Integer.parseInt(br.readLine());
		int[]arr=new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		quick(arr,0,arr.length-1);
		
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void quick(int[]arr,int low, int high) {
		
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
			quick(arr,low,j);
		if(high>i)
			quick(arr,i,high);
			
			
	}
}
