package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import TestCases.ExtentManager;

public class BaseClass {
 public static WebDriver driver;

 @BeforeSuite
 public void BeforeSuite() {
  ExtentManager.setExtent();
 }
 
 @AfterSuite
 public void AfterSuite() {
  ExtentManager.endReport();
 }
 
 @BeforeMethod
 public void setup() {
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe"); 
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--remote-allow-origins=*");
     driver = new ChromeDriver(options);
     driver.manage().window().maximize();	
 	driver.get("https://knowindia.india.gov.in/independence-day-celebration/"); 
 }
 
 @AfterMethod
 public void tearDown() throws IOException {
  driver.close();
 } 
 
 public static String screenShot(WebDriver driver,String filename) {
  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
  String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
  File finalDestination= new File(destination);
  try {
   FileUtils.copyFile(source, finalDestination);
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.getMessage();
  }
  return destination;
 }
 
 public static String getCurrentTime() {  
     String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());  
     return currentDate;  
 }  
}
