import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2143_두배열의합 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		int find=Integer.parseInt(br.readLine());
		
		int size1=Integer.parseInt(br.readLine());
		int[]arr1=new int[size1];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < size1; i++)
			arr1[i]=Integer.parseInt(st.nextToken());
		
		int size2=Integer.parseInt(br.readLine());
		int[]arr2=new int[size2];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < size2; i++)
			arr2[i]=Integer.parseInt(st.nextToken());
		
		
		// 부분합 배열 정의 : 자기자신(시작==끝)을 포함해서 시작과 끝점을 뽑는 조합  -> (size+1)*size/2
		// size=4 인경우 총 부분합 배열은 5*4/2=10
		
		long[]arrA=new long[size1*(size1+1)/2];
		long[]arrB=new long[size2*(size2+1)/2];
		
		int idx=0;
		for (int i = 0; i < arr1.length; i++) {
			arrA[idx++]=arr1[i];
			long mid=arr1[i];
			for (int j = i+1; j < arr1.length; j++) {
				mid+=arr1[j];
				arrA[idx++]=mid;
			}
		}
		
		idx=0;
		for (int i = 0; i < arr2.length; i++) {
			arrB[idx++]=arr2[i];
			long mid=arr2[i];
			for (int j = i+1; j < arr2.length; j++) {
				mid+=arr2[j];
				arrB[idx++]=mid;
			}
		}
		
		// sorting
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		// 한 배열은 left 기준으로 0번 idx부터 시작, 나머지는 right를 기준으로 배열의 끝부터 순회
		// left 기준 arrA , right 기준 arrB 세팅
		
		int left=0, right=arrB.length-1;
		// 중요 ! long 범위로 선언하여 오버플로우 방지
		long cur=0,cnt=0;
		
		while(true) {
			
			// 만일 left가 배열의 끝까지가거나 right가 -1로 순회를 마치면 탐색 종료
			if(left==arrA.length || right==-1)
				break;
			
			// 순회중인 값 cur
			cur=arrA[left]+arrB[right];
			
			// 큰 값부터 순회했던 right--
			if(cur>find) {
				right--;
			}
			// 작은 값부터 순회했던 left++
			else if(cur<find) {
				left++;
			}
			// 일치하는 경우 
			else {
				// 초기 left, right 값을 mid에 저장
				int left_mid=left;
				int right_mid=right;
				
				// left 기준 같은 값을 가진 개수를 카운트할 cntA, right도 마찬가지로 cntB
				long cntA=0, cntB=0;
				
				// cntA를 증가시키며 left shift
				while(left<arrA.length && arrA[left_mid]==arrA[left]) {
					cntA++;
					left++;
				}
				// cntB를 증가시키며 left shift
				while(right>=0 && arrB[right_mid]==arrB[right]) {
					cntB++;
					right--;
				}
				
				// 현재 루프에서 나오는 총 경우의수는 두 수를 곱한 값
				cnt+=cntA*cntB;
			}
		}
		
		System.out.println(cnt);
	}
}
