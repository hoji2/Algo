import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_1215_회문1 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char[][]map;
	static int len, cnt;
	static HashSet<String>hs;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			
			len=Integer.parseInt(br.readLine())-1;
			map=new char[8][8];
			cnt=0;
			hs=new HashSet<String>();
			for (int i = 0; i < 8; i++) {
				map[i]=br.readLine().toCharArray();
			}
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					//상
					solve(i-len,j,i,j);
					//좌
					solve(i,j-len,i,j);
					//우
					solve(i,j,i+len,j);
					//하
					solve(i,j,i,j+len);
				}
			}
			//중복 카운트 제거(좌->우 , 우->좌 등 같은경우)
			System.out.println("#"+tc+" "+cnt/2);
			
		}
	}
	
	public static void solve(int sx, int sy, int nx, int ny) {
		
		if(!(sx>=0 && sy>=0 && nx<8 && ny<8))
			return;
		
		StringBuilder sb1=new StringBuilder();
		
		for (int i = sx; i <=nx; i++) {
			for (int j = sy; j <= ny; j++) {
				sb1.append(map[i][j]);
			}
		}
		
		if(sb1.toString().equals(sb1.reverse().toString())) {
			cnt++;
		}
	}
	
}
