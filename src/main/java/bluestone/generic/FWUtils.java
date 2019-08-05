package bluestone.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWUtils {
	static String s="";
	static int rc;
	
	public static String get_XLData(String path, String sheet, int r, int c){
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			s=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		return s;
	}
	
	public static int get_XLRowCount(String path, String sheet, int r, int c, String v){
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc =wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		return rc;
	}
	
	public static void set_XLData(String path, String sheet, int r, int c, int v){
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			Sheet sh = wb.getSheet(sheet);
			Row row = sh.getRow(r);
			if(row==null)
				row = sh.createRow(r);
			Cell cell = row.createCell(c);
			cell.setCellValue(v);
			wb.write(new FileOutputStream(path));
		}
		catch(Exception e){
			e.printStackTrace();			
		}
	}
	
	public static void takeScreenshot(WebDriver driver, String path){
		try{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path);
			FileUtils.copyFile(src, des);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
