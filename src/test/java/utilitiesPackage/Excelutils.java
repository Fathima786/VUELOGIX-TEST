package utilitiesPackage;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	
	public static int rowCount(String floc,String sheet)
	{
		try
		{
			FileInputStream f=new FileInputStream(floc);
			XSSFWorkbook wb=new XSSFWorkbook(f);
			return wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public static String cellValue(String floc,String sheet,int row,int col) throws IOException 
	{
		try
		{
		FileInputStream f=new FileInputStream(floc);
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFCell cell=wb.getSheet(sheet).getRow(row).getCell(col);
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		
		else
		{
			return cell.getRawValue();
		}
		}
		catch(Exception e)
		{
			return "";
		}
		
	}

}
