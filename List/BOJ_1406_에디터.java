import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1406_에디터 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	// https://stack07142.tistory.com/37
	// StringBuilder라고 해도 중간에 새로운 문자열을 끼워넣는 것은 그 뒤의 문자들을 전부 한 칸씩 밀어내는 연산을 필요로 합니다.
	// 링크드 리스트처럼 중간에 삽입하는 연산을 O(1)에 하는 자료구조를 쓰거나, 스택 2개를 활용한 풀이 등을 사용해야 합니다.
	// 리스트 idx 작업 : idx++ 등 매우 비효율적 -> ListIterator 사용
	// print get(i)등 매우 비효율적 -> 상향된 for문으로 출력
	
	public static void main(String[] args) throws IOException {
		
		LinkedList<Character> res=new LinkedList<Character>();
		ListIterator<Character> it;
		it=res.listIterator(res.size());
		
		String s=br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			it.add(s.charAt(i));
		}

		int loop=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < loop; i++) {
			st=new StringTokenizer(br.readLine());
			String com=st.nextToken();
			if(com.equals("P")) {
				it.add(st.nextToken().charAt(0));
			}else if(com.equals("L")) {
				if(it.hasPrevious())
					it.previous();
			}else if(com.equals("D")) {
				if(it.hasNext())
					it.next();
			}else {
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
			}
		}
		
		StringBuffer sb=new StringBuffer();
		for (char c : res) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
