package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestCases.BaseClass;
import TestCases.ExtentManager;

public class OrangeHRMTest extends BaseClass {
 
 @Test
 public void loginPageTest() {
  
  System.out.println(" login page ");
  SoftAssert assertion =new  SoftAssert();
  assertion.assertEquals(true, false);
  assertion.assertAll();
 }
 @Test
 public void loginTest() {
  System.out.println(" Login Test");
 }
 @Test
 public void sampleCase() {
 System.out.println(" Sample case");
 }
}
