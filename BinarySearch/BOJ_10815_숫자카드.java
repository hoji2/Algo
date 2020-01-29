import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {

	// 이분탐색 tip : https://www.acmicpc.net/board/view/15386 (단 정렬은 퀵은 최악 n^2 -> merge 사용)
	// hashset : https://zoonvivor.tistory.com/74
	// bitset : http://hochulshin.com/java-bitset/, https://ksh-code.tistory.com/313 , https://bcp0109.tistory.com/58
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[]check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		hashset();
		//bitset();

	}
	
	public static int stoi(String s) { 
		return Integer.parseInt(s);
	}
	
	public static void hashset() throws NumberFormatException, IOException {
		int n=stoi(br.readLine());
		HashSet<Integer> hash=new HashSet<Integer>();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			hash.add(stoi(st.nextToken()));
		
		int k=stoi(br.readLine());
		
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			if(hash.contains(stoi(st.nextToken())))
				bw.write("1 ");
			else
				bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void bitset() throws IOException {
		
		int n=stoi(br.readLine());
		BitSet bitset=new BitSet();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			bitset.set(stoi(st.nextToken())+10000000);
		
		int k=stoi(br.readLine());
		
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			 if(bitset.get(stoi(st.nextToken())  + 10000000))
	                bw.write("1 ");
	            else
	                bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
		
	}
}