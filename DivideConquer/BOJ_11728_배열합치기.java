import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[]dp, sort;
	
	public static void main(String[] args) throws IOException {
		
//		solve1();
		solve2();
	}
	
	public static void solve1() throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int []dp1=new int[stoi(st.nextToken())];
		int []dp2=new int[stoi(st.nextToken())];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < dp1.length; i++) {
			dp1[i]=stoi(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < dp2.length; i++) {
			dp2[i]=stoi(st.nextToken());
		}
		
		int cnt=0, idx1=0, idx2=0;
		while(cnt<dp1.length+dp2.length) {
			
			if(idx1==dp1.length)
				bw.write(dp2[idx2++]+" ");
			else if(idx2==dp2.length)
				bw.write(dp1[idx1++]+" ");
			else if(dp1[idx1]>dp2[idx2])
				bw.write(dp2[idx2++]+" ");
			else if(dp1[idx1]<dp2[idx2])
				bw.write(dp1[idx1++]+" ");
			else {
				bw.write(dp1[idx1++]+" ");
				bw.write(dp2[idx2++]+" ");
				cnt++;
			}
			
			cnt++;
		}
		
		bw.flush();
		bw.close();
	}

	public static void solve2() throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=stoi(st.nextToken());
		int b=stoi(st.nextToken());
		
		//static 변수
		dp=new int[a+b];
		sort=new int[a+b];
		st=new StringTokenizer(br.readLine());
		
		for (int i = 0; i < a; i++) {
			dp[i]=stoi(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for (int i = a; i < a+b; i++) {
			dp[i]=stoi(st.nextToken());
		}
		
		divide(0,a+b-1);
		for (int i = 0; i < dp.length; i++) {
			bw.write(dp[i]+" ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void divide(int st, int end) {
		
		if(st<end) {
			int mid=(st+end)/2;
			divide(st, mid);
			divide(mid+1,end);
			merge(st,mid,end);
		}
	}
	
	public static void merge(int st, int mid, int end) {

		int i=st; // 첫 번째 부분집합의 시작위치
		int j=mid+1; // 두 번째 부분집합의 시작위치 설정
		int k=st;
		
		while(i<=mid && j<=end) {
			if(dp[i]<dp[j])
				sort[k++]=dp[i++];
			else
				sort[k++]=dp[j++];
		}
		
		while (i <= mid) {
            sort[k++] = dp[i++];
        }

        while (j <= end) {
            sort[k++] = dp[j++];
        }
		
		for (int q = st; q <= end; q++) {
			dp[q]=sort[q];
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
