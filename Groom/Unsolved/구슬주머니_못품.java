package groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구슬주머니_못품 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> tmp=new ArrayList<Integer>();
	static int[]dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n=Integer.parseInt(br.readLine());
		int[]map=new int[n+1];
		int idx=1;
		dp=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			map[idx]=Integer.parseInt(st.nextToken());
		
	}
}
