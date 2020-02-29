import java.util.Scanner;

public class BOJ_1652_누울자리를찾아라 {

	static Scanner sc=new Scanner(System.in);
	static int n;
	static char[][]map;
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		map=new char[n][n];
		int row=0, col=0;
		
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			map[i]=sc.nextLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			row+=solve(i,1);
			col+=solve(i,-1);
		}
		
		System.out.println(row+" "+col);
	}
	
	public static int solve(int num, int dir) {
		
		int tmp=0;
		// row 탐색
		if(dir==1) {
			int cur=0;
			boolean con=false;
			for (int i = 0; i < n; i++) {
				if(map[num][i]=='.') {
					if(con)
						continue;
					else if(cur==1) {
						con=true;
						tmp++;
					}else {
						cur++;
					}
				}else {
					con=false;
					cur=0;
				}
			}
		}
		// col 탐색
		else {
			int cur=0;
			boolean con=false;
			for (int i = 0; i < n; i++) {
				if(map[i][num]=='.') {
					if(con)
						continue;
					else if(cur==1) {
						con=true;
						tmp++;
					}else {
						cur++;
					}
				}else {
					con=false;
					cur=0;
				}
			}
		}
		return tmp;
	}
}
