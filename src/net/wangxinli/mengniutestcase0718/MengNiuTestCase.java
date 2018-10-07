package net.wangxinli.mengniutestcase0718;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MengNiuTestCase {
	AndroidDriver<AndroidElement> driver;
	public MengNiuTestCase(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	/**
	 * 登录脚本，并判断登录是否成功
	 * @throws Exception
	 */
	public void login() throws Exception{
		AndroidElement userName=driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/user_name_edit_text"));
		userName.sendKeys("xieqin");
		AndroidElement password=driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/password_edit_text"));
		password.sendKeys("1111");
		AndroidElement loginButton=driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/login_button"));
		loginButton.click();
		WebDriverWait wait=new WebDriverWait(driver, 15);
		AndroidElement ele1=(AndroidElement)wait.until(ExpectedConditions.presenceOfElementLocated(By.name("线内未拜访")));
		AppiumUtils.isElementsExist(driver, By.name("线内未拜访"));
	}
	/**
	 * 修改门店信息，新增门店
	 * @throws Exception 
	 */
	public void storeInfo() throws Exception{
		//修改门店信息
		driver.findElement(By.name("门店信息")).click();
		int i=0;
		while(i<=10){
			try{
				driver.findElement(By.name("Appium测试第一门店")).click();
				break;
			}catch(Exception e){
				AppiumUtils.pageSwipe(driver, "up");
				i++;
			}
		}
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@text='省：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='市：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='区：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		driver.findElement(By.xpath("//*[@text='乡镇：']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		driver.findElement(By.xpath("//*[@text='一级渠道：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(1).click();
		driver.findElement(By.xpath("//*[@text='二级渠道：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(2).click();
		driver.findElement(By.xpath("//*[@text='三级渠道：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(0).click();
		int a=0;
		while(a<=5){
			try{
				driver.findElement(By.name("保存"));
				break;
			}catch(Exception e){
				AppiumUtils.pageSwipe(driver, "up");
				a++;
			}
		}
		driver.findElement(By.xpath("//*[@text='门店类型：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		ArrayList<AndroidElement> list_1=(ArrayList<AndroidElement>)driver.findElements(By.xpath("//*[@text='是否直营：*']/following-sibling::*/*"));
		for(AndroidElement radio:list_1){
			String text=radio.getText();
			String checkValue=radio.getAttribute("checked");
			if(checkValue.equals("true")){
				continue;
			}else{
				radio.click();
				String newcheckValue=radio.getAttribute("checked");
				if(checkValue.equals("false")&&newcheckValue.equals("true")){
					System.out.println("是否直营---->选择为"+text+"成功！");
				}else{
					System.out.println("是否直营---->选择为"+text+"失败！");
				}
			}
		}
		driver.findElement(By.xpath("//*[@text='门店面积：']/following-sibling::*/*")).clear();
		driver.findElement(By.xpath("//*[@text='门店面积：']/following-sibling::*/*")).sendKeys("200");
		driver.findElement(By.xpath("//*[@text='售点分布：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		AndroidElement person=driver.findElement(By.xpath("//*[@text='联系人：*']/following-sibling::*/*"));
		if(person.getAttribute("text").equals("")){
			person.sendKeys("马三立");
		}else{
			person.clear();
			person.sendKeys("马三立");
		}
		AndroidElement phoneNumber=driver.findElement(By.xpath("//*[@text='手机号：']/following-sibling::*/*"));
		phoneNumber.clear();
		AppiumUtils.sendKeyNumber(driver, "13522531111");
		AndroidElement quhao=driver.findElement(By.xpath("//*[@text='座机号：']/following-sibling::*/*"));
		if(quhao.getAttribute("text").equals("")){
			AppiumUtils.sendKeyNumber(driver,"010");
		}else{
			quhao.clear();
			AppiumUtils.sendKeyNumber(driver, "010");
		}
		AndroidElement telephone=driver.findElement(By.xpath("//*[@text='座机号：']/parent::*/parent::*/following-sibling::*[2]/*[1]/child::*/child::*"));
		if(telephone.getAttribute("text").equals("")){
			AppiumUtils.sendKeyNumber(driver, "4683111");
		}else{
			telephone.clear();
			AppiumUtils.sendKeyNumber(driver, "4683111");
		}
		List<AndroidElement> storeStates=driver.findElements(By.xpath("//*[@text='门店状态：']/following-sibling::*/*"));
		if(storeStates.get(0).getAttribute("checked").equals("false")){
			storeStates.get(0).click();
			try{
				storeStates.get(0).getAttribute("checked").equals("true");
				System.out.println("门店交易成功！");
			}catch(Exception e){
				System.out.println("门店交易失败！");
			}
		}else{
			storeStates.get(1).click();
			try{
				storeStates.get(1).getAttribute("checked").equals("true");
				System.out.println("门店关闭成功！");
			}catch(Exception e){
				System.out.println("门店关闭失败！");
			}
		}
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/photo_btn")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/button_capture")).click();
		driver.findElement(By.name("使用照片")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/button_layout")).click();
		Thread.sleep(12000);
		AppiumUtils.isElementsExist(driver, By.id("mengniu.net.winchannel.winsfa:id/search_edit"));
		//新增门店
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/right_textview")).click();
		for(int j=0;j<3;j++){
			driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/zoom_down_iv")).click();
			Thread.sleep(3000);
		}
		AndroidElement map=driver.findElement(By.xpath("//*[@resource-id='mengniu.net.winchannel.winsfa:id/coverlayout']/following-sibling::*[1]"));
		AppiumUtils.elementSwipe(map, driver, "right");
		
		driver.findElement(By.xpath("//*[@text='省：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='市：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='区：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		driver.findElement(By.xpath("//*[@text='乡镇：']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		AndroidElement gagaga=driver.findElement(By.xpath("//*[@text='门店名称：*']/following-sibling::*/*"));
		gagaga.click();
		gagaga.sendKeys("Appium测试第一门店");
		driver.findElement(By.xpath("//*[@text='一级渠道：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(1).click();
		driver.findElement(By.xpath("//*[@text='二级渠道：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(2).click();
		driver.findElement(By.xpath("//*[@text='三级渠道：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(0).click();
		int k=0;
		while(k<=5){
			try{
				driver.findElement(By.name("保存并拜访"));
				break;
			}catch(Exception e){
				AppiumUtils.pageSwipe(driver, "up");
				k++;
			}
		}
		driver.findElement(By.xpath("//*[@text='门店类型：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		ArrayList<AndroidElement> list_2=(ArrayList<AndroidElement>)driver.findElements(By.xpath("//*[@text='是否直营：*']/following-sibling::*/*"));
		for(AndroidElement radio:list_2){
			String text1=radio.getText();
			String checkValue1=radio.getAttribute("checked");
			if(checkValue1.equals("true")){
				continue;
			}else{
				radio.click();
				String newcheckValue=radio.getAttribute("checked");
				if(checkValue1.equals("false")&&newcheckValue.equals("true")){
					System.out.println("是否直营---->选择为"+text1+"成功！");
				}else{
					System.out.println("是否直营---->选择为"+text1+"失败！");
				}
			}
		}
		driver.findElement(By.xpath("//*[@text='门店面积：']/following-sibling::*/*")).clear();
		driver.findElement(By.xpath("//*[@text='门店面积：']/following-sibling::*/*")).sendKeys("200");
		driver.findElement(By.xpath("//*[@text='售点分布：*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		AndroidElement person1=driver.findElement(By.xpath("//*[@text='联系人：*']/following-sibling::*/*"));
		person1.click();
		person1.sendKeys("洛桑");
		AndroidElement phoneNumber1=driver.findElement(By.xpath("//*[@text='手机号：']/following-sibling::*/*"));
		phoneNumber1.click();
		AppiumUtils.sendKeyNumber(driver, "13522531111");
		AndroidElement quhao1=driver.findElement(By.xpath("//*[@text='座机号：']/following-sibling::*/*"));
		quhao1.click();
		AppiumUtils.sendKeyNumber(driver,"010");
		AndroidElement telephone1=driver.findElement(By.xpath("//*[@text='座机号：']/parent::*/parent::*/following-sibling::*[2]/*[1]/child::*/child::*"));
		telephone1.click();
		AppiumUtils.sendKeyNumber(driver, "4683111");
		driver.findElement(By.xpath("//*[@text='配送员']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(1).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/photo_btn")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/button_capture")).click();
		driver.findElement(By.name("使用照片")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/button_layout")).get(0).click();
		Thread.sleep(8000);
		AppiumUtils.isElementsExist(driver, By.id("mengniu.net.winchannel.winsfa:id/search_edit"));
	}
	/*
	 * 公事报备
	 */
	public void preparation() throws Exception{
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/tab_home_imageview")).get(1).click();
		driver.findElement(By.name("公事报备")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/right_textview")).click();
		Thread.sleep(3000);
		if(driver.getPageSource().contains("待审批")){
			System.out.println("新增公事报备页面打开成功");
		}else{
			System.out.println("新增公事报备页面打开失败");
		}
		List<AndroidElement> checks=driver.findElements(By.xpath("//android.widget.CheckBox"));
		checks.get(3).click();
		checks.get(7).click();
		AndroidElement beizhu=driver.findElement(By.xpath("//*[@text='备注']/following-sibling::*/*"));
		beizhu.clear();
		beizhu.sendKeys("姚之妖妖，灼灼其华");
		driver.findElementById("mengniu.net.winchannel.winsfa:id/right_textview").click();
		Thread.sleep(4000);
		List<AndroidElement> liebiao=driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/name_text_view"));
		liebiao.get(0).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/back_button")).click();
		Thread.sleep(4000);
	}
}
