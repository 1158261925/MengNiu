package net.wangxinli.mengniutestcase0718;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class InitDriver {
	/**
	 * 公共参数部分
	 * @param udid
	 * @return
	 */
	public static DesiredCapabilities getCommons(String udid){
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "安卓设备");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1800);
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		caps.setCapability(MobileCapabilityType.UDID, udid);
		return caps;
	}
	
	/**
	 * 打开已安装的app，起始activity与等待后的activity一致的情况下使用
	 * @param udid
	 * @param appPackage
	 * @param appAcitivity
	 * @return
	 * @throws Exception
	 */
	public static AndroidDriver<AndroidElement> initDriverWithInstall(String udid,String appPackage,String appAcitivity) throws Exception{
		DesiredCapabilities caps=InitDriver.getCommons(udid);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appAcitivity);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;	
	}
	/**
	 * 打开已安装的app，起始activity与等待后的activity不一致的情况下使用
	 * @param udid
	 * @param appPackage
	 * @param appActivity
	 * @param appWaitActivity
	 * @return
	 * @throws Exception
	 */
	public static AndroidDriver<AndroidElement> initDriverWithInstall(String udid,String appPackage,String appActivity,String appWaitActivity) throws Exception{
		DesiredCapabilities caps=InitDriver.getCommons(udid);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, appWaitActivity);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
}
