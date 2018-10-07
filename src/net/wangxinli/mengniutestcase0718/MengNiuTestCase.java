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
	 * ��¼�ű������жϵ�¼�Ƿ�ɹ�
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
		AndroidElement ele1=(AndroidElement)wait.until(ExpectedConditions.presenceOfElementLocated(By.name("����δ�ݷ�")));
		AppiumUtils.isElementsExist(driver, By.name("����δ�ݷ�"));
	}
	/**
	 * �޸��ŵ���Ϣ�������ŵ�
	 * @throws Exception 
	 */
	public void storeInfo() throws Exception{
		//�޸��ŵ���Ϣ
		driver.findElement(By.name("�ŵ���Ϣ")).click();
		int i=0;
		while(i<=10){
			try{
				driver.findElement(By.name("Appium���Ե�һ�ŵ�")).click();
				break;
			}catch(Exception e){
				AppiumUtils.pageSwipe(driver, "up");
				i++;
			}
		}
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@text='ʡ��*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='�У�*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='����*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		driver.findElement(By.xpath("//*[@text='����']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		driver.findElement(By.xpath("//*[@text='һ��������*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(1).click();
		driver.findElement(By.xpath("//*[@text='����������*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(2).click();
		driver.findElement(By.xpath("//*[@text='����������*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(0).click();
		int a=0;
		while(a<=5){
			try{
				driver.findElement(By.name("����"));
				break;
			}catch(Exception e){
				AppiumUtils.pageSwipe(driver, "up");
				a++;
			}
		}
		driver.findElement(By.xpath("//*[@text='�ŵ����ͣ�*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		ArrayList<AndroidElement> list_1=(ArrayList<AndroidElement>)driver.findElements(By.xpath("//*[@text='�Ƿ�ֱӪ��*']/following-sibling::*/*"));
		for(AndroidElement radio:list_1){
			String text=radio.getText();
			String checkValue=radio.getAttribute("checked");
			if(checkValue.equals("true")){
				continue;
			}else{
				radio.click();
				String newcheckValue=radio.getAttribute("checked");
				if(checkValue.equals("false")&&newcheckValue.equals("true")){
					System.out.println("�Ƿ�ֱӪ---->ѡ��Ϊ"+text+"�ɹ���");
				}else{
					System.out.println("�Ƿ�ֱӪ---->ѡ��Ϊ"+text+"ʧ�ܣ�");
				}
			}
		}
		driver.findElement(By.xpath("//*[@text='�ŵ������']/following-sibling::*/*")).clear();
		driver.findElement(By.xpath("//*[@text='�ŵ������']/following-sibling::*/*")).sendKeys("200");
		driver.findElement(By.xpath("//*[@text='�۵�ֲ���*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		AndroidElement person=driver.findElement(By.xpath("//*[@text='��ϵ�ˣ�*']/following-sibling::*/*"));
		if(person.getAttribute("text").equals("")){
			person.sendKeys("������");
		}else{
			person.clear();
			person.sendKeys("������");
		}
		AndroidElement phoneNumber=driver.findElement(By.xpath("//*[@text='�ֻ��ţ�']/following-sibling::*/*"));
		phoneNumber.clear();
		AppiumUtils.sendKeyNumber(driver, "13522531111");
		AndroidElement quhao=driver.findElement(By.xpath("//*[@text='�����ţ�']/following-sibling::*/*"));
		if(quhao.getAttribute("text").equals("")){
			AppiumUtils.sendKeyNumber(driver,"010");
		}else{
			quhao.clear();
			AppiumUtils.sendKeyNumber(driver, "010");
		}
		AndroidElement telephone=driver.findElement(By.xpath("//*[@text='�����ţ�']/parent::*/parent::*/following-sibling::*[2]/*[1]/child::*/child::*"));
		if(telephone.getAttribute("text").equals("")){
			AppiumUtils.sendKeyNumber(driver, "4683111");
		}else{
			telephone.clear();
			AppiumUtils.sendKeyNumber(driver, "4683111");
		}
		List<AndroidElement> storeStates=driver.findElements(By.xpath("//*[@text='�ŵ�״̬��']/following-sibling::*/*"));
		if(storeStates.get(0).getAttribute("checked").equals("false")){
			storeStates.get(0).click();
			try{
				storeStates.get(0).getAttribute("checked").equals("true");
				System.out.println("�ŵ꽻�׳ɹ���");
			}catch(Exception e){
				System.out.println("�ŵ꽻��ʧ�ܣ�");
			}
		}else{
			storeStates.get(1).click();
			try{
				storeStates.get(1).getAttribute("checked").equals("true");
				System.out.println("�ŵ�رճɹ���");
			}catch(Exception e){
				System.out.println("�ŵ�ر�ʧ�ܣ�");
			}
		}
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/photo_btn")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/button_capture")).click();
		driver.findElement(By.name("ʹ����Ƭ")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/button_layout")).click();
		Thread.sleep(12000);
		AppiumUtils.isElementsExist(driver, By.id("mengniu.net.winchannel.winsfa:id/search_edit"));
		//�����ŵ�
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/right_textview")).click();
		for(int j=0;j<3;j++){
			driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/zoom_down_iv")).click();
			Thread.sleep(3000);
		}
		AndroidElement map=driver.findElement(By.xpath("//*[@resource-id='mengniu.net.winchannel.winsfa:id/coverlayout']/following-sibling::*[1]"));
		AppiumUtils.elementSwipe(map, driver, "right");
		
		driver.findElement(By.xpath("//*[@text='ʡ��*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='�У�*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/select_icon")).click();
		driver.findElement(By.xpath("//*[@text='����*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		driver.findElement(By.xpath("//*[@text='����']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		AndroidElement gagaga=driver.findElement(By.xpath("//*[@text='�ŵ����ƣ�*']/following-sibling::*/*"));
		gagaga.click();
		gagaga.sendKeys("Appium���Ե�һ�ŵ�");
		driver.findElement(By.xpath("//*[@text='һ��������*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(1).click();
		driver.findElement(By.xpath("//*[@text='����������*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(2).click();
		driver.findElement(By.xpath("//*[@text='����������*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(0).click();
		int k=0;
		while(k<=5){
			try{
				driver.findElement(By.name("���沢�ݷ�"));
				break;
			}catch(Exception e){
				AppiumUtils.pageSwipe(driver, "up");
				k++;
			}
		}
		driver.findElement(By.xpath("//*[@text='�ŵ����ͣ�*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		ArrayList<AndroidElement> list_2=(ArrayList<AndroidElement>)driver.findElements(By.xpath("//*[@text='�Ƿ�ֱӪ��*']/following-sibling::*/*"));
		for(AndroidElement radio:list_2){
			String text1=radio.getText();
			String checkValue1=radio.getAttribute("checked");
			if(checkValue1.equals("true")){
				continue;
			}else{
				radio.click();
				String newcheckValue=radio.getAttribute("checked");
				if(checkValue1.equals("false")&&newcheckValue.equals("true")){
					System.out.println("�Ƿ�ֱӪ---->ѡ��Ϊ"+text1+"�ɹ���");
				}else{
					System.out.println("�Ƿ�ֱӪ---->ѡ��Ϊ"+text1+"ʧ�ܣ�");
				}
			}
		}
		driver.findElement(By.xpath("//*[@text='�ŵ������']/following-sibling::*/*")).clear();
		driver.findElement(By.xpath("//*[@text='�ŵ������']/following-sibling::*/*")).sendKeys("200");
		driver.findElement(By.xpath("//*[@text='�۵�ֲ���*']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(4).click();
		AndroidElement person1=driver.findElement(By.xpath("//*[@text='��ϵ�ˣ�*']/following-sibling::*/*"));
		person1.click();
		person1.sendKeys("��ɣ");
		AndroidElement phoneNumber1=driver.findElement(By.xpath("//*[@text='�ֻ��ţ�']/following-sibling::*/*"));
		phoneNumber1.click();
		AppiumUtils.sendKeyNumber(driver, "13522531111");
		AndroidElement quhao1=driver.findElement(By.xpath("//*[@text='�����ţ�']/following-sibling::*/*"));
		quhao1.click();
		AppiumUtils.sendKeyNumber(driver,"010");
		AndroidElement telephone1=driver.findElement(By.xpath("//*[@text='�����ţ�']/parent::*/parent::*/following-sibling::*[2]/*[1]/child::*/child::*"));
		telephone1.click();
		AppiumUtils.sendKeyNumber(driver, "4683111");
		driver.findElement(By.xpath("//*[@text='����Ա']/following-sibling::*/*/*/*[3]")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/text_view")).get(1).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/photo_btn")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/button_capture")).click();
		driver.findElement(By.name("ʹ����Ƭ")).click();
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/button_layout")).get(0).click();
		Thread.sleep(8000);
		AppiumUtils.isElementsExist(driver, By.id("mengniu.net.winchannel.winsfa:id/search_edit"));
	}
	/*
	 * ���±���
	 */
	public void preparation() throws Exception{
		driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/tab_home_imageview")).get(1).click();
		driver.findElement(By.name("���±���")).click();
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/right_textview")).click();
		Thread.sleep(3000);
		if(driver.getPageSource().contains("������")){
			System.out.println("�������±���ҳ��򿪳ɹ�");
		}else{
			System.out.println("�������±���ҳ���ʧ��");
		}
		List<AndroidElement> checks=driver.findElements(By.xpath("//android.widget.CheckBox"));
		checks.get(3).click();
		checks.get(7).click();
		AndroidElement beizhu=driver.findElement(By.xpath("//*[@text='��ע']/following-sibling::*/*"));
		beizhu.clear();
		beizhu.sendKeys("Ҧ֮�����������仪");
		driver.findElementById("mengniu.net.winchannel.winsfa:id/right_textview").click();
		Thread.sleep(4000);
		List<AndroidElement> liebiao=driver.findElements(By.id("mengniu.net.winchannel.winsfa:id/name_text_view"));
		liebiao.get(0).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mengniu.net.winchannel.winsfa:id/back_button")).click();
		Thread.sleep(4000);
	}
}
