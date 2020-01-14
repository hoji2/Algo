import java.util.Scanner;

//https://rightbellboy.tistory.com/11

public class BOJ_11718_그대로출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		sc.next() -> 다음 토큰을 읽습니다.
		sc.nextLine -> 다음 행을 읽습니다.
		sc.hasNext -> 토큰이 있는지 확인하고 boolean을 리턴합니다. 공백의 경우 무시합니다.
		sc.hasNextLine -> 행이 있는지 확인 후 boolean을 리턴합니다. 줄바뀜이 있으면 true를 리턴합니다.
		 */
		while(sc.hasNextLine()) {
			String input = sc.nextLine();
			System.out.println(input);
		}
		sc.close();
	}
}
