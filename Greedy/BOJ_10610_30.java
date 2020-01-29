import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10610_30 {

	static Scanner sc=new Scanner(System.in);
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
	
		String s=sc.nextLine();
		
		if(!s.contains("0"))
			System.out.println(-1);
		else {
			char[]tmp=s.toCharArray();
			int q=0;
			for (int i = 0; i < tmp.length; i++) {
				q+=tmp[i]-'0';
			}
			if(q%3!=0)
				System.out.println(-1);
			else {
				Arrays.sort(tmp);
				for (int i = tmp.length-1; i >=0; i--) {
					bw.write(tmp[i]+"");
				}
				bw.flush();
				bw.close();
			}
		}
			
	}
}
