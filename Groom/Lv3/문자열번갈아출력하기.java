package groom;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 문자열번갈아출력하기 {

	static Scanner sc=new Scanner(System.in);
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
	
		String s=sc.nextLine();
		
		int left=0;
		int right=s.length()-1;
		
		while(true) {
			if(left>right)
				break;
			else if(left==right) {
				bw.write(s.charAt(left));
				break;
			}
			bw.write(s.charAt(left));
			bw.write(s.charAt(right));
			left++;
			right--;
		}
		bw.flush();
		bw.close();
		
	}
}
