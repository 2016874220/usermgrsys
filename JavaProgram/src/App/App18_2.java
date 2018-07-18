package App;

//filename：App18_2.java      利用InetAddress编程
import java.net.*;
public class App18_2
{
InetAddress myIPAddress=null;
InetAddress myServer=null;
public static void main(String[] args)
{
  App18_2 search=new App18_2();
  System.out.println("您主机的IP地址为："+ search.myIP());
  System.out.println("服务器的IP地址为："+ search.serverIP());
}
public InetAddress myIP()
{
  try    //获取本机的IP地址
  { myIPAddress=InetAddress.getLocalHost(); }
  catch(UnknownHostException e) {  }
  return (myIPAddress);
}
public InetAddress serverIP()
{
  try
  { myServer=InetAddress.getByName("www.tom.com"); }
  catch(UnknownHostException e) {  }
  return (myServer);
}
}
