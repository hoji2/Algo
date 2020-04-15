import java.util.ArrayList;
import java.util.Scanner;

//https://kim6394.tistory.com/197
public class Solution_1767_프로세서연결하기 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map;
	static int size, min,max;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static ArrayList<point>tmp;
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int t = 1; t <=tc; t++) {
			size=sc.nextInt();
			map=new int[size][size];
			tmp=new ArrayList<point>();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int a=sc.nextInt();
					// 벽과 붙어있는 프로세서가 아닌 경우만 add
					if(a==1 && i!=0 && j!=0 && i!=size-1 && j!=size-1)
						tmp.add(new point(i, j));
					map[i][j]=a;
				}
			}
			//길이
			min=Integer.MAX_VALUE;
			// 프로세서 개수
			max=Integer.MIN_VALUE;
			solve(0,0,0);
			System.out.println("#"+t+" "+min);
		}
	}
	
	// idx 현재탐색중인 프로세서, cnt 현재까지 유효한 프로세서, len 현재까지 연결된 len의 길이
	public static void solve(int idx, int cnt, int len) {
		
		// 더이상 탐색할 프로세서가 없는경우 
		if(idx==tmp.size()) {
			// max보다 현재 cnt 프로세서 개수가 많은경우
			if(max<cnt) {
				max=cnt;
				min=len;
			}
			// 프로세서개수가 같은경우
			else if(max==cnt) {
				// 최소길이로 갱신
				if(min>len)
					min=len;
			}
			
			return;
		}
		// 현재 idx기준 4방향으로 탐색
		for (int i = 0; i < dir.length; i++) {
			// 4방향 별로 전선의 길이
			int step_cnt=0;
			int ori_x=tmp.get(idx).x;
			int ori_y=tmp.get(idx).y;
			// 초기 ori값부터 각 방향별로 증가시킬 변수
			int move_x=ori_x;
			int move_y=ori_y;
			
			while(true) {
				move_x+=dir[i][0];
				move_y+=dir[i][1];
				// 범위 벗어나면 이떄까지 계산한 step_cnt를 가지고 break
				if(move_x < 0 || move_y < 0 || move_x>=size || move_y>=size)
					break;
				// 이미 전선이 깔려있는 경우 -> 이 케이스에서는 전선을 깔 수 없다 -> step_cnt=0
				if(map[move_x][move_y]==1) {
					step_cnt=0;
					break;
				}
				step_cnt++;
			}
			// 전선을 깔 수 없으면 다음 idx로만 넘어감, 그외 파라미터는 상등
			if(step_cnt==0) {
				solve(idx+1,cnt,len);
			}else {
				//전선 연결
				int draw_x=ori_x;
				int draw_y=ori_y;
				
				for (int j = 0; j < step_cnt; j++) {
					draw_x+=dir[i][0];
					draw_y+=dir[i][1];
					map[draw_x][draw_y]=1;
				}
				// 유효한 프로세서 cnt증가, 전선을 깐 길이 step_cnt만큼 증가하여 다음 탐색
				solve(idx+1,cnt+1,len+step_cnt);
				
				//탐색 후 이전상태로 전선 원복
				draw_x=ori_x;
				draw_y=ori_y;
				
				for (int j = 0; j < step_cnt; j++) {
					draw_x+=dir[i][0];
					draw_y+=dir[i][1];
					map[draw_x][draw_y]=0;
				}
			}
		}
	}
}

class point{
	int x,y;
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}