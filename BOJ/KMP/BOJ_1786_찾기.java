import java.util.*;
import java.io.*;

//https://octorbirth.tistory.com/121
//https://baeharam.github.io/posts/algorithm/kmp/
public class BOJ_1786_찾기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		char[]text=br.readLine().toCharArray();
		char[]pattern=br.readLine().toCharArray();
		
		List<Integer> res=kmp(text,pattern);
		System.out.println(res.size());
		for(int i : res)
			System.out.print(i+" ");
	}
	
	private static List<Integer> kmp(char[]text, char[]pattern){
		// pattern table 만들기
		int[]table=maketable(pattern);
		int textSize=text.length;
		int patternSize=pattern.length;
		
		List<Integer> mid=new ArrayList<Integer>();
		
		int j=0;
		// text까지 순회할 예정
		// table과 달리 0번째 idx부터 탐색
		for (int i = 0; i < textSize; i++) {
			// 아래와 같이 비교할 j idx 작업
			while(j>0 && text[i]!=pattern[j])
				// 이전 j값으로 갱신
				j=table[j-1];
			
			// text[i(끝)]=pattern[j]
			// 1) j가 우연히 새로운 패턴의 경우 : 새로운 시작일 수 있음
			// 2) j가 끝인 경우 : 일치
			if(text[i]==pattern[j]) {
				// j가 patternSize의 마지막 idx인 (size-1) 인 경우 -> 패턴매칭성공
				if(j==patternSize-1) {
					// i, patternSize 모두 0 기준 시작이므로 1기준 시작으로 변환하기 위해 +2
					mid.add(i-patternSize+2);
					// (중요!) 패턴 찾기 성공후 j값 갱신 -> 완료했을 떄의 table[j]값이 새로운 기준이다.
					j=table[j];
				}
				// 새로운 패턴의 시작인 경우 -> j기준 다음 탐색할 pattern의 idx j+1로 갱신
				else {
					j++;
				}
			}
		}
		
		return mid;
	}
	// 패턴별로 접두사=접미사 인 최대개수
	// ex) ABABAB -> F(5)=4 -> 접두사 ABAB = 접미사 ABAB
	private static int[] maketable(char[]pattern) {
		int size=pattern.length;
		int[]table=new int[size];
		
		// 길이가 i인 sub패턴에서 최종 i번째 idx를 제외하고 중복되는 개수를 저장할 변수
		int j=0;
		for (int i = 1; i < size; i++) {
			// 1) j=0이면 -> while문 수행 x -> 첫번째 idx와 현재 i번째 idx의 값이 같은지는 아래 if문으로 파악 
			// 2) j>0이면 i-1번째 수행됬던 sub패턴이 상황이며 2가지 경우로 나뉨
			// 2-1) 현재 j와  i가 일치하면 i-1번째까지 적용됬던 정보를 그대로 사용 -> while문 수행 x -> 아래 if문에서 p[i]=p[j]이면 j 증가, 아니면 현상유지
			// 2-2) 일치하지 않으면 새로운 j로 갱신 -> j기준 바로 이전 최신인 j-1의 값으로 갱신되며 2단계를 수행
			while(j>0 && pattern[i]!=pattern[j])
				j=table[j-1];
			
			if(pattern[i]==pattern[j])
				table[i]=++j;
		}
		
		return table;
	}
}
	
