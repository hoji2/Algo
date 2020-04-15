import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_1258_행렬찾기 {

	static Scanner sc=new Scanner(System.in);
	static int size;
	static int[][]map;
	static boolean[][]visit;
	static ArrayList<point> tmp;
	public static void main(String[] args) {
	
		int t=sc.nextInt();
		Comparator<point> comp=new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				
				if(o1.row*o1.col==o2.row*o2.col)
					return o1.row-o2.row;
				
				return o1.row*o1.col-o2.row*o2.col;
			}
		};
		
		for (int tc = 1; tc <=t; tc++) {
			size=sc.nextInt();
			map=new int[size][size];
			visit=new boolean[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			tmp=new ArrayList<point>();
			
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(map[i][j]!=0 && !visit[i][j])
						solve(i,j);
				}
			}
			
			tmp.sort(comp);
			System.out.print("#"+tc+" "+tmp.size()+" ");
			for(point p : tmp)
				System.out.print(p.row+" "+p.col+" ");
			
			System.out.println();
		}
	}
	
	public static void solve(int x, int y) {
		int row_idx=0;
		int col_idx=0;
		
		while(true) {
			if(x+row_idx<size && map[x+row_idx][y]!=0)
				row_idx++;
			else
				break;
		}
		
		while(true) {
			if(y+col_idx<size && map[x][y+col_idx]!=0)
				col_idx++;
			else
				break;
		}
		
		if(isValid(x,y,row_idx,col_idx)) {
			tmp.add(new point(row_idx, col_idx));
		}
	}
	
	public static boolean isValid(int x, int y, int row_idx, int col_idx) {
	
		for (int i = x; i <x+row_idx; i++) {
			for (int j = y; j <y+col_idx; j++) {
				if(map[i][j]==0)
					return false;
			}
		}
		
		// 완료처리
		for (int i = x; i <x+row_idx; i++) {
			for (int j = y; j <y+col_idx; j++) {
				visit[i][j]=true;
			}
		}
		
		return true;
	}
}

class point{
	int row, col;
	public point(int row, int col) {
		this.row=row;
		this.col=col;
	}
}