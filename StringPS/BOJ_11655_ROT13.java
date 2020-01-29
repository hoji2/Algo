import java.util.Scanner;

public class BOJ_11655_ROT13 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		char[]arr=sc.nextLine().toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if(65<=arr[i] && arr[i]<=90) {
				if(arr[i]>=78)
					arr[i]-=13;
				else
					arr[i]+=13;
			}else if(97<=arr[i] && arr[i]<=122){
				if(arr[i]>=110)
					arr[i]-=13;
				else
					arr[i]+=13;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
	}
}
