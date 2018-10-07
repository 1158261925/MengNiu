package net.wangxinli.mengniutestcase0718;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SimpleMailSender {
	/**   
	  * 以文本格式发送邮件   
	  * @param mailInfo 待发送的邮件的信息   
	  */    
	    public static boolean sendTextMail(MailSenderInfo mailInfo) {    
	      // 判断是否需要身份认证    
	    	MyAuthenticator authenticator = null;    
	      Properties pro = mailInfo.getProperties();   
	      if (mailInfo.isValidate()) {    
	      // 如果需要身份认证，则创建一个密码验证器    
	        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());    
	      }   
	      // 根据邮件会话属性和密码验证器构造一个发送邮件的session    
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
	      try {    
	      // 根据session创建一个邮件消息    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      // 创建邮件发送者地址    
	      Address from = new InternetAddress(mailInfo.getFromAddress());    
	      // 设置邮件消息的发送者    
	      mailMessage.setFrom(from);    
	      // 接收所有收件者地址
	      String[] address = mailInfo.getToAddress();
	      // 创建邮件的接收者地址，并设置到邮件消息中
	      for(int i=0;i < address.length;i++){
		      Address to = new InternetAddress(address[i]);    
		      mailMessage.addRecipient(Message.RecipientType.TO,to);
	      }
	      // 设置邮件消息的主题    
	      mailMessage.setSubject(mailInfo.getSubject());    
	      // 设置邮件消息发送的时间    
	      mailMessage.setSentDate(new Date());    
	      // 设置邮件消息的主要内容    
	      String mailContent = mailInfo.getContent();    
	      mailMessage.setText(mailContent);    
	      // 发送邮件    
	      Transport.send(mailMessage);   
	      return true;    
	      } catch (MessagingException ex) {    
	          ex.printStackTrace();    
	      }    
	      return false;    
	    }    
	       
	    /**   
	      * 以HTML格式发送邮件   
	      * @param mailInfo 待发送的邮件信息   
	      */   
	    public static boolean sendHtmlMail(MailSenderInfo mailInfo){    
	    	// 判断是否需要身份认证  
	        MyAuthenticator authenticator = null;  
	        Properties pro = mailInfo.getProperties();  
	        if (mailInfo.isValidate()) {  
	            // 如果需要身份认证，则创建一个密码验证器  
	            authenticator = new MyAuthenticator(mailInfo.getUserName(),mailInfo.getPassword());  
	        }  
	        // 根据邮件会话属性和密码验证器构造一个发送邮件的session  
	        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);  
	        try {  
	            // 根据session创建一个邮件消息  
	            Message mailMessage = new MimeMessage(sendMailSession);  
	            // 创建邮件发送者地址  
	            Address from = new InternetAddress(mailInfo.getFromAddress());  
	            // 设置邮件消息的发送者  
	            mailMessage.setFrom(from);  
	            // 接收所有收件者地址
				String[] address = mailInfo.getToAddress();
				// 创建邮件的接收者地址，并设置到邮件消息中
				for(int i=0;i < address.length;i++){
				    Address to = new InternetAddress(address[i]);    
				    mailMessage.addRecipient(Message.RecipientType.TO,to);
				}
				// 创建邮件的接收者地址，并设置到邮件消息中  
//	            Address to = new InternetAddress(mailInfo.getToAddress());  
//	            mailMessage.setRecipient(Message.RecipientType.TO, to);  
	            // 设置邮件消息的主题  
	            mailMessage.setSubject(mailInfo.getSubject());  
	            // 设置邮件消息发送的时间  
	            mailMessage.setSentDate(new Date());  
	            // 设置邮件消息的主要内容  
	            String mailContent = mailInfo.getContent();  
	            mailMessage.setContent(mailContent, "text/html;charset=gb2312");  
	  
	            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象  
	            Multipart mainPart = new MimeMultipart();  
	            // 创建一个包含HTML内容的MimeBodyPart  
	            BodyPart html = new MimeBodyPart();  
	            // 设置HTML内容  
	            html.setContent(mailInfo.getContent(), "text/html; charset=GBK"); 
	            html.setText(mailInfo.getContent());
	            mainPart.addBodyPart(html);  
	              
	            // 为邮件添加附件  
	            String[] attachFileNames = mailInfo.getAttachFileNames();  
	            if (attachFileNames != null && attachFileNames.length > 0) {  
	                // 存放邮件附件的MimeBodyPart  
	                MimeBodyPart attachment = null;  
	                File file = null;  
	                for (int i = 0; i < attachFileNames.length; i++) {  
	                    attachment = new MimeBodyPart();  
	                    // 根据附件文件创建文件数据源  
	                    file = new File(attachFileNames[i]);  
	                    FileDataSource fds = new FileDataSource(file);  
	                    attachment.setDataHandler(new DataHandler(fds));  
	                    // 为附件设置文件名  
	                    attachment.setFileName(file.getName());  
	                    attachment.setContentID(file.getName().replace(".jpg", "").replace(".png", ""));  
	                    mainPart.addBodyPart(attachment);  
	                }  
	            }  
	            // 将MiniMultipart对象设置为邮件内容  
	            mailMessage.setContent(mainPart);  
	  
	  
	            // 发送邮件  
	            Transport.send(mailMessage);  
	            return true;  
	        } catch (MessagingException ex) {  
	            ex.printStackTrace();  
	        }  
	        return false;  
	    }  
}
