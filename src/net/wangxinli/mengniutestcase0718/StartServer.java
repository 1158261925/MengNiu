package net.wangxinli.mengniutestcase0718;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;

public class StartServer {
	AppiumDriverLocalService service;
	public void startAppium(String port,String bport){
		AppiumServiceBuilder ab=new AppiumServiceBuilder();
		ab.withLogFile(new File("logs/appium"+port+".log"));
		ab.usingPort(Integer.valueOf(port));
		ab.withArgument(new ServerArgument() {
			
			@Override
			public String getArgument() {
				// TODO Auto-generated method stub
				return "-bp";
			}
		}, bport);
		service=ab.build();	
		service.start();
	}
	public void stopAppium(){
		service.stop();
	}	
}
