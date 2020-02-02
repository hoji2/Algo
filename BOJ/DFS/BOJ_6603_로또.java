import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또{
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n,m=6;
	static int[]arr,pick;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			sb=new StringBuilder();
			if(n==0) {
				break;
			}
			
			arr=new int[n];
			pick=new int[m];
			
			int idx=0;
			while(st.hasMoreTokens()) {
				arr[idx++]=Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println(sb);
		}
	}
	
	public static void dfs(int st, int many) {
		// 조합인 경우 visit배열 사용X
		// 2 1 3 4 5 6 과 같이 앞 숫자보다 작을 떄 탐색(방문)하지 않는 경우 visit배열 사용할 필요 X 
		
		//6개가 다채워지면 sb에 쌓기
		if(many==m) {
			for (int i = 0; i < m; i++) {
				sb.append(pick[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = st; i < arr.length; i++) {
			pick[many]=arr[i];
			dfs(i+1,many+1);
		}
	}
}