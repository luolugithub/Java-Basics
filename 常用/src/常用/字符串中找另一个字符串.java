package ����;

public class �ַ���������һ���ַ��� {
	public static void main(String args[]){
		String searchme="Look for a substring in me";
		String substring="sub";
		boolean foundit=false;
		
		int max=searchme.length()-substring.length();
		
		test://�ؼ���
			for(int i=0;i<max;i++)
			{
				int n=substring.length();
				int j=i;
				int k=0;
				while(n--!=0){
					if(searchme.charAt(j++)!=substring.charAt(k++)){
						continue test;
					}
				}
				foundit=true;
				break test;
			}
		System.out.println(foundit?"found it":"didn't find it");
	}
}
