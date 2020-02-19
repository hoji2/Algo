import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

// List get 메소드 o(N) -> ListIterator 사용하여 o(1)로 표현해야 시간초과 x
// https://bcp0109.tistory.com/87
//https://www.acmicpc.net/board/view/41385
public class BOJ_5397_키로거 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++)
			solve(br.readLine());
		
		bw.close();
	}
	
	public static void solve(String s) throws IOException {
		
		LinkedList<Character> tmp=new LinkedList<Character>();
		ListIterator<Character> it=tmp.listIterator();
		
		for (int i = 0; i < s.length(); i++) {
			char p=s.charAt(i);
			
			if(p=='<') {
				if(it.hasPrevious())
					it.previous();
			}
			else if(p=='>') {
				if(it.hasNext())
					it.next();
			}
			else if(p=='-') {
				if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
			}else {
				it.add(p);
			}
		}
		
		for(Character p : tmp)
			bw.write(p);
		
		bw.write("\n");
		bw.flush();
		
	}
}
