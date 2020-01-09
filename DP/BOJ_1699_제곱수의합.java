import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * BOJ#1699 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */

public class BOJ_1699_제곱수의합 {

	public static void main(String[] args) throws IOException {

		// 그리디 X
		// 반례 : 12 = 2^2 + 2^2 + 2^2 (3) VS 3^2 + 1^1 + 1^1 + 1^1 (4)
		int N;
		int[] dp;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {

			// 1^2 + 1^2 들의 합으로 초기화
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {

				// 점화식 +1은 제곱수의 합 
				// ex) 2^2 , 3^2를 고려한 +1 후, 나머지 차이에 대한 dp배열 접근
				int temp = dp[i - j * j] + 1;

				dp[i] = dp[i] > temp ? temp : dp[i];
			}
		}
		System.out.println(dp[N]);
	}

}