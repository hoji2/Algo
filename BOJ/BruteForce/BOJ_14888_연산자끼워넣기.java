import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	
	static int[] oper_cnt = new int[4];
	static int[] num_list;
	static int[] oper_list;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num_list = new int[N];
		oper_list =  new int[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num_list[i] =Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper_cnt[i] =Integer.parseInt(st.nextToken());
		}
		//end input.
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}//end main.
	
	public static void dfs(int cnt) {
		if(cnt == N-1) {
			int temp = calculate();
			if(temp < min) min = temp;
			if(temp > max) max = temp;
			return ;
		}
		
		for(int i=0; i<4; i++) {
			// oper_cnt : 원본
			// oper_list : 넣다뺐다배열
			if(oper_cnt[i] != 0) {
				// 예를들어 덧셈하나 뺸 후
				oper_cnt[i]--;
				oper_list[cnt] = i;
				dfs(cnt+1);
				// 수행 후 덧셈하나 다시 넣어놓기
				oper_cnt[i]++;
				oper_list[cnt] = 0;
			}
		}
		
	}//end dfs.
	public static int calculate() {
		int sum = num_list[0];
		// oper_list에는
		// [0, 0, 1, 2, 2, 3] 과 같이 해당 연산에 +,-,*,/ 좌표가 들어감
		for(int i=0; i<N-1; i++) {
			switch(oper_list[i]) {
			case 0: sum += num_list[i+1];break;//덧셈의 경우.
			case 1: sum -= num_list[i+1];break;//뺄셈의 경우.
			case 2: sum *= num_list[i+1];break;//곱셈의 경우.
			case 3: sum /= num_list[i+1]; break;//나눗셈의 경우.
			}//end switch.
		}//end for.
		return sum;
	}//end calculate.
}//end class.