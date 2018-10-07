package net.wangxinli.mengniutestcase0718;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumUtils {
	/**
	 * 页面的滑动（上、下、左、右）
	 * @param driver
	 * @param direction
	 */
	public static void pageSwipe(AndroidDriver<AndroidElement> driver,String direction){
		int width=driver.manage().window().getSize().getWidth();
		int height=driver.manage().window().getSize().getHeight();
		TouchAction touch=new TouchAction(driver);
		switch (direction.toLowerCase()) {
		case "up":
			touch.press(width/2, height*5/8).waitAction(Duration.ofMillis(2000)).moveTo(width/2, height*3/8).release().perform();
			break;
		case "down":
			touch.press(width/2, height*3/8).waitAction(Duration.ofMillis(2000)).moveTo(width/2, height*5/8).release().perform();
			break;
		case "left":
			touch.press(width*5/8, height/2).waitAction(Duration.ofMillis(2000)).moveTo(width*3/8, height/2).release().perform();
			break;
		case "right":
			touch.press(width*3/8, height/2).waitAction(Duration.ofMillis(2000)).moveTo(width*5/8, height/2).release().perform();
			break;
		default:
			break;
		}
	}
	/**
	 * 判断元素是否存在
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElementsExist(AndroidDriver<AndroidElement> driver,By by){
		try{
			driver.findElement(by);
			System.out.println("元素存在！");
			return true;
		}catch(Exception e){
			System.out.println("元素不存在！");
		}
		return false;
	}
	/**
	 * 获取元素的结束点坐标
	 * @param ele
	 * @return
	 */
	public static Point getEndLocation(AndroidElement ele){
		int start_x=ele.getLocation().getX();
		int start_y=ele.getLocation().getY();
		int width=ele.getSize().getWidth();
		int height=ele.getSize().getHeight();
		
		int end_x=start_x+width;
		int end_y=start_y+height;
		return new Point(end_x,end_y);
	}
	/**
	 * 在垂直方向上判断是否被遮挡，是Y轴方向的大小比较
	 * @param ele1
	 * @param ele2
	 * @param direction
	 * @return
	 */
	public static boolean elementIsOcclusion(AndroidElement ele1,AndroidElement ele2,String direction){
		int ele1_start_y=ele1.getLocation().getY();
		int ele2_end_y=getEndLocation(ele2).getY();
		
		int ele2_start_y=ele2.getLocation().getY();
		int ele1_end_y=getEndLocation(ele1).getY();

		if(direction.toLowerCase().equals("up")){
			if(ele2_end_y>ele1_start_y){
				return true;
			}else{
				return false;
			}
		}else if(direction.toLowerCase().equals("down")){
			if(ele2_start_y>ele1_end_y){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}		
		
	}
	/**
	 * 当senkeys在输入一连串数字出问题的时候可以尝试使用该方法
	 * @param driver
	 * @param number
	 */
	public static void sendKeyNumber(AndroidDriver<AndroidElement> driver,String number){
		char[] charArray=number.toCharArray();
		for(char c:charArray){
			int cNum=Integer.valueOf(String.valueOf(c));
			switch (cNum) {
			case 0:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
				break;
			case 1:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_1);
				break;
			case 2:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
				break;
			case 3:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
				break;
			case 4:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
				break;
			case 5:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_5);
				break;
			case 6:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_6);
				break;
			case 7:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_7);
				break;
			case 8:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_8);
				break;
			case 9:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_9);
				break;
			default:
				break;
			}
		}
		
	}
	/**
	 * 元素的滑动（上、下、左、右）
	 * @param ele
	 * @param driver
	 * @param direction
	 */
	public static void elementSwipe(AndroidElement ele,AndroidDriver<AndroidElement> driver,String direction){
		int start_x=ele.getLocation().getX();
		int start_y=ele.getLocation().getY();
		
		int width=ele.getSize().getWidth();
		int height=ele.getSize().getHeight();
		
		TouchAction touch=new TouchAction(driver);
		
		switch (direction.toLowerCase()) {
		case "up":
			touch.press(start_x+width/2, start_y+height*5/8).waitAction(Duration.ofMillis(2000)).moveTo(start_x+width/2, start_y+height*3/8).release().perform();
			break;
		case "down":
			touch.press(start_x+width/2, start_y+height*3/8).waitAction(Duration.ofMillis(2000)).moveTo(start_x+width/2, start_y+height*5/8).release().perform();
			break;
		case "left":
			touch.press(start_x+width*5/8, start_y+height/2).waitAction(Duration.ofMillis(2000)).moveTo(start_x+width*3/8, start_y+height/2).release().perform();
			break;
		case "right":
			touch.press(start_x+width*3/8, start_y+height/2).waitAction(Duration.ofMillis(2000)).moveTo(start_x+width*5/8, start_y+height/2).release().perform();
			break;
		default:
			break;
		}
	}
	/**
	 * 订单日历的滑动
	 * @param driver
	 * @param ele
	 */
	public static void canlendarSwipe(AndroidDriver<AndroidElement> driver,AndroidElement ele){
		int width=ele.getSize().getWidth();
		int height=ele.getSize().getHeight();
		
		int start_x=ele.getCenter().getX();
		int start_y=ele.getCenter().getY();
		
		int end_x=start_x;
		int end_y=start_y+height/5;
		TouchAction touch=new TouchAction(driver);
		touch.press(start_x, start_y).waitAction(Duration.ofMillis(2000)).moveTo(end_x, end_y).release().perform();
	}
	//通过package和activity在测试过程启动其他app或者app本身
	public static void startActivity(AndroidDriver<AndroidElement> driver,String appPackage,String appActivity){
		Activity activity=new Activity(appPackage, appActivity);
		driver.startActivity(activity);
	}
}
