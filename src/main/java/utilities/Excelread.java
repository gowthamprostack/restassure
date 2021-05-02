package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelread {

	private static XSSFSheet excelWSheet;
	 
	 private static XSSFWorkbook ExcelWBook;
	 
	 private static XSSFCell Cell;
	 
	 private static XSSFRow Row;
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
	
	    String[][] tabArray = null;
		
		
		FileInputStream in=new FileInputStream(FilePath);
		
		ExcelWBook=new XSSFWorkbook(in);
		excelWSheet=ExcelWBook.getSheet(SheetName);
		
		int startrow=1;
		int startcol=0;
		int c1,c2;
		
		int total=excelWSheet.getLastRowNum();
		int columsntcou=excelWSheet.getRow(0).getLastCellNum();
		
		int column=2;
		
		tabArray=new String[total][2];
		
		
		System.out.println(total+"rows");
		
		System.out.println(columsntcou+"columns");
		
		
		c1=0;
	
		for(int i=startrow;i<=total;i++,c1++)
		{
			
			c2=0;
			
			
			for(int j=startcol;j<columsntcou;j++,c2++)
			{
				
				
				tabArray[c1][c2]=getcelldata(i,j);
				
				System.out.println(tabArray[c1][c2]);
			}
			
		
		}
		
		return tabArray;
		
	}
	
	
	
	
	public static String getcelldata(int row,int col)
	{
		
		
		Cell=excelWSheet.getRow(row).getCell(col);
		
		 
			 String CellData = Cell.getStringCellValue();
			 
			 return CellData;
		
		
		
	
	}
	
	
	
	
	@Test
	public void doit() throws Exception
	{
		
		getTableArray("C:\\Users\\Dell\\Desktop\\payload.xlsx","get");
		
		
	}
	
	
}
