import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1525_퍼즐 {

	//https://dundung.tistory.com/67
	//https://dev-jm.tistory.com/24
	static Scanner sc=new Scanner(System.in);
	static int ori=123456789;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) {
		
		int st=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int k=sc.nextInt();
				// 0이 맨앞으로 가게 되면 정수로 파싱하게 되면, 손실될 문제가 발생할 수도 있으니, 0을 9로 처리하는 것이 조금 더 관리에 용이할 것이다.
				// ex) 입력이 0xxxxxxxx인 경우
				if(k==0)
					k=9;
				
				// 입력을 자리수 하나씩 앞으로 땡기면서 +k를 통해 넣기
				st=(st*10)+k;
			}
		}
		
		solve(st);
	}
	
	public static void solve(int st) {
		
		Queue<Integer> tmp=new LinkedList<Integer>();
		// boolean배열로 987654321까지의 중복 확인이 어려움
		// set or map 사용
		// map을 사용해서 key,value값으로 (맵, 횟수를 넣을 예정)
		HashMap<Integer, Integer> visit=new HashMap<Integer, Integer>();

		tmp.add(st);
		visit.put(st, 0);
		
		while(!tmp.isEmpty()) {
			
			int q=tmp.poll();
			// swap 사용을 위해 String으로 변환
			String now=Integer.toString(q);
			// 9의 idx를 찾기
			// 중요) indexof -> String으로 찾기
			int nine=now.indexOf("9");
			// 중요) 1차원 num-> n*n 행렬에서의 2차원으로 표현
			int row=nine/3;
			int col=nine%3;
			
			for (int i = 0; i < dir.length; i++) {
				int tx=row+dir[i][0];
				int ty=col+dir[i][1];
				// 중요) 2차원 -> 1차원 
				int move=tx*3+ty;
				
				if(tx>=0 && tx<3 && ty>=0 && ty<3) {
					// swap하기 위한 StringBuilder 사용
					StringBuilder sb=new StringBuilder(now);
					// 9가 이동할 idx=move의 값을 저장
					// 저장한 c1값을 위에서 찾은 nine과 swap
					char c1=sb.charAt(move);
					sb.setCharAt(move, '9');
					sb.setCharAt(nine, c1);
					// swap 후 sb의 값을 정수화
					int next=Integer.parseInt(sb.toString());
					
					// 해당 키의 값이 존재여부 확인
					if(!visit.containsKey(next)) {
						tmp.add(next);
						// queue에서 나온 이전방문 지점의 value+1;
						visit.put(next, visit.get(q)+1);
					}
				}
			}
		}
		
		if(visit.containsKey(123456789))
			System.out.println(visit.get(123456789));
		else
			System.out.println(-1);
			
	}
}
