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
	  * ���ı���ʽ�����ʼ�   
	  * @param mailInfo �����͵��ʼ�����Ϣ   
	  */    
	    public static boolean sendTextMail(MailSenderInfo mailInfo) {    
	      // �ж��Ƿ���Ҫ�����֤    
	    	MyAuthenticator authenticator = null;    
	      Properties pro = mailInfo.getProperties();   
	      if (mailInfo.isValidate()) {    
	      // �����Ҫ�����֤���򴴽�һ��������֤��    
	        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());    
	      }   
	      // �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session    
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
	      try {    
	      // ����session����һ���ʼ���Ϣ    
	      Message mailMessage = new MimeMessage(sendMailSession);    
	      // �����ʼ������ߵ�ַ    
	      Address from = new InternetAddress(mailInfo.getFromAddress());    
	      // �����ʼ���Ϣ�ķ�����    
	      mailMessage.setFrom(from);    
	      // ���������ռ��ߵ�ַ
	      String[] address = mailInfo.getToAddress();
	      // �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��
	      for(int i=0;i < address.length;i++){
		      Address to = new InternetAddress(address[i]);    
		      mailMessage.addRecipient(Message.RecipientType.TO,to);
	      }
	      // �����ʼ���Ϣ������    
	      mailMessage.setSubject(mailInfo.getSubject());    
	      // �����ʼ���Ϣ���͵�ʱ��    
	      mailMessage.setSentDate(new Date());    
	      // �����ʼ���Ϣ����Ҫ����    
	      String mailContent = mailInfo.getContent();    
	      mailMessage.setText(mailContent);    
	      // �����ʼ�    
	      Transport.send(mailMessage);   
	      return true;    
	      } catch (MessagingException ex) {    
	          ex.printStackTrace();    
	      }    
	      return false;    
	    }    
	       
	    /**   
	      * ��HTML��ʽ�����ʼ�   
	      * @param mailInfo �����͵��ʼ���Ϣ   
	      */   
	    public static boolean sendHtmlMail(MailSenderInfo mailInfo){    
	    	// �ж��Ƿ���Ҫ�����֤  
	        MyAuthenticator authenticator = null;  
	        Properties pro = mailInfo.getProperties();  
	        if (mailInfo.isValidate()) {  
	            // �����Ҫ�����֤���򴴽�һ��������֤��  
	            authenticator = new MyAuthenticator(mailInfo.getUserName(),mailInfo.getPassword());  
	        }  
	        // �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session  
	        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);  
	        try {  
	            // ����session����һ���ʼ���Ϣ  
	            Message mailMessage = new MimeMessage(sendMailSession);  
	            // �����ʼ������ߵ�ַ  
	            Address from = new InternetAddress(mailInfo.getFromAddress());  
	            // �����ʼ���Ϣ�ķ�����  
	            mailMessage.setFrom(from);  
	            // ���������ռ��ߵ�ַ
				String[] address = mailInfo.getToAddress();
				// �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��
				for(int i=0;i < address.length;i++){
				    Address to = new InternetAddress(address[i]);    
				    mailMessage.addRecipient(Message.RecipientType.TO,to);
				}
				// �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��  
//	            Address to = new InternetAddress(mailInfo.getToAddress());  
//	            mailMessage.setRecipient(Message.RecipientType.TO, to);  
	            // �����ʼ���Ϣ������  
	            mailMessage.setSubject(mailInfo.getSubject());  
	            // �����ʼ���Ϣ���͵�ʱ��  
	            mailMessage.setSentDate(new Date());  
	            // �����ʼ���Ϣ����Ҫ����  
	            String mailContent = mailInfo.getContent();  
	            mailMessage.setContent(mailContent, "text/html;charset=gb2312");  
	  
	            // MiniMultipart����һ�������࣬����MimeBodyPart���͵Ķ���  
	            Multipart mainPart = new MimeMultipart();  
	            // ����һ������HTML���ݵ�MimeBodyPart  
	            BodyPart html = new MimeBodyPart();  
	            // ����HTML����  
	            html.setContent(mailInfo.getContent(), "text/html; charset=GBK"); 
	            html.setText(mailInfo.getContent());
	            mainPart.addBodyPart(html);  
	              
	            // Ϊ�ʼ���Ӹ���  
	            String[] attachFileNames = mailInfo.getAttachFileNames();  
	            if (attachFileNames != null && attachFileNames.length > 0) {  
	                // ����ʼ�������MimeBodyPart  
	                MimeBodyPart attachment = null;  
	                File file = null;  
	                for (int i = 0; i < attachFileNames.length; i++) {  
	                    attachment = new MimeBodyPart();  
	                    // ���ݸ����ļ������ļ�����Դ  
	                    file = new File(attachFileNames[i]);  
	                    FileDataSource fds = new FileDataSource(file);  
	                    attachment.setDataHandler(new DataHandler(fds));  
	                    // Ϊ���������ļ���  
	                    attachment.setFileName(file.getName());  
	                    attachment.setContentID(file.getName().replace(".jpg", "").replace(".png", ""));  
	                    mainPart.addBodyPart(attachment);  
	                }  
	            }  
	            // ��MiniMultipart��������Ϊ�ʼ�����  
	            mailMessage.setContent(mainPart);  
	  
	  
	            // �����ʼ�  
	            Transport.send(mailMessage);  
	            return true;  
	        } catch (MessagingException ex) {  
	            ex.printStackTrace();  
	        }  
	        return false;  
	    }  
}
