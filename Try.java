import java.io.FileInputStream;

import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    System.setProperty("webdriver.chrome.driver","U:\\בדיקות תוכנה ו תשפב\\הרשטיין תמר\\תרגיל");
		WebDriver driver = new ChromeDriver();
	
		  System.out.println("Enter Company Search value");

	      String SearchValue = System.console().readLine();
	
	      verifyTableCellText(table,0,SearchValue,2,"Country");
	      
        }
	   

	     public String getTableCellTextByXpath(WebElement table, int searchColumn,

	    String searchText, int returnColumnText) throws Exception {

	    	 
        String baseUrl ="file:///U:/%D7%91%D7%93%D7%99%D7%A7%D7%95%D7%AA%20%D7%AA%D7%95%D7%9B%D7%A0%D7%94%20%D7%95%20%D7%AA%D7%A9%D7%A4%D7%91/%D7%94%D7%A8%D7%A9%D7%98%D7%99%D7%99%D7%9F%20%D7%AA%D7%9E%D7%A8/%D7%AA%D7%A8%D7%92%D7%99%D7%9C/codebeautify.html";
	    String filePath ="U:\\בדיקות תוכנה ו תשפב\\הרשטיין תמר\\תרגיל אוטומציה";
		String fileName = "טבלה.xlsx";
	   	String sheetName = "table";
        FileInputStream inputStream = new FileInputStream(filePath+"\\"+fileName);
  	    Workbook excelWorkbook = new XSSFWorkbook(inputStream);	    
  	    Sheet excelSheet = excelWorkbook.getSheet(sheetName);


	try{
		WebDriver driver;

	        driver.get(baseUrl);
	        String innerText = driver.findElement(By.xpath("//table/tbody/tr/td[searchColumn].tr[searchColumn].*[contains(text(),searchText)]")).getText();

	        System.out.println(innerText);

	        driver.quit();

	return innerText;

	}

	catch (Exception e) {

	            e.printStackTrace();

	        }

	     }

	     public boolean verifyTableCellText(WebElement table, int searchColumn,

	String searchText, int returnColumnText, String expectedText) 

	{

	     String result=getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);


	if (result!=expectedText)

	return  false;

	else return true;

	}
	     

}

}