import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1700_멀티탭스케줄링{

	//https://hibee.tistory.com/255
	static Scanner sc=new Scanner(System.in);
	static int[]arr, multi;
	static HashMap<Integer, Integer> hm;
	
	public static void main(String[] args) {
	
		int chance=sc.nextInt();
		int n=sc.nextInt();
		// 0번 인덱스 사용 안함
		multi=new int[chance+1];
		arr=new int[n];
		// 넘버와 횟수를 해시에 저장
		hm=new HashMap<Integer, Integer>();
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
			if(hm.containsKey(arr[i]))
				hm.put(arr[i], hm.get(arr[i])+1);
			else
				hm.put(arr[i], 1);
		}
		
		// 순회할 인덱스 idx, 멀티탭 change횟수 cnt
		int idx=0;
		int cnt=0;
		
		while(idx<n) {
			int cur=arr[idx];
			// 멀티탭에 자리가 남는경우
			if(chance>0) {
				// 자리가 남아도 현재 cur가 꼽혀있는 멀티탭이 있는지 확인
				boolean exist=false;
				for (int i = 1; i <multi.length; i++) {
					if(multi[i]==cur) {
						exist=true;
						break;
					}
				}
				// 멀티탭에 cur이 없는 경우 chance를 줄이고 multi에 넣기
				if(!exist)
					multi[chance--]=cur;
				
				//  key가 cur인 해시 방문처리 -> -1 
				hm.put(cur,hm.get(cur)-1);
			}
			// 멀티탭이 꽉찬 경우
			else {
				// 현재 cur기준 멀티탭에 있는지 확인
				boolean contain=false;
				for (int i = 1; i < multi.length; i++) {
					if(multi[i]==cur) {
						// 멀티탭에 꽃혀있으면 현재 cur 방문처리 -> -1 
						hm.put(cur,hm.get(cur)-1);
						contain=true;
						break;
					}
				}
				
				// contain이 false면 현재 cur이 멀티탭에 없으므로 하나를 뽑아야함 -> cnt ++
				if(!contain) {
					cnt++;
					// 배열내 순회시 시작 인덱스 idx, 멀티탭에 꽃을 cur값 
					solve(idx, cur);
				}
			}
			idx++;
		}
		System.out.println(cnt);
	}
	
	public static void solve(int idx, int next) {
		// 멀티탭에 꽃혀있는 숫자 중에서 앞으로 사용하지 않는 숫자가 있다(해시 값이 0이다) -> 그 자리와 swap
		for (int i = 1; i < multi.length; i++) {
			if(hm.get(multi[i])==0) {
				// 현재 멀티탭에 꽃혀있으며, 더이상 남은 카운트가 없는(앞으로 사용안하는 숫자) 숫자가 있으면 멀티탭 꽃기
				multi[i]=next;
				// 멀티탭에 꽃고 방문처리
				hm.put(next,hm.get(next)-1);
				return;
			}
		}
		
		// (중요) 그리디 적용 !!
		// 멀티탭에 꽃혀있는 모든 숫자가 향후에 계속 사용되는 경우
		// 가장 나중에 사용되는 멀티탭을 찾아 일단 거기와 swap(이를 통해 최소 swap을 구할 수 있다)
		
		// tmp : 멀티탭 구멍 개수 총 n개중에서 n-1까지 카운트할 변수 (0 부터 시작)
		// check[] : 중복 숫자가 있는 경우가 있기에 이를 판별할 boolean 배열
		int tmp=0;
		boolean[]check=new boolean[multi.length];
		
		// 현재 idx 이후부터 숫자중 가장 나중에 사용하는 멀티탭을 찾는 과정
		for (int i = idx+1; i <arr.length; i++) {
			for (int j = 1; j < multi.length; j++) {
				// next 숫자인 arr[i]와 멀티탭애 꼽혀있는 multi[j]를 비교해나감
				// check를 통해 중복 여부를 동시에 확인
				
				if(arr[i]==multi[j] && !check[j]) {
					// 마지막 멀티탭을 찾은 경우
					// multi에 인덱스 1부터 사용하므로 -2 처리
					if(tmp==multi.length-2) {
						// 해당 멀티탭을 뽑아 next로 갱신하고
						multi[j]=next;
						// next 순회 방문처리
						hm.put(next,hm.get(next)-1);
						return;
					}
					// 마지막 멀티탭이 아닌 경우
					else {
						// 현재 멀티탭의 확인 처리 및 tmp 증가
						check[j]=true;
						tmp++;
						break;
					}
				}
			}
		}
	}
}
