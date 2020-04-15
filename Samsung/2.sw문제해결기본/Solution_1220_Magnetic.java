import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1220_Magnetic {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int size=100;
	static char[][]map;
	
	public static void main(String[] args) throws IOException {
		
		for (int tc = 1; tc <=10; tc++) {
			br.readLine();
			map=new char[size][size];
			for (int i = 0; i < size; i++) {
				map[i]=br.readLine().trim().replace(" ", "").toCharArray();
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(map[i][j]!='0') {
						solve(i,j);
					}
				}
			}
			int cnt=0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(map[i][j]=='1') {
						int st=i+1;
						int end=size-1;
						while(st<=end) {
							if(map[st][j]=='2') {
								cnt++;
								break;
							}else if(map[st][j]=='1')
								break;
							
							st++;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	public static void solve(int x, int y) {
		char p=map[x][y];
		boolean remove=true;
		if(p=='1') {
			int st=x+1;
			int end=size-1;
			while(st<=end) {
				if(map[st][y]=='2') {
					remove=false;
					break;
				}
				st++;
			}
		}else if(p=='2') {
			int st=x;
			int end=0;
			while(st>=end) {
				if(map[st][y]=='1') {
					remove=false;
					break;
				}
				st--;
			}
		}
		if(remove)
			map[x][y]='0';
		
	}
}
