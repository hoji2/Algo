package groom;

import java.util.Scanner;
class Main {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[]map=new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i]=sc.nextInt();
		}
		
		int res=0;
		
		for (int i = 0; i < n; i++) {
			int tmp=map[i];
			if(tmp==m){
				res++;
				continue;
			}
			for (int j = i+1; j < n; j++) {
				tmp+=map[j];
				if(tmp>m)
					break;
				else if(tmp==m) {
					res++;
					break;
				}
			}
		}
		System.out.println(res);
	}
}