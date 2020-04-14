import java.io.*;
import java.util.*;

public class BOJ_14725_개미굴_tree맵정렬 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int loop=Integer.parseInt(br.readLine());
		Trie trie=new Trie();
		
		for (int i = 0; i < loop; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int size=Integer.parseInt(st.nextToken());
			String[]str=new String[size];
			for (int j = 0; j < size; j++) {
				str[j]=st.nextToken();
			}
			
			trie.add(str);
		}

		Node root=trie.root;
		dfs(root, 0);
	}
	
	public static void dfs(Node cur, int dep) {
		
		if(cur.child==null)
			return;
		
		// hashMap의 경우 key가 정렬되어 있지 않으므로 Treemap사용
		TreeMap<String, Node> tm=new TreeMap<String, Node>(cur.child);
		Set<String> keyset=cur.child.keySet();
		
		Iterator<String> it=tm.keySet().iterator();
		
		// 사전순 key를 기준으로 go
		// dep를 통해 -- 출력
		while(it.hasNext()) {
			
			for (int i = 0; i < dep; i++)
				System.out.print("--");
			
			String keyval=it.next();
			System.out.println(keyval);
			dfs(cur.child.get(keyval),dep+1);
		}
	}
}

class Trie{
	
	Node root;
	
	public Trie() {
		root=new Node();
	}
	
	public void add(String[] s) {
		// root에서부터 탐색
		Node now=root;
		
		for (int i = 0; i < s.length; i++) {
			// 현재 now.child 해쉬에 존재하지 않으면 add 
			if(!now.child.containsKey(s[i])) {
				now.child.put(s[i], new Node());
			}
			// 다음 node로 넘어감 -> key값을 참조해서
			now=now.child.get(s[i]);
		}
	}
}

class Node{
	// key값 String과 하위 node로 구성
	HashMap<String, Node> child;
	
	public Node() {
		child=new HashMap<String, Node>();
	}
}