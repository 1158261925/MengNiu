package net.wangxinli.testng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.wangxinli.mengniutestcase0718.InitDriver;
import net.wangxinli.mengniutestcase0718.MengNiuTestCase;
import net.wangxinli.mengniutestcase0718.StartServer;

public class TestngCase2 {
	MengNiuTestCase testcase;
	AndroidDriver<AndroidElement> driver;
	StartServer server;
	@BeforeClass
	@Parameters({"udid","port","bport"})
	public void init(String udid,String port,String bport) throws Exception{
		server=new StartServer();
		server.startAppium(port,bport);
		driver=InitDriver.initDriverWithInstall(udid, "mengniu.net.winchannel.winsfa", "mengniu.net.winchannel.winsfa.ui.login.LoginActivity",port);
		testcase=new MengNiuTestCase(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void login(){
		try {
			testcase.login();
			Assert.assertEquals(driver.getPageSource().contains("ÏßÄÚÎ´°Ý·Ã"), true,"----->login failure!");
		} catch (Exception e) {
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/failure-exception.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("µÇÂ¼Ê§°Ü-exception");
		} catch (Error er) {
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/failure-error.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.fail("µÇÂ¼Ê§°Ü-error");
		}
	}
	@AfterClass
	public void stopProject(){
		driver.quit();
		server.stopAppium();
	}
}
