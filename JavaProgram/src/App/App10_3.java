package App;

//filename：App10_3.java            数据输入/输出流的应用
import java.io.*;
public class App10_3
{
public static void main(String[] args)
{
  FileOutputStream fout;
  DataOutputStream dout;
  FileInputStream fin;
  DataInputStream din;
  try
  {
    fout=new FileOutputStream("d:\\temp");
    dout=new DataOutputStream(fout);
    dout.writeInt(10);
    dout.writeLong(12345);
    dout.writeFloat(3.1415926f);
    dout.writeDouble(987654321.123);
    dout.writeBoolean(true);
    dout.writeChars("Goodbye! ");
    dout.close();
  }
  catch (IOException e) { }
  try
  {
    fin=new FileInputStream("d:\\temp");
    din=new DataInputStream(fin);
    System.out.println(din.readInt());
    System.out.println(din.readLong());
    System.out.println(din.readFloat());
    System.out.println(din.readDouble());
    System.out.println(din.readBoolean());
    char ch;
    while ((ch=din.readChar())!='\0')
      System.out.print(ch);
    din.close();
  }
  catch (FileNotFoundException e)
  {
    System.out.println("文件未找到！！");
  }
  catch (IOException e) {  }
}
}
