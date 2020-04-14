package groom;
import java.io.*;
import java.util.StringTokenizer;
public class 암스트롱수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		for (int i = a; i <=b; i++) {
			String tmp=Integer.toString(i);
			int com=0;
			for (int j = 0; j < tmp.length(); j++) {
				com+=Math.pow((tmp.charAt(j)-'0'),3);
			}
			if(com==i)
				System.out.print(i+" ");
		}
	}
}
