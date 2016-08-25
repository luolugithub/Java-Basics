
public class Sushu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		label:
		for(i=1;i<=200;i++)
		{
			for(j=2;j<=i/2;j++)
			if(i%j==0)
				continue label;
		System.out.println(i);
		}
	}

}
