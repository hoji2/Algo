import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회dfs {
	
	//https://deliorange.tistory.com/85

	static Scanner sc=new Scanner(System.in);
	static int n;
	// 한 행마다 입력으러 들어오는 첫번쨰 루트정보를 들어온 순서대로 저장해놓을 dp배열
	static char[]dp;
	static char[][]map;
	static boolean[]visit;
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		sc.nextLine();
		map=new char[n][3];
		dp=new char[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(sc.nextLine());
			int idx=0;
			while(st.hasMoreTokens()) {
				char p=st.nextToken().charAt(0);
				if(idx==0)
					dp[i]=p;
					
				map[i][idx++]=p;
			}
		}
		
		dfs(0,0);
		System.out.println();
		dfs(0,1);
		System.out.println();
		dfs(0,2);
	}
	
	public static void dfs(int root, int type) {

		if(type==0) {
			System.out.print(dp[root]);
			if(map[root][1]!='.') dfs(find(map[root][1]),0);
			if(map[root][2]!='.') dfs(find(map[root][2]),0);
		}else if(type==1) {
			if(map[root][1]!='.') dfs(find(map[root][1]),1);
			System.out.print(dp[root]);
			if(map[root][2]!='.') dfs(find(map[root][2]),1);
		}else {
			if(map[root][1]!='.') dfs(find(map[root][1]),2);
			if(map[root][2]!='.') dfs(find(map[root][2]),2);
			System.out.print(dp[root]);
		}
	}
	
	public static int find(char root) {
		for (int i = 0; i < dp.length; i++) {
			if(dp[i]==root)
				return i;
		}
		return 0;
	}
}
