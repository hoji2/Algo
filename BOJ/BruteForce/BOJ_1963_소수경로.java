import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static boolean []prime=new boolean[10000];
	
	public static void main(String[] args) throws IOException {

		init();
		int tc=stoi(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			System.out.println(solve(stoi(st.nextToken()), stoi(st.nextToken())));
		}
	}
	
	public static int solve(int st, int end) {
		// 불가능경우 : end가 소수가 아닌경우, st==end 인경우 순회할 필요가 없다
		if(prime[end] || st==end)
			return 0;
		
		int res=0;
		
		Queue<Integer> tmp=new LinkedList<Integer>();
		tmp.add(st);
		
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			res++;
			
			for (int i = 0; i < loop; i++) {
				int q=tmp.poll();
				
				for (int j = 0; j < 4; j++) {
					int win=(int)Math.pow(10, 3-j);
					//(q/win)%10 mod 10 연산 매우 중요
					// 각 자리수를 뽑아내기 위해서
					// ex) 백의자리 추출 중 (q/win)을하면 그 앞에 천의자리가 영향을 주어 13, 15와 같이 나올 수 있다.
					// 우리는 한자리(0~9) 백의자리 3이나 5를 추출하기 위해 mod 10 연산을 진행한다.
					int before=q-((q/win)%10)*win;
					
					for (int u = 0; u <=9; u++) {
						if(j==0 && u==0)
							continue;
						
						int fin=before+u*win;
					
						if(!prime[fin] && q!=fin) {
							if(fin==end)
								return res;
							
							tmp.add(fin);
						}
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void init() {
		
		// false : 소수
		for (int i = 2; i <10000; i++) {
			if(!prime[i]) {
				for (int j = i+i; j <10000; j+=i) {
					prime[j]=true;
				}
			}
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
