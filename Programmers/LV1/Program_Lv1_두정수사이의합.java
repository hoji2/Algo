
public class Program_Lv1_두정수사이의합 {

	// 등차수열의 합
	// return (b - a + 1) * (a + b) / 2;
	
	public static long solution(int a, int b) {
      long answer = 0;

       for(int i=Math.min(a,b);i<=Math.max(a,b);i++)    answer+=i;

      return answer;
  }
}
