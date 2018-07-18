package Text;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidate
{
	private static final String SCHEMALANG = "http://www.w3.org/2001/XMLSchema";
	public static boolean xmlStringValidate(String xmlPath,String xsdPath)
	{
		boolean flag = false;
		try
		{
			SchemaFactory factory = SchemaFactory.newInstance(SCHEMALANG);
			File schemaLocation = new File(xsdPath);
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(xmlPath);
			validator.validate(source);
			flag = true;
		}
		catch(SAXException e)
		{
			System.out.println("the schema validate failed...");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("create exception in IO...");
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args)
	{
		String xmlPath = "src//database.conf.xml";
		String xsdPath = "src//database.conf.xsd";
		if(xmlStringValidate(xmlPath,xsdPath))
		{
			System.out.println("the validate is OK");
		}
	}
}