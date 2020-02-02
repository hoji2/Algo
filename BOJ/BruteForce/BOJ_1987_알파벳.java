import java.util.Scanner;

public class BOJ_1987_알파벳 {

	static Scanner sc=new Scanner(System.in);
	static boolean[] check=new boolean[100];
	static int n,m,res=0;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static char[][]map;
	
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		m=sc.nextInt();
		sc.nextLine();
		
		map=new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i]=sc.nextLine().toCharArray();
		}
		
		// 최초방문처리 여부 ! 
		check[map[0][0]]=true;
		solve(0,0,1);
		System.out.println(res);
	}
	public static void solve(int x, int y, int cnt) {
		
		// 재탐색
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0 && ny>=0 && nx<n && ny<m && !check[map[nx][ny]]) {
				// 여러번 방문하는 경우의 문제이므로 방문 전후 T/F처리
				// 즉 DFS가 아닌 브루트포스문제
				check[map[nx][ny]]=true;
				solve(nx,ny,cnt+1);
				check[map[nx][ny]]=false;
			}
		}
		
		// 아무대도 갈 대가 없으면 당시 cnt값을 return;
		res=Math.max(res, cnt);
		return;
	}
}
