public class Program_Lv2_N개의최소공배수 {

	public static void main(String[] args) {
		
		int[]arr= {6,6,6,8};
		int res=0;
		for(int i=1; i<=Integer.MAX_VALUE; i++) {
			boolean find=true;
			
			for (int j = 0; j < arr.length; j++) {
				if(i%arr[j]!=0) {
					find=false;
					break;
				}
			}
			if(find) {
				res=i;
				break;
			}
		}
		System.out.println(res);
	}
}
