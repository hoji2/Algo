import java.util.Scanner;

public class BOJ_2751_수정렬하기2 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int[]arr=new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		quick(arr,0,arr.length-1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void quick(int[]arr, int low, int high) {
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
