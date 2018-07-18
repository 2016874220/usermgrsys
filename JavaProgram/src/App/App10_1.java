package App;
//利用输入输出流读写文本文件
//在程序中创建一个文本文件myfile.txt，写入从键盘中输入的一串字符，然后再读取该文件并将文本文件内容显示在屏幕上
import java.io.*;
class App10_1
{
  public static void main(String[] args)
  {
    char ch;
    int data;
    try
    {
    	FileInputStream fin =new FileInputStream(FileDescriptor.in);        //声明、创建文件字节输入输出流对象fin、fout
    	FileOutputStream fout =new FileOutputStream("c:\\myfile.txt"); 
        System.out.println("请输入一串字符，并以 # 结束：");
        while ((ch=(char)fin.read())!='#')
        	fout.write(ch);
        fin.close();
        fout.close();
        System.out.println();
        fin=new FileInputStream("c:\\myfile.txt");
        fout=new FileOutputStream(FileDescriptor.out);
        while (fin.available()>0)           //返回流中的可读取的字节数
       {
        	data=fin.read();
        	fout.write(data);
       }
        fin.close();
        fout.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("文件没找到！");
    }
    catch (IOException e)
    {  }
  }
}
