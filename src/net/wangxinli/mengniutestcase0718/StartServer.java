package net.wangxinli.mengniutestcase0718;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartServer {
	public static AppiumDriverLocalService service;
	public static void startAppium(){
		AppiumServiceBuilder ab=new AppiumServiceBuilder();
		ab.withLogFile(new File("logs/appium.log"));
		service=ab.build();	
		service.start();
	}
	public static void stopAppium(){
		service.stop();
	}	
}
