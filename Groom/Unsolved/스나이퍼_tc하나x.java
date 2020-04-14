package groom;

import java.io.*;
import java.util.*;

public class 스나이퍼_tc하나x {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n=Integer.parseInt(br.readLine());
		String[]map=new String[n];
		
		// hashset이용해서 거기에서 2개씩 bfs
		
		LinkedHashSet<Character> tmp=new LinkedHashSet<Character>();
		
		for (int i = 0; i < n; i++) {
			String s=br.readLine();
			map[i]=s;
			tmp.add(s.charAt(0));
			tmp.add(s.charAt(2));
		}
		int res=0;
		for(char p : tmp) {
			for(char q : tmp) {
				if(p==q) continue;
				int size=0;
				for (int i = 0; i < map.length; i++) {
					if(map[i].contains(p+"") || map[i].contains(q+""))
						size++;
				}
				if(size==n)
					res++;
			}
		}
		
		if(res==0)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
