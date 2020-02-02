import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1212_8진수2진수 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
	
		String s=br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			String p=Integer.toBinaryString(s.charAt(i)-'0');
			if(i!=0 && p.length()!=3)
				for (int j = 0; j < 3-p.length(); j++) {
					bw.write("0");
				}
			
			bw.write(p);
		}
		bw.flush();
		bw.close();
		
		
	}
}
