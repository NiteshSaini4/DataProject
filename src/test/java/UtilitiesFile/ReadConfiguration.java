package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration 
{
	Properties pro;
	String path="C:\\Users\\user\\Documents\\DataDriverNewProject\\Configuration\\Config.properties";
	public ReadConfiguration()
	{
		FileInputStream f1=null;
		pro=new Properties();
		try {
			f1=new FileInputStream(path);//
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			pro.load(f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUrl()
	{
		String s1=pro.getProperty("baseurl");
		if(s1!=null)
		{
			return s1;
		}
		else
		{
			throw new RuntimeException("url not found");
		}
	}
	public String getBrowser()
	{
		String s1=pro.getProperty("browser");
		if(s1!=null)
		{
			return s1;
		}
		else
		{
			throw new RuntimeException("Browser not found");
		}
	}

}
