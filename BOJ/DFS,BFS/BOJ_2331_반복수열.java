import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2331_반복수열{

	static Scanner sc=new Scanner(System.in);
	//9999 5 최대값 입력시 295245를 boolean에 넣어주어야함
	static boolean[]visit=new boolean[300000];
	static LinkedList<Integer> map=new LinkedList<Integer>();
	static int a,p, fin;
	
	public static void main(String[] args) {

		a=sc.nextInt();
		p=sc.nextInt();
		
//		dfs(a);
		bfs(a);
		System.out.println(fin);
	}
	
	public static void dfs(int num) {
		
		visit[num]=true;
		map.add(num);
		
		String s=Integer.toString(num);
		int loop=s.length();
		int tmp=0;
		
		for (int i = 0; i < loop; i++) {
			tmp+=Math.pow(s.charAt(i)-'0', p);
		}
		
		if(!visit[tmp]) {
			dfs(tmp);
		}
		// 처음으로 visit했을 때 값이 나오면 그 시점부터 반복되는 거임 -> 최초 반복 인덱스만 찾고 return
		else {
			for (int i = 0; i < map.size(); i++) {
				if(map.get(i)==tmp) {
					fin=i;
					return;
				}
			}
		}
	}
	
	public static void bfs(int num) {
	
		Queue<Integer> info= new LinkedList<Integer>();
		info.add(num);
		map.add(num);
		
		while(!info.isEmpty()) {
			
			int q=info.poll();
			visit[q]=true;
			
			String s=Integer.toString(q);
			int loop=s.length();
			int tmp=0;
			
			for (int i = 0; i < loop; i++) {
				tmp+=Math.pow(s.charAt(i)-'0', p);
			}
			
			if(!visit[tmp]) {
				info.add(tmp);
				map.add(tmp);
			}
			else {
				for (int i = 0; i < map.size(); i++) {
					if(map.get(i)==tmp) {
						fin=i;
						return;
					}
				}
			}
		}
	}
}
