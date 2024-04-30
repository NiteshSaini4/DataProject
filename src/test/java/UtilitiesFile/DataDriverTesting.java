package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriverTesting 
{
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow rw;
	public static XSSFCell cl;
	public static FileInputStream fn;
	
	public static int getRowCount(String filename,String Sheet) throws Exception
	{
		fn=new FileInputStream(filename);
		wb=new XSSFWorkbook(fn);
		ws=wb.getSheet(Sheet);
		int totalRow=ws.getLastRowNum()+1;
		wb.close();
		return totalRow;
	}
	public static int getCellCount(String filename,String Sheet) throws Exception
	{
		fn=new FileInputStream(filename);
		wb=new XSSFWorkbook(fn);
		ws=wb.getSheet(Sheet);
		int totalCell=ws.getRow(0).getLastCellNum();
		wb.close();
		return totalCell;
	}
	public static String getCellValue(String filename,String Sheet ,int r,int c) throws Exception
	{
		fn=new FileInputStream(filename);
		wb=new XSSFWorkbook(fn);
		ws=wb.getSheet(Sheet);
		cl=wb.getSheet(Sheet).getRow(r).getCell(c);//student,Password123
		wb.close();
		return cl.getStringCellValue();
		
	}


}
