
public class Program_Lv1_비밀지도 {

	public String[] solution(int n, int[] arr1, int[] arr2) {

	      String[]tmp=new String[n];

	      for(int i=0; i<arr1.length; i++){
	          String s1=Integer.toBinaryString(arr1[i]);
	          String s2=Integer.toBinaryString(arr2[i]);

	          String t1="", t2="";
	          for(int k=1; k<=n-s1.length(); k++)
	              t1=t1.concat("0");

	          for(int k=1; k<=n-s2.length(); k++)
	              t2=t2.concat("0");

	          s1=t1.concat(s1);
	          s2=t2.concat(s2);
	          StringBuilder sb=new StringBuilder();

	          for(int q=0; q<n; q++){
	              if(s1.charAt(q)=='0' && s2.charAt(q)=='0')
	                  sb.append(" ");
	              else
	                  sb.append("#");
	          }
	          tmp[i]=sb.toString();
	      }

	      return tmp;

	  }
}
