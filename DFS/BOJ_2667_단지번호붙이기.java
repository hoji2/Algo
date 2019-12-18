import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ_2667_단지번호붙이기{

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N,tmp;
	static char[][]map;
	static ArrayList<Integer> mid=new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='1') {
					mid.add(dfs(i,j));
				} 
			}
		}
		
		mid.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		System.out.println(mid.size());
		for (int i = 0; i < mid.size(); i++) {
			System.out.println(mid.get(i));
		}
	}
	
	public static int dfs(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N || map[x][y]=='0')
			return 0;
		
		// 방문한 정점을 visit배열 대신 map배열을 사용
		map[x][y]='0';
		return 1+dfs(x+1,y)+dfs(x-1,y)+dfs(x,y+1)+dfs(x,y-1);
	}
}
