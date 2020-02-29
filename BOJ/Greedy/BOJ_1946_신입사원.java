import java.util.Scanner;

public class BOJ_1946_신입사원 {

	//https://plplim.tistory.com/39
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int tc=sc.nextInt();

		for (int i = 0; i < tc; i++) {
			
			int n=sc.nextInt();
			int[]map=new int[n+1];
			
			// (중요) 입력이 점수가 아닌 순위이다 -> 낮을수록 좋은것 
			// 서류순위로 정렬하기 위해 map에 idx를 입력을 받아 정렬 최소화
			for (int j = 0; j < n; j++) {
				map[sc.nextInt()]=sc.nextInt();
			}
			
			// 1순위 서류지원자를 최초합격으로 설정
			// 이후 지원자들은 앞선 지원자보다 면접순위가 낮아야 합격, 초기 면접순위는 map[1];
			int cnt=1;
			int min=map[1];
			
			// 2순위 서류지원자부터 마지막 순위 지원자 까지 순회
			for (int j = 2; j <=n; j++) {
				// 서류 j번째 순위의 면접순위가 이전 합격한 지원자의 면접순위보다 낮은경우
				// 이경우 합격이며, 새로운 면접순위로 갱신한다
				if(map[j]<min) {
					cnt++;
					min=map[j];
				}
			}
			System.out.println(cnt);
		}
	}
}
