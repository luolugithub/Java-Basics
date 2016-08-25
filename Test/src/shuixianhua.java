
public class shuixianhua {

	public static void main(String[] args) {
		int i,a,b,c;
		for(i=100;i<1000;i++)
		{
			a=i%10;
			b=(i/10)%10;
			c=i/100;
			if(a*a*a+b*b*b+c*c*c==i)
				System.out.println(i);
		}
		// TODO Auto-generated method stub

	}

}
