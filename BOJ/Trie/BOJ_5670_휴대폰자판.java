import java.io.*;
import java.util.*;

public class BOJ_5670_휴대폰자판 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int cnt;
	public static void main(String[] args) throws IOException {
	
		while(true) {
			String mid=br.readLine();
			if(mid==null)
				return;
			int n=Integer.parseInt(mid);
			String[]s=new String[n];
			for (int i = 0; i < n; i++) {
				s[i]=br.readLine();
			}
			
			Arrays.sort(s);
			Trie trie=new Trie();
			
			for (int i = 0; i < s.length; i++)
				trie.add(s[i].toCharArray());
			
			cnt=0;
			dfs(trie.root,0);
			
			
			double res=(double)cnt/n;
			
			// 예외) 처음 루프 시작 시 root의 child size가 1이면 +1

			if(trie.root.child.size()==1)
				res++;
			
			System.out.printf("%.2f\n",res);
		}
	}
	
	public static void dfs(Node cur, int dep) {
		
		if(cur.end) {
			cnt+=dep;
			//check -> !=0 이면 fail
			if(cur.child.size()==1) {
				dep++;
			}
		}
		
		if(cur.child.size()>1)
			dep++;
		
		for(Character key : cur.child.keySet()) {
			Node next=cur.child.get(key);
			dfs(next,dep);
		}
	}
}

class Trie{
	Node root;
	public Trie() {
		root=new Node();
	}
	
	public void add(char[] arr) {
		Node now=root;
		for (int i = 0; i < arr.length; i++) {
			if(!now.child.containsKey(arr[i]))
				now.child.put(arr[i], new Node());
			
			now=now.child.get(arr[i]);
		}
		now.end=true;
	}
}

class Node{
	
	HashMap<Character, Node> child;
	boolean end;
	
	public Node() {
		this.child=new HashMap<Character, Node>();
		this.end=false;
	}
}