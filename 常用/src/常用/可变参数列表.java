package 常用;

public class 可变参数列表 {
	public float avg(int...nums){
		int sum=0;
		for(int x:nums){ //重点
			sum+=x;
		}
		return ((float)sum)/nums.length;
	}
	public static void main(String args[]){
		可变参数列表 cal=new 可变参数列表();
		float avg1=cal.avg(12,134,3543,232);
		float avg2=cal.avg(13,41,865,78,174);
		System.out.println(avg1);
		System.out.println(avg2);
	}
}
