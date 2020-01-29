import java.util.Scanner;

public class BOJ_2745_진법변환 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		char[]arr=sc.next().toCharArray();
		int div=sc.nextInt();
		
		long res=0;
		
		//char형 Int로 변환
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]-'0'>=10)
				arr[i]=(char) (arr[i]-55);
			else
				arr[i]-='0';
			
			res+=Math.pow(div,arr.length-i-1)*(arr[i]);
		}
		System.out.println(res);
		
	}
}
