//求平均数
public class kebianCanShuliebiao {
	public float avg(int...nums){ //重点
		int sum=0;
		for(int x:nums)
			sum+=x;
		return ((float)sum)/nums.length;
	}
	public static void main(String[] args) {
		kebianCanShuliebiao cal=new kebianCanShuliebiao();
		float ave1=cal.avg(10,20,30,40);
		float ave2=cal.avg(20,13,23,432,232,234,23,3432,45,13,54);
		System.out.println("ave1="+ave1 + " ave2="+ave2);
	}

}
