class course{
	String name;
	int Cnum,Xnum;	
	public void setNameCnumXnum(String name,int Cnum,int Xnum){
		this.Cnum=Cnum;
		this.Xnum=Xnum;
		this.name=name;
	}
	String getM(){
		return Cnum+" "+Xnum+" "+name;
	}
}
public class question3 {
	public static void main(String[] args){
		course C=new course();
		C.setNameCnumXnum("Java",111, 112);
		System.out.print(C.getM());
	}

}
