
public class copyarray {

	public static void main(String[] args) {
		char[] copyfrom={'d','e','c','a','f','f','e','i','n','a','t','e','d'};
		char[] copyto=new char[7];
		
		System.arraycopy(copyfrom, 2, copyto, 0, 7);
		System.out.println(new String(copyto));
	}

}
