package groom;

import java.util.Scanner;

public class 전등프로그래밍_tc하나x {

	static Scanner sc=new Scanner(System.in);
	static int row, col;
	static int[][]map;
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		map=new int[row+1][col+1];
		
		for (int i = 1; i <=row; i++)
			for (int j = 1; j <=col; j++)
				map[i][j]=sc.nextInt();
		
		int tc=sc.nextInt();
		for (int i = 0; i < tc; i++)
			solve(sc.nextInt(), sc.nextInt());
		
		for (int i = 1; i <=row; i++) {
			for (int j = 1; j <=col; j++)
				System.out.print(map[i][j]+" ");
			
			System.out.println();
		}
		
	}
	
	public static void solve(int dir, int idx) {
		// 가로
		if(dir==0)
			for (int i = 1; i <= col; i++)
				map[idx][i]=1-map[idx][i];
		// 세로
		else 
			for (int i = 1; i <= row; i++)
				map[i][idx]=1-map[i][idx];
	}
}
