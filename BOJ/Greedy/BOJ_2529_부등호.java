import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {

	//https://jaimemin.tistory.com/758
	static Scanner sc=new Scanner(System.in);
	static int n;
	static char[]info;
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		sc.nextLine();
		StringTokenizer st=new StringTokenizer(sc.nextLine());
		info=new char[n];
		int idx=0;
		while(st.hasMoreTokens())
			info[idx++]=st.nextToken().charAt(0);
		
		int[]max=new int[n+1];
		int[]min=new int[n+1];
		

		// n=2인 경우 max는 9 8 7 중 조합 , min은 0,1,2 조합
		int tmp=9;
		for (int i = 0; i <= n; i++) {
			max[i]=tmp;
			min[i]=9-tmp;
			tmp--;
		}
		
		solve(max);
		solve(min);
		
		for(int i : max)
			System.out.print(i);
		System.out.println();
		
		for(int i : min)
			System.out.print(i);
		System.out.println();
	}
	
	public static void solve(int[] arr) {
		
		for (int i = 0; i < info.length; i++) {
			char p=info[i];
			if(p=='<') {
				// 등호를 성립하지 않는 경우
				if(arr[i]>arr[i+1]) {
					// 위의 첫 등호에 다음값을 시작으로 p가 연속될때까지 swap할 idx를 찾아준다
					// 초기 swap대상은 현재 i의 바로 다음값인 i+1
					int tmp=arr[i+1];
					int find_idx=i+1;
					for (int j = find_idx; j < info.length; j++) {
						// 기호가 같을떄
						if(info[j]==p) {
							// '<' 기준 현재값이 더 큰 경우는 swap idx를 증가시킨다
							if(tmp>arr[j+1]) {
								tmp=arr[j+1];
								find_idx=j+1;
							}
						}
						// 기호가 다른 경우 break
						else {
							break;
						}
					}
					
					// 위에서 찾은 find_idx와 swap
					arr[find_idx]=arr[i];
					arr[i]=tmp;
				}
			}else {
				if(arr[i]<arr[i+1]) {
					// swap
					int tmp=arr[i+1];
					int find_idx=i+1;
					for (int j = find_idx; j < info.length; j++) {
						if(info[j]==p) {
							if(tmp<arr[j+1]) {
								tmp=arr[j+1];
								find_idx=j+1;
							}
						}else {
							break;
						}
					}
					
					arr[find_idx]=arr[i];
					arr[i]=tmp;
				}
			}
		}
	}
	
}
