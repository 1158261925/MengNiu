package net.wangxinli.testng;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.wangxinli.mengniutestcase0718.InitDriver;

public class Main {
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithInstall("127.0.0.1:62001", "mengniu.net.winchannel.winsfa", "mengniu.net.winchannel.winsfa.ui.login.LoginActivity","4723");
	}
}
