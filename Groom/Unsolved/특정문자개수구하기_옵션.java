package groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 특정문자개수구하기_옵션 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[]map=br.readLine().toCharArray();
		char find=br.readLine().charAt(0);
		int res=0;
		
		for(char q : map)
			if(q==find)
				res++;
		
		System.out.println(res);
	}
}
