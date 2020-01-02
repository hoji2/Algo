import java.util.Scanner;

public class BOJ_2163_초콜릿자르기 {
	
	static Scanner sc=new Scanner(System.in);
	static int[][]map=new int[301][301];
	
	public static void main(String[] args) {
		
		
		for (int i = 1; i <=300; i++) {
			int idx=-1;
			for (int j = 1; j <=300; j++) {
				idx+=i;
				map[i][j]=idx;
			}
		}
		
		System.out.println(map[sc.nextInt()][sc.nextInt()]);
	}

}
