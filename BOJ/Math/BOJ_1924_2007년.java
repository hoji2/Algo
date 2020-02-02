import java.util.Scanner;

public class BOJ_1924_2007년 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		// 1월 1일이 MON이므로 나누어떨어지는 0~6 == MON~SUN
		String []tmp= {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		
		int month=sc.nextInt();
		int day=sc.nextInt();
		
		int cnt=0;
		for (int i = 1; i <=month-1; i++) {
			if(i==2)
				cnt+=28;
			else if(i==4 || i==6 || i==9 || i==11)
				cnt+=30;
			else
				cnt+=31;
		}
		
		cnt+=day-1;
		System.out.println(tmp[cnt%7]);
		
	}
}
