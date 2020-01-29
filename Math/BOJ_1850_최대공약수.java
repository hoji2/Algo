import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_1850_최대공약수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
	
		long a=sc.nextLong();
		long b=sc.nextLong();
		long gcd=0;
		
		while(b>0) {
			gcd=b;
			b=a%b;
			a=gcd;
		}
		
		//출력이 많은경우 Syso나 stringBuffer 비효율적
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < gcd; i++) {
			bw.write("1");
		}
		bw.flush();
		bw.close();
		
	}
}
