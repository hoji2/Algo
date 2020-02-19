import java.util.Scanner;

public class BOJ_14890_경사로_시뮬_삼성기출 {

	static Scanner sc=new Scanner(System.in);
	static int n,len, res=0;
	static int[][]map;
	
	public static void main(String[] args) {
		n=sc.nextInt();
		len=sc.nextInt();
		map=new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			solve(map[i]);
		}
		
		for (int i = 0; i < n; i++) {
			int[]tmp=new int[n];
			int idx=0;
			for (int j = 0; j < n; j++) {
				tmp[idx++]=map[j][i];
			}
			solve(tmp);
		}
		
		System.out.println(res);
	}
	
	public static void solve(int[]info) {
		
		int cur=info[0];
		int idx=1;
		// 한 좌표내에 중복으로 다리가 놓이면 안된다.
		// 이를 판별할 boolean배열
		boolean[]used=new boolean[n];
		
		while(idx<info.length) {
			// 높이가 같으면 일단 진행
			if(info[idx]==cur)
				idx++;
			// 차이가 1이아니면 다리를 놓을수 없음 -> return
			else if(Math.abs(info[idx]-cur)!=1)
				return;
			// 차이가 1인데 오르막인 경우
			else if(info[idx]>cur) {
				// 언덕의 밑둥이 되는 cur좌표
				cur=info[idx-1];
				// 현재 cur를 기준으로 len길이만큼 연속되어있는지 여부 확인 
				for (int k = idx-len; k < idx; k++) {
					// len만큼 연속되어있지 않으면 다리를 놓을수 없음 -> return
					if(k<0 || info[k]!=cur)
						return;
					// 이미 사용한적이 있는 다리이면 놓을수 없음 -> return
					if(used[k])
						return;
					
					//사용한 다리
					used[k]=true;
				}
				// 다리를 놓을 수 잇으면 계속 진행 + cur값은 높아진 info[idx]로 갱신
				cur=info[idx++];
			}
			// 차이가 1인데 내리막 인경우
			else {
				// 언덕의 밑둥이 되는 cur좌표
				cur=info[idx];
				// 현재 cur를 기준으로 len길이만큼 연속되어있는지 여부 확인
				for (int k = idx; k < idx+len; k++) {
					// len만큼 연속되어있지 않으면 다리를 놓을수 없음 -> return
					if(k>=n || info[k]!=cur)
						return;
					// 이미 사용한적이 있는 다리이면 놓을수 없음 -> return
					if(used[k])
						return;
					used[k]=true;
				}
				idx+=len;
			}
		}
		
		// 위 단계를 모두 겨처 다리를 놓을 수 있으면 카운트
		res++;
	}
}
