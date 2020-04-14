import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://suriisurii.tistory.com/72
public class BOJ_5052_전화번호목록_트라이 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			int size=Integer.parseInt(br.readLine());
			String[]list=new String[size];
			boolean success=true;
			
			for (int i = 0; i < size; i++)
				list[i]=br.readLine();
			
			// 정렬 : 접두어를 순서대로 하여 효율적으로 탐색 가능
			Arrays.sort(list);
			
			//trie 생성
			Trie trie=new Trie();
			for (int i = 0; i < list.length; i++) {
				if(trie.add(list[i].toCharArray())) continue;
				
				success=false;
				break;
			}
			
			System.out.println((success)? "YES":"NO");
		}
	}
	
	static class Trie{
		// 트라이에 root 노드 정의 -> root에는 0~10까지의 서브노드가 존재
		Node[]root;
		public Trie() {
			root=new Node[10];
		}
		
		// 입력들어온 char[] 하나씩 비교하며 삽입
		boolean add(char[] key) {
			// root 바로 아래 노드에 연결하는 작업
			int first=key[0]-'0';
			// 첫 숫자가 root에 연결되어있지 않으면 -> first로 시작하는 서브루트 생성
			if(root[first]==null)
				root[first]=new Node();
			
			// key의 모든 char순서대로 탐색하여 add가 가능한지 여부 파악
			int len=key.length;
			
			// 처음에는 root[10] 사이의 노드
			// 순회하면서 now를 하나씩 아래로 내림 ->children으로
			Node now=root[first];
			
			// (중요) idx 체크 -> i=1부터면 fail
			for (int i = 0; i < len; i++) {
				int next=key[i]-'0';
				
				if(now.children[next]==null)
					now.children[next]=new Node();
				
				now=now.children[next];
				// 현재 순회하고 있는 노드가 다른 key가 방문후 finish라고 처리해놨으면 -> 현재 key는 다른 key의 포함된다.
				if(now.finish)
					return false;
			}
			// key의 모든 순회를 마치고 최종 now에 마지막임을 표시
			now.finish=true;
			return true;
		}
	}
	
	static class Node{
		Node[] children;
		boolean finish;
		
		public Node() {
			// 하나의 트라이 노드는 0~9까지의 sub트라이 노드를 가짐(k 트리)
			children=new Node[10];
			// 마지막 포인트인지 여부
			// (중요) 예를 들어 A노드에서 해당 노드를 탐색할 때 finish가 true이면 해당노드는 A노드에 포함되는 상황 
			finish=false;
		}
	}
}
