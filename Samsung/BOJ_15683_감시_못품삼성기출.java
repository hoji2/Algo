import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15683_감시_못품삼성기출 {

	static Scanner sc=new Scanner(System.in);
	static int row,col;
	static int[][]map;
	static ArrayList<cctv> watch=new ArrayList<cctv>();
	
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		
		map=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int tmp=sc.nextInt();
				if(tmp!=0 && tmp!=6)
					watch.add(new cctv(i, j, tmp));
			}
		}
		
	}
}

class cctv{
	int x,y,num;
	public cctv(int x, int y, int num) {
		this.x=x;
		this.y=y;
		this.num=num;
	}
}