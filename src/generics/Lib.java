package generics;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Lib implements IAutoConstant{
	public static Workbook wb;
	public static String getcellValue(String Sheet,int row,int column){
		String cellValue ="";
		try{
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue=wb.getSheet(Sheet).getRow(row).getCell(column).toString();
		}catch(Exception e){
		}
		return cellValue;
	}

	public static int getrowCount(String sheet){
		int rowCount=0;
		try{
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount=wb.getSheet(sheet).getLastRowNum();
		}catch(Exception e){
		}
		return rowCount;
	}

	public static String getPropertyValue(String key){
		String propertyValue ="";
		Properties prop=new Properties();
		try{
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue=prop.getProperty(key);
		}catch(Exception e){
		}
		return propertyValue;
	}

	public static void captureScreenshots(WebDriver driver,String testCaseName){
		try{
			Date d = new Date();
			String currentDate = d.toString().replaceAll(":","_");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./screenshots/"+"_"+testCaseName+currentDate+"_"+".png");
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e){
		}
	}
}