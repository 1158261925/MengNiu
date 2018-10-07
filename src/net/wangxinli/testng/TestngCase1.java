package net.wangxinli.testng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.wangxinli.mengniutestcase0718.AppiumUtils;
import net.wangxinli.mengniutestcase0718.InitDriver;
import net.wangxinli.mengniutestcase0718.MengNiuTestCase;

public class TestngCase1 {
	AndroidDriver<AndroidElement> driver;
	MengNiuTestCase testcase;
	@BeforeClass
	public void init(){
		try {
			driver=InitDriver.initDriverWithInstall("127.0.0.1:62001", "mengniu.net.winchannel.winsfa", "mengniu.net.winchannel.winsfa.ui.login.LoginActivity");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testcase=new MengNiuTestCase(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void test001_login(){
		try {
			testcase.login();
			Assert.assertEquals(driver.getPageSource().contains("����δ�ݷ�"), true,"----->��½��δ�ҵ���Ӧ���ֶ�");
		} catch (Exception e) {
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/loginfalure.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("��½ʧ�ܣ�");
		} catch(Error er){
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/loginfailurer.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.fail("��½ʧ��");
		}
		
	}
	@Test
	public void test002_editStore(){
		try {
			testcase.storeInfo();
		} catch (Exception e) {
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/storeFailure.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("�༭�ŵ�ʧ��");
		}catch(Error er){
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/storeFailures.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.fail("�༭�ŵ�ʧ��");
		}
	}
	@Test
	public void test003_prepare(){
		try {
			testcase.preparation();
		} catch (Exception e) {
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/prepare.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("���±���ʧ��");
		}catch(Error er){
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/prepares.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.fail("���±���ʧ��");
		}
	}
	@AfterMethod
	public void restart(){
		AppiumUtils.startActivity(driver, appPackage, appActivity);
	}
	
}
