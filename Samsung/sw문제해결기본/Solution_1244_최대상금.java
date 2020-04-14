import java.util.Scanner;
 
//https://sejinik.tistory.com/220

public class Solution_1244_최대상금 {
    public static int[] arr;
    public static int k,ans;
    public static boolean[][] check = new boolean[1000000][2];
    public static void swap(int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y]=temp;
    }
    public static int num() {
        int ret=0;
        for(int i=0;i<arr.length;i++) {
            ret*=10; 
            ret+=arr[i];
        }
        return ret;
    }
    public static void solve(int cnt) {
    	// 홀수나 짝수에 방문하는 케이스 -> 왔다갔다가 가능한 여부
    	// 움직이는회수로 2차원 배열을 잡으면 메모리초과 가능성 有
        check[num()][cnt%2]=true;
        if(cnt==k) {
            ans = Math.max(ans, num()); 
            return;
        }
        
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                if(i==j) continue;
                swap(i,j);
                // 현재 cnt 기준 홀->짝 , 짝->홀 로 변환
                if(!check[num()][(cnt+1)%2]) 
                	solve(cnt+1);
                swap(i,j);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1;tc<=t;tc++) {
            String s = sc.next(); k=sc.nextInt();
            char[] ca = s.toCharArray();
            arr = new int[ca.length];
            
            for(int i=0;i<ca.length;i++) arr[i]=ca[i]-'0';
            ans=num();
            solve(0);
            System.out.println("#"+tc+" "+ans);
        }
    }
}
