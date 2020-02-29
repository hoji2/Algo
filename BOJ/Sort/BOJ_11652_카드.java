import java.util.HashMap;
import java.util.Scanner;

public class BOJ_11652_카드 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		//2^64 int,long터짐
		//(중요) 초기 String compareTo로 처리하려 했으나 예외발생
		// 9 vs 11 -> 11이 더 작은 숫자로 나옴
		
		int n=sc.nextInt();
		sc.nextLine();
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		
		for (int i = 0; i < n; i++) {
			String key=sc.nextLine();
			if(hm.containsKey(key))
				hm.put(key, hm.get(key)+1);
			else
				hm.put(key, 1);
		}
		
		String fin=" ";
		int mid=0;
		
		for(String key : hm.keySet()) {
			int tmp=hm.get(key);
			// 현재 순회중인 key의 개수인 tmp가 mid보다 크면 fin=key로 갱신
			if(tmp>mid) {
				fin=key;
				mid=tmp;
			}
			// 만일 같다면? 더 작은수를 판별
			else if(tmp==mid) {
				// 기존의 문자열 fin과 현재 순회중인 문자열 key의 부호를 판별
				boolean ori_minus=(fin.charAt(0)=='-')? true: false;
				boolean new_minus=(key.charAt(0)=='-')? true: false;
				
				// (기존 수 : -) < (새로운 수 : +) -> 변동없음
				if(ori_minus && !new_minus) {
					continue;
				}
				// (기존 수 : +) > (새로운 수 : -) -> fin을 음수인 key로 설정
				else if(!ori_minus && new_minus) {
					fin=key;
				}
				// (기존 수 : +) = (새로운 수 : +)
				else if(!ori_minus && !new_minus){
					// 자리수로 판별
					int ori_len=fin.length();
					int new_len=key.length();
					// (기존 수 길이 > 새로운 수 길이) -> 길이가 짧은 fin을 key로 설정
					if(ori_len>new_len) {
						fin=key;
					}
					// (기존 수 길이 < 새로운 수 길이) -> 변동없음
					else if(ori_len<new_len) {
						continue;
					}
					// (기존 수 길이 = 새로운 수 길이)
					else {
						// 맨 앞자리 부터  자리수 별로 탐색
						for (int i = 0; i < key.length(); i++) {
							// (기존 i번째 수 > 새로운 i번째 수) -> 더 작은 새로운 key로 갱신
							if(fin.charAt(i)>key.charAt(i)) {
								fin=key;
								break;
							}
							// (기존 i번째 수 < 새로운 i번째 수) -> 변동없음
							else if(fin.charAt(i)<key.charAt(i)) {
								break;
							}
							// (기존 i번째 수 = 새로운 i번째 수) -> 다음 루프로
						}
					}
				}
				// (기존 수 : -) = (새로운 수 : -)
				// 위의 양수일 때와 조건만 반대로
				else {
					int ori_len=fin.length();
					int new_len=key.length();
					if(ori_len>new_len) {
						continue;
					}else if(ori_len<new_len) {
						fin=key;
					}else {
						for (int i = 0; i < key.length(); i++) {
							if(fin.charAt(i)>key.charAt(i)) {
								break;
							}else if(fin.charAt(i)<key.charAt(i)) {
								fin=key;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(fin);
	}
}
