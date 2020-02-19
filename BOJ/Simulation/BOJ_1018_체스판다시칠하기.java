import java.util.Scanner;

public class BOJ_1018_체스판다시칠하기 {

	static Scanner sc=new Scanner(System.in);
	static int row,col,res=Integer.MAX_VALUE;
	static char[][]map;
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		map=new char[row][col];
		
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			map[i]=sc.nextLine().toCharArray();
		}
		
		// 이중for문에서 8x8사이즈를 추출할 수 있는 시작점 i,j만 조사
		// 위 경우에서 2번 돌리기 (i,j)를 W로 시작하는경우 / B로 시작하는 경우
		// 위 두가지 경우의 최소값을 구하고 최종값과 최소비교
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(i+7<row && j+7<col) {
					int w=dfs(i,j,'W');
					int b=dfs(i,j,'B');
					res=Math.min(res, Math.min(w, b));
				}
			}
		}
		System.out.println(res);
	}
	
	public static int dfs(int x, int y, char c) {
		
		int tmp=0;
		for (int i = x; i <= x+7; i++) {
			for (int j = y; j <= y+7; j++) {
				if(c!=map[i][j])
					tmp++;
				c=(c=='W'? 'B':'W');
			}
			//줄바뀜 때 한번 바꾸기 첫째줄 마지막 B-> 처리후 W -> 둘째줄 시작 -> B
			c=(c=='W'? 'B':'W');
		}
		return tmp;
	}
	
	
}
