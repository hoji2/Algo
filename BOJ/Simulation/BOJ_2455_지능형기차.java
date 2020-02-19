import java.util.Scanner;

public class BOJ_2455_지능형기차 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		int res=0;
		int mid=0;
		int cnt=4;
		while(cnt!=0) {
			mid+=-sc.nextInt()+sc.nextInt();
			res=Math.max(res, mid);
			cnt--;
		}
		
		System.out.println(res);
	}
}
