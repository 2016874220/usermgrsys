package Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class text9
{	
  public static void main(String args[]) throws IOException
  {
	  int[] num1= new int[15];   //声明数组存储数据
	  
	  BufferedWriter out = new BufferedWriter(new FileWriter("file2.txt"));
	  
	  Random figure = new Random(9999);     // or : Random figure = new Random(); 伪随机函数
      for (int i=0;i<num1.length;i++)       //随机输入15个数
      {
    	  num1[i]=20+figure.nextInt(9999);        //声明区间20~9999
    	  out.write(num1[i]+"");                  //将随机数据写入文件
    	  out.newLine();
      }
      out.close();
      
      BufferedReader in=new BufferedReader(new FileReader("file2.txt"));
      
      //声明数组，并存入读取出的file2的数据
      int[] num2= new int[15];
      for (int i=0; i<num2.length;i++)
    	  num2[i]=Integer.parseInt(in.readLine());
      in.close();
      
      //对15个数进行升序排序
      Arrays.sort(num2);
      System.out.print("升序后：\n");
      for (int i=0; i<num2.length;i++)
    	  System.out.print(num2[i]+"   ");
  }
}