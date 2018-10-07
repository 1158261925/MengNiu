//package net.wangxinli.testng;
//
//import org.testng.annotations.Test;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import net.wangxinli.mengniutestcase0718.AppiumUtils;
//import net.wangxinli.mengniutestcase0718.InitDriver;
//import net.wangxinli.mengniutestcase0718.MengNiuTestCase;
//import net.wangxinli.mengniutestcase0718.SendEmall;
//import net.wangxinli.mengniutestcase0718.StartServer;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;
//
//public class TestngCase {
//	AndroidDriver<AndroidElement> driver;
//	MengNiuTestCase mengniu;
//	String flagResult=null;
//	public static void main(String[] args) {
//			TestngCase test=new TestngCase();
//			test.init();
//			test.login();
//			test.quit();
//	}
//	public void init() {
//		//StartServer.startAppium();
//		try {
//			driver=InitDriver.initDriverWithInstall("127.0.0.1:62001", "mengniu.net.winchannel.winsfa", "mengniu.net.winchannel.winsfa.ui.login.LoginActivity");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mengniu=new MengNiuTestCase(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//	public void login(){
//		try {
//			mengniu.login();
//			Assert.assertEquals(driver.getPageSource().contains("ÏßÄÚÎ´°Ý·Ã"), true, "----->login failure£¡");
//			flagResult="³É¹¦£¡";
//			
//		} catch (Exception e) {
//			File file=driver.getScreenshotAs(OutputType.FILE);
//			try {
//				FileUtils.copyFile(file, new File("images/loginfailure.png"));
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			flagResult="Ê§°Ü£¡";
//		}catch(Error er){
//			File file=driver.getScreenshotAs(OutputType.FILE);
//			try {
//				FileUtils.copyFile(file, new File("images/loginfailure.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			flagResult="Ê§°Ü£¡";
//		}
//	}	
//	public void quit() {
//		driver.quit();
//		SendEmall.sendMail(flagResult);
//		//StartServer.stopAppium();
//	}
//}
