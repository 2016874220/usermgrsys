package Text;

public class text3 {
	public static void main(String[] args) {
		int num,num1,num2,num3,sum;
		System.out.println("水仙花数为：");
		for(num=100;num<=999;num++){
			num1=num/100;                    //该数对应的百位数
			num2=(num%100)/10;               //该数对应的十位数
			num3=(num%100)%10;               //该数对应的个位数
			sum=(num1*num1*num1)+(num2*num2*num2)+(num3*num3*num3); //按照水仙花数的定义
			if(sum==num){                    //判断是否为水仙花数
				System.out.println(num);     //输出水仙花数
			}
		}
	}
}