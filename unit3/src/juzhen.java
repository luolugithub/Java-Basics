
public class juzhen {

	public static void main(String[] args) {
		int i,j,k=0;
		int a[][]=new int[5][5];
		for(i=0;i<5;i++)
			for(j=0;j<5;j++)
				{
					a[i][j]=k;
					k++;
				}
		for(i=0;i<5;i++){
			for(j=0;j<5;j++)
				System.out.print(a[i][j]+" ");
			System.out.print('\n');
			}
	}
}
