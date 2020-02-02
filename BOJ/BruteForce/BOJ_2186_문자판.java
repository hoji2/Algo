import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2186_문자판{

	//https://yabmoons.tistory.com/194
	//http://blog.naver.com/PostView.nhn?blogId=suntouch&logNo=221665458975
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n,m,k,res;
	static char[][]map;
	static int[][][]dp;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static String find;
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=stoi(st.nextToken());
		m=stoi(st.nextToken());	
		k=stoi(st.nextToken());
		
		map=new char[n][m];
		
		for (int i = 0; i < n; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		find=br.readLine();
		
		// dp[a][b][c]=d -> (a,b)에 존재하는 알파벳을 c번째 인덱스로 설정했을 때 나올수 있는 정답의 개수 d
		// 경우의수가 0인 경우가 존재하므로 -1로 초기화
		// z행의 0번 idx 사용 x
		dp=new int[n][m][find.length()+1];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		// map에서 출발점을 찾아 dfs 돌기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==find.charAt(0))
					res+=solve(i,j,1);
			}
		}
		
		System.out.println(res);
	}
	
	public static int solve(int x, int y, int len) {
		if(dp[x][y][len]!=-1)
			return dp[x][y][len];
		
		// 전체 문자열을 가지고 탐색하는 경우가 아니여서 다음과 같은 조건이 필요
		// 1) find의 length()보다 길이가 길어진 조합인 경우 -> 의미없는 유일한 케이스 1 ex) abddea 1, abddeae 1 , abddeaea 1
		// 2) find의 length()와 같은 경우 -> 혹시나 우리가 찾는 find와 일치할 수 있으므로 1 
		if(len>=find.length()) {
			return 1;
		}
		
		//기존 -1을 유의미하게 0 으로 시작
		dp[x][y][len]=0;
		
		for (int i = 0; i < dir.length; i++) {
			for (int j = 1; j <=k; j++) {
				int nx=x+dir[i][0]*j;
				int ny=y+dir[i][1]*j;
				
				if(nx>=0 && ny>=0 && nx<n && ny<m)
					// 시작점 (x,y)부터 len을(0~길이) 증가시키며 각각 len 별로 find.charAt(len)이 맞는 경우의 1의 개수를 최종적으로 구함
					if(map[nx][ny]==find.charAt(len))
						dp[x][y][len]+=solve(nx,ny,len+1);
			}
		}
		return dp[x][y][len];
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
