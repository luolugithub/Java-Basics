import java.io.*;
public class Switch {
//Switch语句应用
	public static void main(String[] args)throws IOException{
		int day;
		while(true){
		System.out.println("请输入星期数：");
		day=(int)((System.in.read())-'0');
		switch(day)
		{
			case 1:System.out.println("周一");break;
			case 2:System.out.println("周二");break;
			case 3:System.out.println("周三");break;
			case 4:System.out.println("周四");break;
			case 5:System.out.println("周五");break;
			case 6:System.out.println("周六");break;
			case 7:System.out.println("周日");break;
			default: System.out.println(day+"是无效数!");
		}
		}// TODO Auto-generated method stub

	}

}
