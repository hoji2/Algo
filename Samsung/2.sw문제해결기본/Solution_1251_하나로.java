import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[] parents;
	public static void main(String[] args) throws IOException {
	
		int tc=stoi(br.readLine());
		
		for (int t = 1; t <=tc; t++) {
			int size=stoi(br.readLine());
			int[]dx=new int[size];
			int[]dy=new int[size];
			parents=new int[size];
			
			StringTokenizer st1=new StringTokenizer(br.readLine());
			StringTokenizer st2=new StringTokenizer(br.readLine());
			
			int idx=0;
			while(st1.hasMoreTokens()) {
				dx[idx]=stoi(st1.nextToken());
				dy[idx]=stoi(st2.nextToken());
				//parents 세팅
				// 각자 자기자신만 포함된 사이클 형성
				parents[idx]=idx;
				idx++;
			}
			double per=Double.parseDouble(br.readLine());
			
			// 두 노드간 거리가 작은 순서대로 Comparator 설정
			PriorityQueue<point> pq=new PriorityQueue<point>(new Comparator<point>() {

				@Override
				public int compare(point o1, point o2) {
					// TODO Auto-generated method stub
					if(o1.len<=o2.len)
						return -1;
					else
						return 1;
				}
				
			});
			
			// n개점 중 2개 씩 골라 거리를 구하고
			// pq에 start, end ,len을 add
			for (int i = 0; i < size-1; i++) {
				for (int j = i+1; j < size; j++) {
					double tmp=(Math.pow(dx[i]-dx[j], 2)+Math.pow(dy[i]-dy[j], 2))*per;
					pq.add(new point(i, j, tmp));
				}
			}
			
			double res=0;
			// cnt : 간선을 뽑을 개수
			int cnt=0;
			// 정점의 개수 size보다 하나 작은 size-1개의 간선을 뽑을 때 가지  탐색
			while(cnt!=size-1) {
				point p=pq.poll();
		
				// 만일 두 정점의 부모가 같아 사이클을 형성한다면
				if(find(p.start)==find(p.end))
					continue;
				else {
					// 두 정점을 더해주고
					union(p.start,p.end);
					cnt++;
					res+=p.len;
				}
			}
			System.out.println("#"+t+" "+Math.round(res));
		}
		
	}
	
	public static int find(int num) {
		// parents[num]==num이면 가장 큰 대표
		if(parents[num]==num)
			return num;
		
		// (중요)나중에 num 가지고 또 find 할 때 재귀 덜돌으라고 해두는 작업
		// 바로 return find(parenst[num])하기 전에 갱신해놓기
		return parents[num]=find(parents[num]);
	}
	
	public static void union(int num1, int num2) {
		int p1=find(num1);
		int p2=find(num2);
		// 부모를 합쳐준다
		parents[p1]=p2;
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

// start, end는 정점의 번호
class point{
	int start,end;
	double len;
	public point(int start, int end, double len) {
		this.start=start;
		this.end=end;
		this.len=len;
	}
}
