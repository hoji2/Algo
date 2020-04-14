package groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class 초특가세일이벤트80_tc반만맞춤 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,k, cnt;
	static boolean[]visit;
	
	public static void main(String[] args) throws Exception {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=stoi(st.nextToken());
		k=stoi(st.nextToken());
		cnt=n-2;
		
		ArrayList<Integer> map=new ArrayList<Integer>();
		
		
		st=new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens())
			map.add(stoi(st.nextToken()));
		
		map.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int a=Math.abs(o1-k);
				int b=Math.abs(o2-k);
				
				return a-b;
			}
		});
		
		int fir=k;
		int res=0;
		int idx=0;
		
		while(cnt!=0) {
			int p=map.get(idx);
			res+=Math.abs(fir-p);
			fir=p;
			idx++;
			cnt--;
		}
		
		System.out.println(res);
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
