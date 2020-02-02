import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2583_영역구하기 {

	static Scanner sc=new Scanner(System.in);
	static int row,col,cnt;
	static int[][]map;
	static ArrayList<Integer>res=new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		
		row=sc.nextInt();
		col=sc.nextInt();
		cnt=sc.nextInt();
		
		map=new int[row+1][col+1];
		
		int []arr=new int[4];
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[j]=sc.nextInt();
			}
			for (int j = arr[0]; j <arr[2]; j++) {
				for (int k = arr[1]; k <arr[3]; k++) {
					//map을 거꾸로 그린다.
					map[k][j]=1;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j]==0)
					res.add(dfs(i,j));
			}
		}
		res.sort(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
		});
		
		System.out.println(res.size());
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i)+" ");
		}
	}
	
	public static int dfs(int x, int y) {
		if(x<0 || y <0 || x >= row || y>=col || map[x][y]!=0)
			return 0;
		
		map[x][y]=1;
		return 1+dfs(x+1,y)+dfs(x-1,y)+dfs(x,y+1)+dfs(x,y-1);
	}
}
