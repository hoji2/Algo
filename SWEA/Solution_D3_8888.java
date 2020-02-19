package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_8888 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static long[][]map;
	static int n,t,k;
	
	public static void main(String[] args) throws IOException {
		
		int t=stoi(br.readLine());
		
		for (int tc = 1; tc <=t; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());

			n=stoi(st.nextToken());
			t=stoi(st.nextToken());
			k=stoi(st.nextToken());
			
			// 점수, 맞은개수
			map=new long[n+1][t+3];
			
			// 입력
			for (int i = 1; i <=n; i++) {
				st=new StringTokenizer(br.readLine());
				int idx=0;
				while(st.hasMoreTokens())
					map[i][idx++]=stoi(st.nextToken());
				
			}
			
			// 문제별 점수계산
			for (int i = 0; i < t; i++) {
				map[0][i]=n;
				for (int j = 1; j <= n; j++) {
					if(map[j][i]==1)
						map[0][i]--;
				}
			}
			// 인원 별 점수 계산 + 맞은개수 + idx
			for (int i = 1; i <=n; i++) {
				int point=0;
				int cnt=0;
				for (int j = 0; j < t; j++) {
					if(map[i][j]!=0) {
						cnt++;
						point+=map[0][j]*map[i][j];
					}
				}
				map[i][t]=point;
				map[i][t+1]=cnt;
				map[i][t+2]=i;
			}
			
			solve();
			
			for (int i = 1; i <= n; i++) {
				if(map[i][t+2]==k) {
					System.out.println("#"+tc+" "+map[i][t]+" "+(int)(i+1));
					break;
				}
			}
		}
		
	}
	
	public static void solve() {
		Arrays.sort(map, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[t]==o2[t]) {
					if(o1[t+1]==o2[t+1]) {
						return (int)(o1[t+2]-o2[t+2]);
					}else
						return (int)(o2[t+1]-o1[t+1]);
				}else
					return (int)(o2[t]-o1[t]);
			}
		});
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}


