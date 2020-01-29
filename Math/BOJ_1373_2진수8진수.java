import java.util.Scanner;

public class BOJ_1373_2진수8진수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		StringBuffer sb=new StringBuffer();
		sb.append(sc.nextLine());
		int p=sb.length()%3;
		
		// 자리수 조심 100 -> 000100 으로 되므로 자리수가 떨어지는 p=0인 경우는 제외
		if(p!=0)
			for (int i = 0; i < 3-p; i++) {
				sb.insert(0, '0');
			}
		
		for (int i = 0; i < sb.length()/3; i++) {
			int a=Integer.parseInt(sb.substring(i*3, (i+1)*3), 2);
			System.out.print(a);
		}
	}
}
