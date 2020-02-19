import java.util.Scanner;

public class BOJ_5532_방학숙제 {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		int day=sc.nextInt();
		int tot_k=sc.nextInt();
		int tot_m=sc.nextInt();
		int per_k=sc.nextInt();
		int per_m=sc.nextInt();
		
		int mid_k=0,mid_m=0;
		mid_m=tot_m/per_m;
		mid_k=tot_k/per_k;
		
		if(tot_m%per_m!=0)
			mid_m++;
		if(tot_k%per_k!=0)
			mid_k++;
		
		System.out.println(day-Math.max(mid_m, mid_k));
		
		
	}
}
